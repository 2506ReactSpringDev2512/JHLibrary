package com.kjh.library.book.model.service;

import com.kjh.library.book.model.dao.BookDAO;
import com.kjh.library.book.model.vo.Book;
import com.kjh.library.member.common.JDBCTemplate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookService {

    private BookDAO bDao = new BookDAO();
    private JDBCTemplate jdbcTemplate = JDBCTemplate.getInstance();

    public List<Book> getPopularBooks(int limit) {
        List<Book> popularBooks = null;
        try (Connection conn = jdbcTemplate.getConnection()) {
            popularBooks = bDao.selectPopularBooks(conn, limit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return popularBooks;
    }
}
