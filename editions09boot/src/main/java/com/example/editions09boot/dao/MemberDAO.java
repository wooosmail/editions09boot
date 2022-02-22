package com.example.editions09boot.dao;


import java.util.List;
import java.util.Map;

import com.example.editions09boot.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {
    public List<MemberVO> selectAllMembers();
    public void selectAllMembersOnPkg(Map<String,Object> map);

}