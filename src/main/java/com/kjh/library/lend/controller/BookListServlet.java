package com.kjh.library.lend.controller;

import com.kjh.library.lend.model.service.RentService;
import com.kjh.library.lend.model.vo.Rent;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/member/bookList")
public class BookListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BookListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. 서비스 호출하여 도서 목록 조회
        RentService service = new RentService();
        List<Rent> bookList = service.selectAllBooks();  // ← 새로 만들어야 할 메서드

        // 2. JSP로 데이터 전달
        request.setAttribute("bookList", bookList);

        // 3. JSP로 포워딩
        request.getRequestDispatcher("/WEB-INF/views/book/bookList.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
