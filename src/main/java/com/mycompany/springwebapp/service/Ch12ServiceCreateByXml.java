package com.mycompany.springwebapp.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch12ServiceCreateByXml {
	public Ch12ServiceCreateByXml() {
		log.info("실행");
	}
	
	public static Ch12ServiceCreateByXml getInstance() {
		log.info("실행");
		return new Ch12ServiceCreateByXml();
	}
	
	public Ch12ServiceCreateByXml getSelfObject() {
		log.info("실행");
		return new Ch12ServiceCreateByXml();
	}
	
	public void method1() {
		log.info("실행");
	}
	
	public void method2() {
		log.info("실행");
	}
 }
