package com.kjh.library.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kjh.library.member.model.service.MemberService;
import com.kjh.library.member.model.vo.Member;

@WebServlet("/member/findPw")
public class FindPwServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FindPwServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // findPw.jsp 페이지로 이동
        request.getRequestDispatcher("/WEB-INF/views/member/findPw.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // 폼에서 입력받은 memberId와 memberName
        String memberId   = request.getParameter("memberId");
        String memberName = request.getParameter("memberName");

        MemberService service = new MemberService();
        Member member = service.findMemberByIdAndName(memberId, memberName);

        if(member != null) {
            // DB에 저장된 기존 비밀번호 그대로 가져오기
            String memberPw = member.getMemberPw();

            // 결과 메시지 설정
            request.setAttribute("message",
                "회원님의 비밀번호는 [" + memberPw + "] 입니다. 안전하게 관리해주세요.");

            // 결과 페이지로 이동
            request.getRequestDispatcher("/WEB-INF/views/member/findPwResult.jsp")
                   .forward(request, response);
        } else {
            // 회원 정보가 없으면 에러 페이지
            request.setAttribute("errorMsg", "회원 정보를 찾을 수 없습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
                   .forward(request, response);
        }
    }
}
