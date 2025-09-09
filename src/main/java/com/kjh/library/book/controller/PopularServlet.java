package com.kjh.library.book.controller;

import com.kjh.library.book.model.service.BookService;
import com.kjh.library.book.model.vo.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/index")  // 루트 URL
public class PopularServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookService bService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> popularBooks = bService.getPopularBooks(8);  // 상위 8권
        request.setAttribute("popularBooks", popularBooks);

        request.getRequestDispatcher("/WEB-INF/views/main/index.jsp").forward(request, response);
    }
}
