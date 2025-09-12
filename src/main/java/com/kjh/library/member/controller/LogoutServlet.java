package com.kjh.library.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/member/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LogoutServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1. 세션 가져오기
        HttpSession session = request.getSession(false);
        if (session != null) {
            // 2. 세션 무효화
            session.invalidate();
        }

        // 3. 로그아웃 후 index.jsp로 이동
        response.sendRedirect(request.getContextPath() + "/");
    }
}
