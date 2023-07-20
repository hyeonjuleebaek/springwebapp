package com.mycompany.springwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.dto.Ch04Dto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch04")
public class Ch04Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch04/content";
	}
	
	@PostMapping("/method1")
	public String method1(Ch04Dto dto) {
		log.info("parama1: " + dto.getParam1());
		log.info("parama2: " + dto.getParam2());
		log.info("parama3: " + dto.getParam3());
		log.info("parama4: " + dto.isParam4());
		log.info("parama5: " + dto.getParam5());
		return "redirect:/ch04/content";
	}
	
}