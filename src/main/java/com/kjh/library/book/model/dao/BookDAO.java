package com.kjh.library.book.model.dao;

import com.kjh.library.book.model.vo.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public List<Book> selectPopularBooks(Connection conn, int limit) throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PUBLISHER, LEND_YN, IMAGE_PATH, LEND_COUNT " +
                     "FROM BOOK_TBL " +
                     "ORDER BY LEND_COUNT DESC";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            int count = 0;
            while (rs.next() && count < limit) {
                Book book = rsetToBook(rs);
                books.add(book);
                count++;
            }
        }
        return books;
    }

    private Book rsetToBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setBookNo(rs.getString("BOOK_NO"));
        book.setBookName(rs.getString("BOOK_NAME"));
        book.setBookAuthor(rs.getString("BOOK_AUTHOR"));
        book.setBookPublisher(rs.getString("BOOK_PUBLISHER"));
        book.setLendYn(rs.getString("LEND_YN"));
        book.setImagePath(rs.getString("IMAGE_PATH"));
        book.setLendCount(rs.getInt("LEND_COUNT"));
        return book;
    }
}
