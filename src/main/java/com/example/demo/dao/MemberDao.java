package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
public class MemberDao {
  @Autowired
  private SqlSessionTemplate sqlSessionTemplate;

  public List<Map<String, Object>> memberList(Map<String, Object> paramData){
    List<Map<String, Object>> list = null;
    list = sqlSessionTemplate.selectList("memberList", paramData);
    return list;
  }

  public int memberInsert(Map<String, Object> paramData) {
    int result = 0;
    result = sqlSessionTemplate.insert("memberInsert", paramData);
    return result;
  }

  public int memberUpdate(Map<String, Object> paramData) {
    int result = 0;
    result = sqlSessionTemplate.update("memberUpdate", paramData);
    return result;
  }

  public int memberDelete(Map<String, Object> paramData) {
    int result = 0;
    int id = 0;
    if(paramData.containsKey("id")){
        id = Integer.parseInt(paramData.get("id").toString());
    }
    result = sqlSessionTemplate.delete("memberDelete", id);
    return result;
  }
}
