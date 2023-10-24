package com.mycompany.springwebapp.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mycompany.springwebapp.dao.Ch13MemberDao;
import com.mycompany.springwebapp.dto.Ch13Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Ch17UserDetailsService implements UserDetailsService {
	@Resource
	private Ch13MemberDao memberDao;	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Ch13Member member = memberDao.selectByMid(username); 
		if(member == null) {
			throw new UsernameNotFoundException(username);
		}
		
		//List<String> listRole = member.getRole("mid");
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(member.getMrole()));
		
		Ch17UserDetails userDetails = new Ch17UserDetails(member, authorities);
		return userDetails;
	}
}

