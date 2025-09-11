package com.kjh.library.lend.controller;

import com.kjh.library.lend.model.service.RentService;
import com.kjh.library.lend.model.vo.Rent;
import com.kjh.library.member.model.vo.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/member/rentBook")
public class RentBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RentBookServlet() {
        super();
    }

    /**
     * 현재 대여중인 도서 목록 조회
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Member loginUser = (Member) session.getAttribute("loginUser");
        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/member/login");
            return;
        }

        String memberId = loginUser.getMemberId();

        // 현재 대여중인 도서 목록 조회 (selectRentList 사용)
        List<Rent> rentList = new RentService().selectRentList(memberId);
        request.setAttribute("rentList", rentList);  // JSP에서 기대하는 속성명

        // 대여도서 JSP로 포워딩
        request.getRequestDispatcher("/WEB-INF/views/lend/rentBook.jsp")
            .forward(request, response);
    }

    /**
     * 도서 대여 처리
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Member loginUser = (Member) session.getAttribute("loginUser");
        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/member/login");
            return;
        }

        String memberId = loginUser.getMemberId();
        String bookNo = request.getParameter("bookNo");

        if (bookNo != null && !bookNo.trim().isEmpty()) {
            try {
                boolean result = new RentService().rentBook(memberId, bookNo);

                if (result) {
                    // 성공 시 도서 목록 페이지로 리다이렉트
                    response.sendRedirect(request.getContextPath() + "/member/bookList");
                } else {
                    request.setAttribute("errorMsg", "도서 대여에 실패했습니다.");
                    request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp")
                        .forward(request, response);
                }

            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("errorMsg", "대여 처리 중 오류가 발생했습니다.");
                request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp")
                    .forward(request, response);
            }
        } else {
            request.setAttribute("errorMsg", "도서 번호가 전달되지 않았습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp")
                .forward(request, response);
        }
    }
}