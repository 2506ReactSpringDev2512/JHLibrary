package com.kjh.library.lend.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kjh.library.member.common.JDBCTemplate;
import com.kjh.library.rent.model.dao.RentDAO;
import com.kjh.library.lend.model.dao.RendDAO;
import com.kjh.library.lend.model.vo.Rent;

public class RentService {
    public List<Rent> selectRentList(String memberId) {
        Connection conn = JDBCTemplate.getInstance().getConnection();
        RendDAO dao = new RendDAO();
        List<Rent> list = dao.selectRentList(conn, memberId);
        try {
            if (conn != null && !conn.isClosed()) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean returnBook(String memberId, String bookNo) {
        Connection conn = JDBCTemplate.getInstance().getConnection();
        boolean result = false;

        try {
            conn.setAutoCommit(false);  // 수동 커밋 설정

            // 🔄 memberId까지 전달하도록 수정
            result = new RendDAO().updateReturnStatus(conn, memberId, bookNo);

            if (result) {
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (conn != null && !conn.isClosed()) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
    public List<Rent> selectAllBooks() {
        Connection conn = JDBCTemplate.getInstance().getConnection();
        List<Rent> list = new RendDAO().selectAllBooks(conn);  // DAO 호출
        try {
            if (conn != null && !conn.isClosed()) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}