package com.kjh.library.rent.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.kjh.library.rent.model.vo.Rent;

public class RentDAO {
	public List<Rent> selectRentByMember(Connection conn, String memberId) throws SQLException {
	    List<Rent> rentList = new ArrayList<>();
	    String sql = "SELECT R.BOOK_NO, B.BOOK_NAME, B.BOOK_AUTHOR, B.BOOK_PUBLISHER, " +
		             "R.LEND_DATE, R.RETURN_DATE " +
		             "FROM LENDINFO_TBL R " +
		             "JOIN BOOK_TBL B ON R.BOOK_NO = B.BOOK_NO " +
		             "JOIN MEMBER_TBL M ON R.M_ID = M.MEMBER_ID " +
		             "WHERE M.MEMBER_ID = ? " +
		             "ORDER BY R.LEND_DATE DESC";
	
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
		    pstmt.setString(1, memberId);
		    try (ResultSet rs = pstmt.executeQuery()) {
		        while (rs.next()) {
		            Rent r = new Rent();
		            r.setBookNo(rs.getString("BOOK_NO"));
		            r.setBookName(rs.getString("BOOK_NAME"));
		            r.setBookAuthor(rs.getString("BOOK_AUTHOR"));
		            r.setBookPublisher(rs.getString("BOOK_PUBLISHER"));
		            r.setLendDate(rs.getDate("LEND_DATE") != null ? rs.getDate("LEND_DATE").toString() : null);
		            r.setReturnDate(rs.getDate("RETURN_DATE") != null ? rs.getDate("RETURN_DATE").toString() : null);
		            rentList.add(r);
		        }
		    }
		}
	    return rentList;
	}
}
