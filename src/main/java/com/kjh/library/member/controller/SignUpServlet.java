package com.kjh.library.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kjh.library.member.model.service.MemberService;
import com.kjh.library.member.model.vo.Member;

@WebServlet("/member/signup")
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SignUpServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 회원가입 페이지로 이동
        request.getRequestDispatcher("/WEB-INF/views/member/signup.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // ✅ 폼 데이터 받기
        String memberId       = request.getParameter("memberId");
        String memberPw       = request.getParameter("memberPw");
        String memberPwConfirm= request.getParameter("memberPwConfirm");
        String memberName     = request.getParameter("memberName");
        String memberPhone    = request.getParameter("memberPhone");
        String memberGender   = request.getParameter("memberGender");
        int memberAge      	  = Integer.parseInt(request.getParameter("memberAge"));

        // ✅ 비밀번호 확인 체크
        if (!memberPw.equals(memberPwConfirm)) {
            request.setAttribute("errorMsg", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
                   .forward(request, response);
            return;
        }

        // ✅ Member 객체 생성 (VO에 맞게 생성자 수정 필요)
        Member member = new Member(memberId, memberPw, memberName, memberPhone, memberGender, memberAge);

        // ✅ DB 저장
        MemberService mService = new MemberService();
        int result = mService.insertMember(member);

        if (result > 0) {
            // 회원가입 성공 → 로그인 페이지로 이동
            response.sendRedirect(request.getContextPath() + "/member/login");
        } else {
            // 회원가입 실패 → 에러 페이지로 이동
            request.setAttribute("errorMsg", "회원 가입이 완료되지 않았습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
                   .forward(request, response);
        }
    }
}
