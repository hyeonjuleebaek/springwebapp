package com.mycompany.springwebapp.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springwebapp.dto.Ch04Form1;
import com.mycompany.springwebapp.dto.Ch04Form2;
import com.mycompany.springwebapp.validator.Ch04Form1Validator;
import com.mycompany.springwebapp.validator.Ch04Form2Validator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch04")
public class Ch04Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch04/content";
	}
	
	@InitBinder("ch04Form1")
	public void Ch04Form1Validator(WebDataBinder binder) {
		binder.setValidator(new Ch04Form1Validator());
	}
	
	@PostMapping("/method1")
	//pom.xml에 validation-api 라이브러리 의존 설정 필요
	//request.setAttribute("ch04Form1", form1);로 자동저장
	public String method1(@Valid Ch04Form1 form1, Errors errors) {
		//errors.rejectValue가 한번이라도 호출되었다면 hasErrors는 true를 리턴
		if(errors.hasErrors()) {
			//폼으로 다시 돌려보냄
			return "ch04/content";
		}
		
		//요청 처리 코드
		log.info("param1: " + form1.getParam1());
		log.info("param2: " + form1.getParam2());
		log.info("param3: " + form1.getParam3());
		log.info("param4: " + form1.isParam4());
		log.info("param5: " + form1.getParam5());
		return "redirect:/";
	}

	@InitBinder("ch04Form2")
	public void Ch04Form2Validator(WebDataBinder binder) {
		binder.setValidator(new Ch04Form2Validator());
	}
	
	@PostMapping("/method2")
	public String method2(@Valid Ch04Form2 form2, Errors errors) {
		//errors.rejectValue가 한번이라도 호출되었다면 hasErrors는 true를 리턴

		if(errors.hasErrors()) {
			//폼으로 다시 돌려보냄
			return "ch04/content";
		}
		
		//요청 처리 코드
		log.info("param1: " + form2.getParam1());
		log.info("param2: " + form2.getParam2());
		log.info("param3: " + form2.getParam3());
		log.info("param4: " + form2.isParam4());
		log.info("param5: " + form2.getParam5());
		return "redirect:/";
	}
}
