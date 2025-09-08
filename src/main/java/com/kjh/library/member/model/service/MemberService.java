package com.kjh.library.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.kjh.library.member.common.JDBCTemplate;
import com.kjh.library.member.model.dao.MemberDAO;
import com.kjh.library.member.model.vo.Member;

public class MemberService {
	
	private JDBCTemplate jdbcTemplate;
	private MemberDAO mDao;
	
	public MemberService() {
		jdbcTemplate = JDBCTemplate.getInstance();
		mDao = new MemberDAO();
	}
	
	public Member checkLogin(Member member) {
		Member mOne = null;
		try {
			Connection conn = jdbcTemplate.getConnection();
			mOne = mDao.checkLogin(member, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mOne;
	}
	
	public int insertMember(Member member) {
		int result = 0;
		Connection conn = jdbcTemplate.getConnection();
		try {
			result = mDao.insertMember(member, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Member findMemberByIdAndName(String memberId, String memberName) {
	    Member member = null;
	    Connection conn = jdbcTemplate.getConnection();
	    try {
			member = mDao.selectMemberByIdAndName(memberId, memberName, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return member;
	}

	public int updateMemberPassword(String memberId, String tempPw) {
	    int result = 0;
	    Connection conn = jdbcTemplate.getConnection();
	        try {
				result = mDao.updatePassword(memberId, tempPw, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    return result;
	}
	
	public int changeMemberPassword(String memberId, String currentPw, String newPw) {
	    int result = 0;
	    Connection conn = jdbcTemplate.getConnection();
	    try {
	        // 먼저 현재 비밀번호 확인
	        Member member = mDao.selectMemberById(memberId, conn);
	        if(member != null && member.getMemberPw().equals(currentPw)) {
	            // 비밀번호 변경
	            result = mDao.updatePassword(memberId, newPw, conn);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
}
