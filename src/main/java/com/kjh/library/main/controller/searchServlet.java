package com.kjh.library.main.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.kjh.library.main.model.service.MainService;
import com.kjh.library.main.model.vo.Main;

@WebServlet("/main/search")
public class searchServlet extends HttpServlet {
    private MainService bookService = new MainService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String keyword = request.getParameter("keyword");
        List<Main> results = bookService.searchBooks(keyword);
        
        request.setAttribute("bookList", results); // ✅ bookList로 변경
        request.getRequestDispatcher("/WEB-INF/views/book/bookSearch.jsp").forward(request, response);
    }
}