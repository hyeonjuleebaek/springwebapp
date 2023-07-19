package com.mycompany.springwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch02")
public class Ch02Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch02/content";
	}
	
	@GetMapping("/method")
	public String method1(String bkind, String bno) {
		log.info("bkind:" + bkind);
		log.info("bno:" + bno);
		return "ch02/content";
	}
	
	@PostMapping("/method")
	public String method2(String bkind, String bno) {
		log.info("bkind:" + bkind);
		log.info("bno:" + bno);
		return "ch02/content";
	}
}
