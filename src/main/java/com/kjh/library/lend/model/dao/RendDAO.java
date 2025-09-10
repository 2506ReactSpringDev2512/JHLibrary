package com.kjh.library.lend.model.dao;

import java.sql.*;
import java.util.*;

import com.kjh.library.lend.model.vo.Rent;
import com.kjh.library.member.common.JDBCTemplate;

public class RendDAO {

	public List<Rent> selectRentList(Connection conn, String memberId) {
	    List<Rent> list = new ArrayList<>();
	    String sql = "SELECT b.BOOK_NO, b.BOOK_NAME, b.BOOK_AUTHOR, b.BOOK_PUBLISHER, b.LEND_YN, b.IMAGE_PATH, " +
	             "TO_CHAR(l.LEND_DATE, 'YYYY-MM-DD') AS LEND_DATE, " +
	             "TO_CHAR(l.EXPECTED_RETURN_DATE, 'YYYY-MM-DD') AS EXPECTED_RETURN_DATE " +
	             "FROM LENDINFO_TBL l " +
	             "JOIN BOOK_TBL b ON l.BOOK_NO = b.BOOK_NO " +
	             "WHERE l.M_ID = ? " +
	             "ORDER BY l.LEND_DATE DESC";


	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, memberId);
	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            Rent r = new Rent();
	            r.setBookNo(rs.getString("BOOK_NO"));
	            r.setBookName(rs.getString("BOOK_NAME"));
	            r.setAuthor(rs.getString("BOOK_AUTHOR"));
	            r.setPublisher(rs.getString("BOOK_PUBLISHER"));
	            r.setLendYn(rs.getString("LEND_YN"));
	            r.setLendDate(rs.getString("LEND_DATE"));
	            r.setExReturnDate(rs.getString("EXPECTED_RETURN_DATE"));
	            r.setImagePath(rs.getString("IMAGE_PATH"));  // 이미지 경로 세팅

	            list.add(r);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}

	public boolean updateReturnStatus(Connection conn, String memberId, String bookNo) throws SQLException {
	    String updateReturnDateSql = "UPDATE LENDINFO_TBL SET RETURN_DATE = SYSDATE WHERE BOOK_NO = ? AND M_ID = ? AND RETURN_DATE IS NULL";
	    String updateBookStatusSql = "UPDATE BOOK_TBL SET LEND_YN = '대여가능' WHERE BOOK_NO = ?";

	    try (PreparedStatement pstmt1 = conn.prepareStatement(updateReturnDateSql);
	         PreparedStatement pstmt2 = conn.prepareStatement(updateBookStatusSql)) {

	        pstmt1.setString(1, bookNo);
	        pstmt1.setString(2, memberId);
	        int row1 = pstmt1.executeUpdate();

	        pstmt2.setString(1, bookNo);
	        int row2 = pstmt2.executeUpdate();

	        return row1 > 0 && row2 > 0;
	    }
	}
	public List<Rent> selectAllBooks(Connection conn) {
	    List<Rent> list = new ArrayList<>();
	    String sql = "SELECT BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PUBLISHER, LEND_YN, IMAGE_PATH " +
	                 "FROM BOOK_TBL ORDER BY BOOK_NAME ASC";

	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            Rent r = new Rent();
	            r.setBookNo(rs.getString("BOOK_NO"));
	            r.setBookName(rs.getString("BOOK_NAME"));
	            r.setAuthor(rs.getString("BOOK_AUTHOR"));
	            r.setPublisher(rs.getString("BOOK_PUBLISHER"));
	            r.setLendYn(rs.getString("LEND_YN"));
	            r.setImagePath(rs.getString("IMAGE_PATH"));  // VO 필드명과 DB 컬럼명 일치시키기
	            list.add(r);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	
	public Rent selectBookByNo(Connection conn, String bookNo) {
	    Rent book = null;
	    String sql = "SELECT BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PUBLISHER, LEND_YN, IMAGE_PATH, DESCRIPTION FROM BOOK_TBL WHERE BOOK_NO = ?";

	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, bookNo);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                book = new Rent();
	                book.setBookNo(rs.getString("BOOK_NO"));
	                book.setBookName(rs.getString("BOOK_NAME"));
	                book.setAuthor(rs.getString("BOOK_AUTHOR"));
	                book.setPublisher(rs.getString("BOOK_PUBLISHER"));
	                book.setLendYn(rs.getString("LEND_YN"));
	                book.setImagePath(rs.getString("IMAGE_PATH"));
	                book.setDescription(rs.getString("DESCRIPTION"));  // 추가된 부분
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return book;
	}



}
