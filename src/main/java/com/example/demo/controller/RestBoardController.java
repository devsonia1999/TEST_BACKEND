package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
  @GetMapping("boardList")
  public String boardList(@RequestParam Map<String, Object> paramData){
    log.info(paramData);
    List<Map<String, Object>> list = null;
    list = boardService.boardList(paramData);
    Gson gson = new Gson();
    String temp = gson.toJson(list);
    return temp;
  }
}
