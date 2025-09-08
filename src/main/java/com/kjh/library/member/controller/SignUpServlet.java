package com.kjh.library.member.controller;

import com.kjh.library.member.model.service.MemberService;
import com.kjh.library.member.model.vo.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/member/signup")
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SignUpServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 회원가입 화면 열기
        request.getRequestDispatcher("/WEB-INF/views/member/signup.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String memberId = request.getParameter("memberId");
        String memberPw = request.getParameter("memberPw");
        String memberPwConfirm = request.getParameter("memberPwConfirm");
        String memberName = request.getParameter("memberName");
        String memberPhone = request.getParameter("memberPhone");
        String memberGender = request.getParameter("memberGender");
        String memberAgeStr = request.getParameter("memberAge");

        // 비밀번호 확인 체크
        if (!memberPw.equals(memberPwConfirm)) {
            request.setAttribute("errorMsg", "비밀번호가 일치하지 않습니다.");
            request.getRequestDispatcher("/WEB-INF/views/member/signup.jsp")
                   .forward(request, response);
            return;
        }

        int memberAge = 0;
        try {
            memberAge = Integer.parseInt(memberAgeStr);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMsg", "나이는 숫자로 입력해주세요.");
            request.getRequestDispatcher("/WEB-INF/views/member/signup.jsp")
                   .forward(request, response);
            return;
        }

        Member member = new Member(memberId, memberPw, memberName, memberPhone, memberGender, memberAge);
        MemberService mService = new MemberService();
        int result = mService.insertMember(member);

        if (result > 0) {
            // 회원가입 성공 → 로그인 페이지로
            response.sendRedirect(request.getContextPath() + "/member/login");
        } else {
            // 회원가입 실패 → 에러 메시지 보여주고 다시 폼 페이지
            request.setAttribute("errorMsg", "회원가입에 실패했습니다. 다시 입력해주세요.");
            request.getRequestDispatcher("/WEB-INF/views/member/signup.jsp")
                   .forward(request, response);
        }
    }
}
