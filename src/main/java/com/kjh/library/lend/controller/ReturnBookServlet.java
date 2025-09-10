package com.kjh.library.lend.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.kjh.library.lend.model.service.RentService;
import com.kjh.library.lend.model.vo.Rent;
import com.kjh.library.member.model.vo.Member;

/**
 * Servlet implementation class ReturnBookServlet
 */
@WebServlet("/member/returnBook")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Member loginUser = (Member) session.getAttribute("loginUser");
        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/member/login");
            return;
        }

        String memberId = loginUser.getMemberId(); // ← 실제 getter 이름 확인

        List<Rent> rentList = new RentService().selectRentList(memberId);
        request.setAttribute("rentList", rentList);

        request.getRequestDispatcher("/WEB-INF/views/lend/returnBook.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                boolean result = new RentService().returnBook(memberId, bookNo);

                if (result) {
                    response.sendRedirect(request.getContextPath() + "/member/rentBook");
                } else {
                    request.setAttribute("errorMsg", "도서 반납에 실패했습니다.");
                    request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
                }

            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("errorMsg", "반납 처리 중 오류가 발생했습니다.");
                request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMsg", "도서 번호가 전달되지 않았습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
        }
    }

}
