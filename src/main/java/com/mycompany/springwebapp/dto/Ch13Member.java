package com.mycompany.springwebapp.dto;

import lombok.Data;

@Data
public class Ch13Member {
	public String mid;
	public String mname;
	public String mpassword;
	//휴면회원 여부
	public boolean menabled;
	public String mrole;
	public String memail;
}
