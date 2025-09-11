package com.kjh.library.main.controller;

import com.kjh.library.main.model.service.MainService;
import com.kjh.library.main.model.vo.Main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/main")
public class mainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private MainService mainService = new MainService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Main> popularBooks = mainService.getLatestBooks();
        request.setAttribute("popularBooks", popularBooks);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}