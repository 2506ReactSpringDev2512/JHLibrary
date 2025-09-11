package com.kjh.library.lend.model.dao;

import java.sql.*;
import java.util.*;

import com.kjh.library.lend.model.vo.Rent;
import com.kjh.library.member.common.JDBCTemplate;

public class RendDAO {

	public List<Rent> selectRentList(Connection conn, String memberId) {
	    List<Rent> list = new ArrayList<>();
	    String sql = 
	        "SELECT b.BOOK_NO, b.BOOK_NAME, b.BOOK_AUTHOR, b.BOOK_PUBLISHER, b.LEND_YN, b.IMAGE_PATH, " +
	        "       TO_CHAR(l.LEND_DATE, 'YYYY-MM-DD') AS LEND_DATE, " +
	        "       TO_CHAR(l.EXPECTED_RETURN_DATE, 'YYYY-MM-DD') AS EXPECTED_RETURN_DATE " +
	        "FROM BOOK_TBL b " +
	        "JOIN ( " +
	        "  SELECT BOOK_NO, LEND_DATE, EXPECTED_RETURN_DATE FROM ( " +
	        "    SELECT BOOK_NO, LEND_DATE, EXPECTED_RETURN_DATE, " +
	        "           ROW_NUMBER() OVER (PARTITION BY BOOK_NO ORDER BY LEND_DATE DESC) AS rn " +
	        "    FROM LENDINFO_TBL " +
	        "    WHERE M_ID = ? AND RETURN_DATE IS NULL " +
	        "  ) WHERE rn = 1 " +
	        ") l ON b.BOOK_NO = l.BOOK_NO " +
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
	            r.setImagePath(rs.getString("IMAGE_PATH"));

	            list.add(r);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}

	public boolean updateReturnStatus(Connection conn, String memberId, String bookNo) throws SQLException {
	    // 1. 먼저 해당 사용자가 해당 도서를 대여중인지 확인
	    String checkSql = "SELECT COUNT(*) FROM LENDINFO_TBL WHERE BOOK_NO = ? AND M_ID = ? AND RETURN_DATE IS NULL";
	    
	    // 2. 반납 처리 쿼리들
	    String updateReturnDateSql = "UPDATE LENDINFO_TBL SET RETURN_DATE = SYSDATE WHERE BOOK_NO = ? AND M_ID = ? AND RETURN_DATE IS NULL";
	    String updateBookStatusSql = "UPDATE BOOK_TBL SET LEND_YN = 'N' WHERE BOOK_NO = ?";  // 대여가능 상태로 변경

	    try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
	        // 대여 중인 도서인지 확인
	        checkStmt.setString(1, bookNo);
	        checkStmt.setString(2, memberId);
	        ResultSet rs = checkStmt.executeQuery();
	        
	        if (rs.next() && rs.getInt(1) == 0) {
	            System.out.println("반납 불가: 해당 사용자가 이 도서를 대여하지 않았거나 이미 반납했습니다.");
	            return false;
	        }
	    }

	    try (PreparedStatement pstmt1 = conn.prepareStatement(updateReturnDateSql);
	         PreparedStatement pstmt2 = conn.prepareStatement(updateBookStatusSql)) {

	        System.out.println("반납 처리 시작 - memberId: " + memberId + ", bookNo: " + bookNo);
	        
	        // LENDINFO_TBL 업데이트 (반납일 설정)
	        pstmt1.setString(1, bookNo);
	        pstmt1.setString(2, memberId);
	        int row1 = pstmt1.executeUpdate();
	        System.out.println("LENDINFO_TBL 업데이트 결과: " + row1);

	        // BOOK_TBL 업데이트 (대여 상태 변경)
	        pstmt2.setString(1, bookNo);
	        int row2 = pstmt2.executeUpdate();
	        System.out.println("BOOK_TBL 업데이트 결과: " + row2);

	        boolean success = row1 > 0 && row2 > 0;
	        System.out.println("최종 반납 결과: " + success);
	        
	        return success;
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
	
	public boolean rentBook(Connection conn, String memberId, String bookNo) throws SQLException {
	    // 1. 해당 도서가 대여 가능한지 확인
	    String checkSql = "SELECT LEND_YN FROM BOOK_TBL WHERE BOOK_NO = ?";
	    
	    // 2. 대여 처리 쿼리들
	    String insertLendInfoSql = "INSERT INTO LENDINFO_TBL (BOOK_NO, M_ID, LEND_DATE, EXPECTED_RETURN_DATE) " +
	                               "VALUES (?, ?, SYSDATE, SYSDATE + 7)";  // 7일 대여
	    String updateBookStatusSql = "UPDATE BOOK_TBL SET LEND_YN = 'Y' WHERE BOOK_NO = ?";

	    try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
	        // 대여 가능한 도서인지 확인
	        checkStmt.setString(1, bookNo);
	        ResultSet rs = checkStmt.executeQuery();
	        
	        if (rs.next() && !"N".equals(rs.getString("LEND_YN"))) {
	            System.out.println("대여 불가: 이미 대여중인 도서입니다.");
	            return false;
	        }
	    }

	    try (PreparedStatement pstmt1 = conn.prepareStatement(insertLendInfoSql);
	         PreparedStatement pstmt2 = conn.prepareStatement(updateBookStatusSql)) {

	        System.out.println("대여 처리 시작 - memberId: " + memberId + ", bookNo: " + bookNo);
	        
	        // LENDINFO_TBL에 대여 정보 추가
	        pstmt1.setString(1, bookNo);
	        pstmt1.setString(2, memberId);
	        int row1 = pstmt1.executeUpdate();
	        System.out.println("LENDINFO_TBL 삽입 결과: " + row1);

	        // BOOK_TBL 상태 업데이트 (대여중으로 변경)
	        pstmt2.setString(1, bookNo);
	        int row2 = pstmt2.executeUpdate();
	        System.out.println("BOOK_TBL 업데이트 결과: " + row2);

	        boolean success = row1 > 0 && row2 > 0;
	        System.out.println("최종 대여 결과: " + success);
	        
	        return success;
	    }
	}
	public List<Rent> selectReturnList(Connection conn, String memberId) {
	    List<Rent> list = new ArrayList<>();
	    String sql = "SELECT * FROM (" +
	                 "SELECT b.BOOK_NO, b.BOOK_NAME, b.BOOK_AUTHOR, b.BOOK_PUBLISHER, b.LEND_YN, b.IMAGE_PATH, " +
	                 "TO_CHAR(l.LEND_DATE, 'YYYY-MM-DD') AS LEND_DATE, " +
	                 "TO_CHAR(l.EXPECTED_RETURN_DATE, 'YYYY-MM-DD') AS EXPECTED_RETURN_DATE, " +
	                 "TO_CHAR(l.RETURN_DATE, 'YYYY-MM-DD') AS RETURN_DATE, " +
	                 "ROW_NUMBER() OVER (PARTITION BY b.BOOK_NO ORDER BY l.RETURN_DATE DESC) AS rn " +
	                 "FROM LENDINFO_TBL l " +
	                 "JOIN BOOK_TBL b ON l.BOOK_NO = b.BOOK_NO " +
	                 "WHERE l.M_ID = ? AND l.RETURN_DATE IS NOT NULL " +
	                 ") WHERE rn = 1 " +
	                 "ORDER BY RETURN_DATE DESC";

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
	            r.setReturnDate(rs.getString("RETURN_DATE"));
	            r.setImagePath(rs.getString("IMAGE_PATH"));
	            list.add(r);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}



}
