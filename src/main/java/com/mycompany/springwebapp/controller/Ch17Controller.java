package com.mycompany.springwebapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.springwebapp.dto.Ch13Member;
import com.mycompany.springwebapp.security.Ch17UserDetails;
import com.mycompany.springwebapp.service.Ch13MemberService;
import com.mycompany.springwebapp.service.Ch13MemberService.JoinResult;

@Controller
@RequestMapping("/ch17")
public class Ch17Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch17Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		logger.info("실행");
		return "ch17/content";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		logger.info("실행");
		return "ch17/loginForm";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/adminAction")
	public String adminAction() {
		logger.info("실행");
		return "redirect:/ch17/content";
	}
	
	@RequestMapping("/managerAction")
	@Secured({"ROLE_MANAGER"})
	public String managerAction() {
		logger.info("실행");
		return "redirect:/ch17/content";
	}
	
	@RequestMapping("/userAction")
	@Secured({"ROLE_MANAGER", "ROLE_USER"})
	//@Secured("ROLE_USER")
	public String userAction() {
		logger.info("실행");
		return "redirect:/ch17/content";
	}
	
	@RequestMapping("/error403")
	public String error403() {
		logger.info("실행");
		return "ch17/error403";
	}
	
	@RequestMapping("/joinForm")
	public String joinForm() {
		logger.info("실행");
		return "ch17/joinForm";
	}
	
	@Resource
	private Ch13MemberService memberService;
	
	@RequestMapping("/join")
	public String join(Ch13Member member, Model model) {
		logger.info("실행");
		
		//활성화 설정
		member.setMenabled(true);
		
		//패스워드 암호화
		String mpassword = member.getMpassword();
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		mpassword = passwordEncoder.encode(mpassword); 
		member.setMpassword(mpassword);

		//회원 가입 처리
		JoinResult jr = memberService.join(member);
		if(jr == JoinResult.SUCCESS) {
			return "redirect:/ch17/loginForm";
		} else if(jr == JoinResult.FAIL_DUPLICATED_MID) {
			model.addAttribute("error", "중복된 아이디가 있습니다.");
			return "ch17/joinForm";
		} else {
			model.addAttribute("error", "회원 가입이 실패되었습니다. 다시 시도해 주세요.");
			return "ch17/joinForm";
		}
	}
	
	@RequestMapping(value="/userInfo", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String userInfo(Authentication authentication) {
		logger.info("실행2");
		//사용자 아이디 얻기
		String mid = authentication.getName();
		
		//사용자 아이디 및 이메일 얻기
		Ch17UserDetails ch17UserDetails = (Ch17UserDetails) authentication.getPrincipal();
		Ch13Member member = ch17UserDetails.getMember();
		String mname = member.getMname();
		String memail = member.getMemail();
		
		//사용자 권한(롤) 이름 얻기
		List<String> authorityList = new ArrayList<>();
		for(GrantedAuthority authority : authentication.getAuthorities()) {
			authorityList.add(authority.getAuthority());
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("mid", mid);
		jsonObject.put("mname", mname);
		jsonObject.put("memail", memail);
		jsonObject.put("mrole", authorityList);
		
		String json = jsonObject.toString();
		logger.info(json);
		return json;
	}
}


















