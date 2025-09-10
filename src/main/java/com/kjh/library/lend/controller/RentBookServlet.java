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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // ✅ Member 타입으로 꺼내기
        Member loginUser = (Member) session.getAttribute("loginUser");
        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/member/login");
            return;
        }

        // ✅ memberId 추출
        String memberId = loginUser.getMemberId(); // getter 명 확인할 것

        // ✅ 대여 리스트 조회
        List<Rent> rentList = new RentService().selectRentList(memberId);
        request.setAttribute("rentList", rentList);

        // ✅ JSP로 포워딩
        request.getRequestDispatcher("/WEB-INF/views/lend/rentBook.jsp")
               .forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
