package com.kjh.library.lend.controller;

import com.kjh.library.lend.model.service.RentService;
import com.kjh.library.lend.model.vo.Rent;

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 로그인된 사용자 ID 가져오기
        HttpSession session = request.getSession();
        String memberId = (String) session.getAttribute("loginId");

//        if (memberId == null) {
//            // 로그인 안 되어 있으면 로그인 페이지로 리다이렉트
//            response.sendRedirect(request.getContextPath() + "/login.jsp");
//            return;
//        }

        // 대여 도서 리스트 가져오기
        List<Rent> rentList = new RentService().selectRentList(memberId);

        // request scope에 저장
        request.setAttribute("rentList", rentList);

        // JSP로 포워딩
        request.getRequestDispatcher("/WEB-INF/views/lend/rentBook.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
