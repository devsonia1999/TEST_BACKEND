package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BoardService;
import com.google.gson.Gson;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/board/*")
public class RestBoardController {
  @Autowired
  private BoardService boardService;

  //조회
  @GetMapping("list")
  public String boardList(@RequestParam Map<String, Object> paramData){
    log.info("boardList");
    log.info(paramData);
    List<Map<String, Object>> list = null;
    list = boardService.boardList(paramData);
    Gson gson = new Gson();
    String temp = gson.toJson(list);
    return temp;
  }

  //입력
  @PostMapping("insert")
  public String boardInsert(@RequestBody Map<String,Object> paramData){
    log.info("boardInsert");
    log.info(paramData);
    int result = 0;
    result = boardService.boardInsert(paramData);
    return String.valueOf(result);
  }

  //수정
  @PutMapping("update")
  public String boardUpdate(@RequestBody Map<String,Object> paramData){
    log.info("boardUpdate");
    log.info(paramData);
    int result = 0;
    result = boardService.boardUpdate(paramData);
    return String.valueOf(result);
  }
  
  //삭제
  @DeleteMapping("delete")
  public String boardDelete(@RequestParam Map<String,Object> paramData){
    log.info("boardDelete");
    log.info(paramData);
    int result = 0;
    result = boardService.boardDelete(paramData);
    return String.valueOf(result);
  }
}
