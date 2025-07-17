package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
public class BoardDao {
  @Autowired
  private SqlSessionTemplate sqlSessionTemplate;

  public List<Map<String, Object>> boardList(Map<String, Object> paramData){
    List<Map<String, Object>> list = null;
    list = sqlSessionTemplate.selectList("boardList", paramData);
    return list;
  }

  
}
