package com.kjh.library.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kjh.library.member.model.vo.Member;

public class MemberDAO {

	public Member checkLogin(Member member, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member mOne = null;
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPw());
		rset = pstmt.executeQuery();
		if(rset.next()) {
			mOne = rsetToMember(rset);
		}
		rset.close();
		pstmt.close();
		conn.close();
 		return mOne;
	}
	
	private Member rsetToMember(ResultSet rset) throws SQLException {
		String memberId = rset.getString("MEMBER_ID");
		String memberPw = rset.getString("MEMBER_PW");
		String memberName = rset.getString("MEMBER_NAME");
		String memberPhone = rset.getString("MEMBER_PHONE");
		String memberGender = rset.getString("MEMBER_GENDER");
		int memberAge = rset.getInt("MEMBER_AGE");
		Member member = new Member(memberId, memberPw, memberName, memberPhone, memberGender, memberAge);
		return member;
	}

	// 회원가입
    public int insertMember(Member member, Connection conn) throws SQLException {
        String query = "INSERT INTO MEMBER_TBL (MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_PHONE, MEMBER_GENDER, MEMBER_AGE, ADMIN_YN) "
                     + "VALUES (?, ?, ?, ?, ?, ?, DEFAULT)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, member.getMemberId());
        pstmt.setString(2, member.getMemberPw());
        pstmt.setString(3, member.getMemberName());
        pstmt.setString(4, member.getMemberPhone());
        pstmt.setString(5, member.getMemberGender());
        pstmt.setInt(6, member.getMemberAge());
        int result = pstmt.executeUpdate();
        pstmt.close();
        return result;
    }

	public Member selectMemberByIdAndName(String memberId, String memberName, Connection conn) throws SQLException {
        Member member = null;
        String sql = "SELECT MEMBER_ID, MEMBER_NAME, MEMBER_PW, MEMBER_PHONE, MEMBER_GENDER, MEMBER_AGE, ADMIN_YN " +
                     "FROM MEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_NAME = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, memberId);
            pstmt.setString(2, memberName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    member = new Member(
                        rs.getString("MEMBER_ID"),
                        rs.getString("MEMBER_PW"),
                        rs.getString("MEMBER_NAME"),
                        rs.getString("MEMBER_PHONE"),
                        rs.getString("MEMBER_GENDER"),
                        rs.getInt("MEMBER_AGE"),
                        rs.getString("ADMIN_YN")
                    );
                }
            }
        }
        return member;
    }

	public int updatePassword(String memberId, String tempPw, Connection conn) throws SQLException {
        int result = 0;
        String sql = "UPDATE MEMBER_TBL SET MEMBER_PW = ? WHERE MEMBER_ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tempPw);
            pstmt.setString(2, memberId);
            result = pstmt.executeUpdate();
            pstmt.close();
        }
        return result;
    }
	
	// 아이디 중복 체크 (옵션)
    public Member selectMemberById(String memberId, Connection conn) throws SQLException {
        String query = "SELECT MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_PHONE, MEMBER_GENDER, MEMBER_AGE, ADMIN_YN "
                     + "FROM MEMBER_TBL WHERE MEMBER_ID=?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, memberId);
        ResultSet rs = pstmt.executeQuery();
        Member member = null;
        if (rs.next()) {
            member = new Member();
            member.setMemberId(rs.getString("MEMBER_ID"));
            member.setMemberPw(rs.getString("MEMBER_PW"));
            member.setMemberName(rs.getString("MEMBER_NAME"));
            member.setMemberPhone(rs.getString("MEMBER_PHONE"));
            member.setMemberGender(rs.getString("MEMBER_GENDER"));
            member.setMemberAge(rs.getInt("MEMBER_AGE"));
            member.setAdminYn(rs.getString("ADMIN_YN"));
        }
        rs.close();
        pstmt.close();
        return member;
    }
    
    public int updateMember(Member m, Connection conn) throws SQLException {
        String sql = "UPDATE MEMBER_TBL SET MEMBER_PW = ?, MEMBER_PHONE = ?, MEMBER_AGE = ? WHERE MEMBER_ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, m.getMemberPw());
            pstmt.setString(2, m.getMemberPhone());
            pstmt.setInt(3, m.getMemberAge());
            pstmt.setString(4, m.getMemberId());
            return pstmt.executeUpdate();
        }
    }
}
