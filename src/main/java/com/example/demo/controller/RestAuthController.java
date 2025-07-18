package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/auth/*")
public class RestAuthController {
  @Autowired
  private AuthService authService;

  //로그인
  @PostMapping("login")
  public String login(@RequestParam Map<String, Object> paramData){
    log.info("login");
    log.info(paramData);
    int result = 0;
    result = authService.memberInsert(paramData);
    return String.valueOf(result);
  }

}
