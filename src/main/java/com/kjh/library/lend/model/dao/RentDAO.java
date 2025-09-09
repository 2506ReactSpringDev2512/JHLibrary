package com.kjh.library.lend.model.dao;

import java.sql.*;
import java.util.*;

import com.kjh.library.lend.model.vo.Rent;
import com.kjh.library.member.common.JDBCTemplate;

public class RentDAO {

    public List<Rent> selectRentList(String memberId) {
        List<Rent> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT b.BOOK_NO, b.BOOK_NAME, b.BOOK_AUTHOR, b.BOOK_PUBLISHER, " +
                     "       TO_CHAR(l.LEND_DATE, 'YYYY-MM-DD') AS LEND_DATE, " +
                     "       TO_CHAR(l.RETURN_DATE, 'YYYY-MM-DD') AS RETURN_DATE, " +
                     "       b.LEND_YN " +
                     "FROM LENDINFO_TBL l " +
                     "JOIN BOOK_TBL b ON l.BOOK_NO = b.BOOK_NO " +
                     "WHERE l.M_ID = ? " +
                     "ORDER BY l.LEND_DATE DESC";

        try {
            // 커넥션 가져오기
            conn = JDBCTemplate.getInstance().getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Rent r = new Rent();
                r.setBookNo(rs.getString("BOOK_NO"));
                r.setBookName(rs.getString("BOOK_NAME"));
                r.setAuthor(rs.getString("BOOK_AUTHOR"));
                r.setPublisher(rs.getString("BOOK_PUBLISHER"));
                r.setLendDate(rs.getString("LEND_DATE"));
                r.setReturnDate(rs.getString("RETURN_DATE"));
                r.setLendYn(rs.getString("LEND_YN"));
                list.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }

        return list;
    }
}
