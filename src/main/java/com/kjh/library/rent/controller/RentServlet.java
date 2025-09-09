package com.kjh.library.rent.controller;

import java.io.IOException;
import java.util.List;

import com.kjh.library.member.model.vo.Member;
import com.kjh.library.rent.model.service.RentService;
import com.kjh.library.rent.model.vo.Rent;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/rentList")
public class RentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	RentService rentService = new RentService();
        Member loginUser = (Member) request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/member/login");
            return;
        }

        System.out.println("로그인 유저 ID: " + loginUser.getMemberId());
        
        List<Rent> rentList = rentService.selectRentByMember(loginUser.getMemberId());
        System.out.println("Controller에서 받은 데이터 개수: " + (rentList != null ? rentList.size() : 0));
        
        request.setAttribute("rentList", rentList);
        request.getRequestDispatcher("/WEB-INF/views/member/rentList.jsp").forward(request, response);
    }
}
