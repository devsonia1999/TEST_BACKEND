package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDao;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BoardService {
  @Autowired
  private BoardDao boardDao;

  public List<Map<String, Object>> boardList(Map<String, Object> paramData){
    List<Map<String, Object>> list = null;
    list = boardDao.boardList(paramData);
    if(list == null) list = new ArrayList<>();
    return list;
  }

  
}
