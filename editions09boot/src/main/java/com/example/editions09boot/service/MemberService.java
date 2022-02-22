package com.example.editions09boot.service;


import java.util.List;

import com.example.editions09boot.dao.MemberDAO;
import com.example.editions09boot.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;



@Service
public class MemberService {

    @Autowired
    MemberDAO memberDao;

    public List<MemberVO> selectAllMembers() {
        return memberDao.selectAllMembers();
    }
}