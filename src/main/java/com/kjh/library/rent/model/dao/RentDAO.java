package com.kjh.library.rent.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.kjh.library.rent.model.vo.Rent;

public class RentDAO {

	public List<Rent> selectRentByMember(Connection conn, String memberId) throws SQLException {
	    List<Rent> rentList = new ArrayList<>();
	    String sql = "SELECT BOOK_NO, LEND_DATE, RETURN_DATE FROM LENDINFO_TBL WHERE M_ID = ?";
	    
	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, memberId);
	        try (ResultSet rs = pstmt.executeQuery()) { // ResultSet도 try-with-resources로 처리
	            while(rs.next()) {
	                Rent r = new Rent();
	                r.setBookNo(rs.getString("BOOK_NO"));
	                r.setLendDate(rs.getDate("LEND_DATE") != null ? rs.getDate("LEND_DATE").toString() : null);
	                r.setReturnDate(rs.getDate("RETURN_DATE") != null ? rs.getDate("RETURN_DATE").toString() : null);
	                rentList.add(r);
	            }
	        }
	        // 디버그 로그 추가
	        System.out.println("조회된 대여 목록 개수: " + rentList.size());
	    }
	    return rentList;
	}
}
