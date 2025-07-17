package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MemberService {
  @Autowired
  private MemberDao memberDao;

  public List<Map<String, Object>> memberList(Map<String, Object> paramData){
    List<Map<String, Object>> list = null;
    list = memberDao.memberList(paramData);
    if(list == null) list = new ArrayList<>();
    return list;
  }

  public int memberInsert(Map<String, Object> paramData) {
    log.info("memberInsert");
    int result = 0;
    result = memberDao.memberInsert(paramData);
    return  result;
  }

  public int memberUpdate(Map<String, Object> paramData) {
    log.info("memberUpdate");
    int result = 0;
    result = memberDao.memberUpdate(paramData);
    return result;
  }

  public int memberDelete(Map<String, Object> paramData) {
    log.info("memberDelete");
    int result = 0;
    result = memberDao.memberDelete(paramData);
    return result;
  }
}
