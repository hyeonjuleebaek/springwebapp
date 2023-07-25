package com.mycompany.springwebapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.dto.Ch11Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch11")
public class Ch11Controller {
   @RequestMapping("/content")
   public String content(HttpSession session) {
      return "ch11/content";
   }
   
   //기본값 세팅용도(폼자체를 제공)
   @GetMapping("/form1")
   public String form1(@ModelAttribute("member") Ch11Member member) {
	   member.setMid("summer");
	   member.setMname("홍길동");
	   member.setMpassword("123456");
	   member.setMnation("한국");
	   return "ch11/form1";
   }
   
   //폼으로부터 넘어오는 데이터 받아서 처리하기 위한 용도
   @PostMapping("/form1")
   public String handleForm1(@ModelAttribute("member") Ch11Member member) {
	   log.info(member.toString());
	   return "redirect:/ch11/content";
   }
}