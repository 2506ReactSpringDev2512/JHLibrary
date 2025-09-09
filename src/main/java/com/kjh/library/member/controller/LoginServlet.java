package com.kjh.library.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kjh.library.member.model.service.MemberService;
import com.kjh.library.member.model.vo.Member;

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/member/login.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String memberId = request.getParameter("memberId");
        String memberPw = request.getParameter("memberPw"); // 수정됨

        Member member = new Member(memberId, memberPw);
        MemberService mService = new MemberService();
        Member loginUser = mService.checkLogin(member);

        if (loginUser != null) {
            // 로그인 성공 → 세션에 저장 (비밀번호 제외)
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", loginUser);

            // 메인 페이지로 이동
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            // 로그인 실패 → 에러 페이지
            request.setAttribute("errorMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
                   .forward(request, response);
        }
    }
}

