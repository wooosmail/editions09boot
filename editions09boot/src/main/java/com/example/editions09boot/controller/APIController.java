package com.example.editions09boot.controller;

import com.example.editions09boot.dao.MemberDAO;
import com.example.editions09boot.service.MemberService;
import com.example.editions09boot.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.HashMap;
import java.util.List;

@Slf4j(topic = "INFO_LOG")

@Controller
public class APIController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());



    @Autowired
    MemberService memberService;
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @GetMapping("/members")
    public @ResponseBody
    List<MemberVO> selectListMembers() {
        List<MemberVO> allMembers = memberService.selectAllMembers();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return allMembers;
    }

    @GetMapping("/memberspkg")
    public @ResponseBody
    List<MemberVO> selectAllMembersOnPkg() {
        //List<MemberVO> allMembers = memberService.selectAllMembersOnPkg();

        MemberDAO dao = sqlSessionTemplate.getMapper(MemberDAO.class);

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("NAME", "ANDY");

        dao.selectAllMembersOnPkg(map);

        List<MemberVO> allMembers = (List<MemberVO>) map.get("key");


        logger.info("Info");
        return allMembers;
    }


}



