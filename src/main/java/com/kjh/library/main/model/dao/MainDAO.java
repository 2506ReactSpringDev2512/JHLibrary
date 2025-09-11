package com.kjh.library.main.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kjh.library.main.model.vo.Main;
import com.kjh.library.member.common.JDBCTemplate;

public class MainDAO {

    public List<Main> selectLatestBooks(Connection conn) throws SQLException {
        List<Main> bookList = new ArrayList<>();

        String sql = "SELECT BOOK_NO, BOOK_NAME, BOOK_AUTHOR, IMAGE_PATH " +
                     "FROM BOOK_TBL " +
                     "ORDER BY BOOK_NO DESC FETCH FIRST 5 ROWS ONLY";

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Main main = new Main();
                main.setBookNo(rs.getString("BOOK_NO"));
                main.setBookName(rs.getString("BOOK_NAME"));
                main.setBookAuthor(rs.getString("BOOK_AUTHOR"));
                main.setImagePath(rs.getString("IMAGE_PATH"));
                bookList.add(main);
            }
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }
            if (pstmt != null) try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); }
        }

        return bookList;
    }

    public List<Main> searchBooks(String keyword) {
        List<Main> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCTemplate.getInstance().getConnection();
            String sql = "SELECT BOOK_NO, BOOK_NAME, BOOK_AUTHOR, IMAGE_PATH FROM BOOK_TBL WHERE BOOK_NAME LIKE ? OR BOOK_AUTHOR LIKE ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Main book = new Main();
                book.setBookNo(rs.getString("BOOK_NO"));
                book.setBookName(rs.getString("BOOK_NAME"));
                book.setBookAuthor(rs.getString("BOOK_AUTHOR"));
                book.setImagePath(rs.getString("IMAGE_PATH"));
                list.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }
            if (pstmt != null) try { pstmt.close(); } catch(SQLException e) { e.printStackTrace(); }
            if (conn != null) try { conn.close(); } catch(SQLException e) { e.printStackTrace(); }
        }

        return list;
    }
    public List<Main> searchBooks(Connection conn, String keyword) throws SQLException {
        List<Main> list = new ArrayList<>();
        String sql = "SELECT BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PUBLISHER, IMAGE_PATH, DESCRIPTION " +
                     "FROM BOOK_TBL WHERE BOOK_NAME LIKE ? OR BOOK_AUTHOR LIKE ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Main book = new Main();
                    book.setBookNo(rs.getString("BOOK_NO"));
                    book.setBookName(rs.getString("BOOK_NAME"));
                    book.setBookAuthor(rs.getString("BOOK_AUTHOR"));
                    book.setBookPublisher(rs.getString("BOOK_PUBLISHER"));
                    book.setImagePath(rs.getString("IMAGE_PATH"));
                    book.setDescription(rs.getString("DESCRIPTION"));
                    list.add(book);
                }
            }
        }
        return list;
    }
}
