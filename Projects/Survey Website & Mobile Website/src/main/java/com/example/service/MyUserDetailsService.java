package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.domain.Role;
import com.example.repo.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		com.example.domain.User domainUser = repo.findByUserid(login.toLowerCase());

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role r : domainUser.getRoles()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + r.getName()));
		}

		return new User(domainUser.getUserid().toLowerCase(), domainUser.getPassword(), true, 
				true, true, true, authorities);
	}

}