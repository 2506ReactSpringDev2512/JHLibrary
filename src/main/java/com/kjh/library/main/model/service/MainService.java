package com.kjh.library.main.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kjh.library.main.model.dao.MainDAO;
import com.kjh.library.main.model.vo.Main;
import com.kjh.library.member.common.JDBCTemplate;


public class MainService {

    private MainDAO dao = new MainDAO();

    public List<Main> getLatestBooks() {
        Connection conn = null;
        List<Main> bookList = null;

        try {
            conn = JDBCTemplate.getInstance().getConnection();
            bookList = dao.selectLatestBooks(conn);
            System.out.println("Service.getLatestBooks 결과 개수: " + (bookList != null ? bookList.size() : 0));
//            conn.commit(); // 성공 시 커밋
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback(); // 실패 시 롤백
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) conn.close(); // 연결 해제
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return bookList;
    }
    public List<Main> searchBooks(String keyword) {
        Connection conn = null;
        List<Main> result = new ArrayList<>();
        try {
            conn = JDBCTemplate.getInstance().getConnection();
            result = dao.searchBooks(conn, keyword);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return result;
    }
}
