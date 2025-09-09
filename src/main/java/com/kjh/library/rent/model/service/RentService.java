package com.kjh.library.rent.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kjh.library.member.common.JDBCTemplate;
import com.kjh.library.rent.model.dao.RentDAO;
import com.kjh.library.rent.model.vo.Rent;

public class RentService {
    private RentDAO rentDAO = new RentDAO();
    private JDBCTemplate jdbcTemplate = JDBCTemplate.getInstance();

    public List<Rent> selectRentByMember(String memberId) {
        List<Rent> rentList = new ArrayList<>(); // null 대신 빈 리스트로 초기화
        try (Connection conn = jdbcTemplate.getConnection()) {
            System.out.println("DB 연결 성공, 회원ID: " + memberId); // 디버그 로그
            rentList = rentDAO.selectRentByMember(conn, memberId);
            System.out.println("Service에서 조회된 데이터 개수: " + rentList.size());
        } catch(SQLException e) {
            System.err.println("DB 연결 또는 조회 실패: " + e.getMessage());
            e.printStackTrace();
        }
        return rentList;
    }
}
