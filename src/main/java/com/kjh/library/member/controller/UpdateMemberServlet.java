package com.kjh.library.member.controller;

import com.kjh.library.member.model.service.MemberService;
import com.kjh.library.member.model.vo.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/member/update")
public class UpdateMemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MemberService mService = new MemberService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // 세션에서 로그인 사용자 정보 가져오기
        HttpSession session = request.getSession();
        Member loginUser = (Member) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/member/login");
            return;
        }

        // 마이페이지 JSP로 포워딩
        request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Member loginUser = (Member) session.getAttribute("loginUser");

        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/member/login");
            return;
        }

        String newPw = request.getParameter("memberPw");
        String newPhone = request.getParameter("memberPhone");
        int newAge = Integer.parseInt(request.getParameter("memberAge"));

        // 정보 업데이트
        loginUser.setMemberPw(newPw);
        loginUser.setMemberPhone(newPhone);
        loginUser.setMemberAge(newAge);

        int result = mService.updateMember(loginUser);

        if(result > 0) {
            session.setAttribute("loginUser", loginUser); // 세션 업데이트
            request.setAttribute("msg", "정보가 성공적으로 수정되었습니다.");
        } else {
            request.setAttribute("errorMsg", "정보 수정에 실패했습니다.");
        }

        request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(request, response);
    }
}
