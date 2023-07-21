package com.mycompany.springwebapp.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.springwebapp.dto.Ch04Form2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch04Form2Validator implements Validator {
	@Override
		public boolean supports(Class<?> clazz) {
			log.info("실행");
			//Ch04Form2객체 인지 확인
			boolean check = Ch04Form2.class.isAssignableFrom(clazz);
			return check;
		}
	
	//supports가 true일 경우에만 validate
	@Override
	public void validate(Object target, Errors errors) {
		log.info("실행");
		Ch04Form2 ch04Form2 = (Ch04Form2) target;
		
		//param1 검사
		String param1 = ch04Form2.getParam1();
		if(param1 == null || param1.equals("")) {
			errors.rejectValue("param1", "errors.form.required", "필수 입력(D)");
		} else {
			String regExp = "^\\d{2}([0]\\d|[1][0-2])([0][1-9]|[1-2]\\d|[3][0-1])[-]*[1-4][0-9]{6}$";
			boolean result = Pattern.matches(regExp, param1);
			if(result == false) {
				errors.rejectValue("param1", "errors.form.format", "형식에 맞지 않음(D)");
			}
		}
		
		//param2 검사
		String param2 = ch04Form2.getParam2();
		if(param2 == null || param2.equals("")) {
			errors.rejectValue("param2", "errors.form.required", "필수 입력(D)");
		} else {
			String regExp = "^(19[0-9][0-9]|20\\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$";
			boolean result = Pattern.matches(regExp, param2);
			if(result == false) {
				errors.rejectValue("param2", "errors.form.format", "형식에 맞지 않음(D)");
			}
		}
		
		//param3 검사
		String param3 = ch04Form2.getParam3();
		if(param3 == null || param3.equals("")) {
			errors.rejectValue("param3", "errors.form.required", "필수 입력(D)");
		} else {
			//비밀번호 규칙: 최소 8자 + 최소 한개의 영문자 + 최소 한개의 숫자
			String regExp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
			boolean result = Pattern.matches(regExp, param3);
			if(result == false) {
				errors.rejectValue("param3", "errors.form.format", "형식에 맞지 않음(D)");
			}
		}
	}
}
