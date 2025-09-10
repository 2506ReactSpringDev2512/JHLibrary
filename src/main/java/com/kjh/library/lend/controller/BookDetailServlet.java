package com.kjh.library.lend.controller;

import com.kjh.library.lend.model.dao.RendDAO;
import com.kjh.library.lend.model.vo.Rent;
import com.kjh.library.member.common.JDBCTemplate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/member/bookDetail")
public class BookDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BookDetailServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookNo = request.getParameter("bookNo");

        if (bookNo == null || bookNo.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/member/bookList");
            return;
        }

        Connection conn = null;
        try {
            conn = JDBCTemplate.getInstance().getConnection();

            RendDAO dao = new RendDAO();
            Rent book = dao.selectBookByNo(conn, bookNo);

            if (book != null) {
                request.setAttribute("book", book);
            } else {
                // 해당 도서가 없으면 도서목록으로 리다이렉트
                response.sendRedirect(request.getContextPath() + "/member/bookList");
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
            // 에러시도 도서목록으로 리다이렉트
            response.sendRedirect(request.getContextPath() + "/member/bookList");
            return;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        request.getRequestDispatcher("/WEB-INF/views/book/bookDetail.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
