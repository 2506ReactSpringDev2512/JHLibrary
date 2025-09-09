package com.kjh.library.lend.model.service;

import java.sql.Connection;
import java.util.List;

import com.kjh.library.member.common.JDBCTemplate;
import com.kjh.library.lend.model.dao.RentDAO;
import com.kjh.library.lend.model.vo.Rent;

public class RentService {

    public List<Rent> selectRentList(String memberId) {
        // JDBCTemplate에서 커넥션만 얻어서 DAO에 전달
        // 트랜잭션이나 close는 DAO에서 처리함 (JDBCTemplate 수정하지 않으므로)
        return new RentDAO().selectRentList(memberId);
    }
}