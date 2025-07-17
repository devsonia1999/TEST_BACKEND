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

import com.example.demo.service.MemberService;
import com.google.gson.Gson;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/member/*")
public class RestMemberController {
  @Autowired
  private MemberService memberService;

  //조회
  @GetMapping("list")
  public String boardList(@RequestParam Map<String, Object> paramData){
    log.info("memberList");
    log.info(paramData);
    List<Map<String, Object>> list = null;
    list = memberService.memberList(paramData);
    Gson gson = new Gson();
    String temp = gson.toJson(list);
    return temp;
  }

  //입력
  @PostMapping("insert")
  public String boardInsert(@RequestBody Map<String,Object> paramData){
    log.info("memberInsert");
    log.info(paramData);
    int result = 0;
    result = memberService.memberInsert(paramData);
    return String.valueOf(result);
  }

  //수정
  @PutMapping("update")
  public String boardUpdate(@RequestBody Map<String,Object> paramData){
    log.info("memberUpdate");
    log.info(paramData);
    int result = 0;
    result = memberService.memberUpdate(paramData);
    return String.valueOf(result);
  }
  
  //삭제
  @DeleteMapping("delete")
  public String boardDelete(@RequestParam Map<String,Object> paramData){
    log.info("memberDelete");
    log.info(paramData);
    int result = 0;
    result = memberService.memberDelete(paramData);
    return String.valueOf(result);
  }
}
