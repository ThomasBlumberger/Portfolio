package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.domain.Admin;
import com.example.domain.Role;
import com.example.repo.AdminRepository;

@SpringBootApplication
public class Cw3Tb278Application implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(Cw3Tb278Application.class, args);
	}

	@Autowired
	private PasswordEncoder pe;
	
	@Autowired
	private AdminRepository repoA;
	
	public Role rAdmin = new Role("ADMIN");
	
	public Role rResident = new Role("RESIDENT");
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Admin a = new Admin();
		a.setSni("1");
		a.setUserid("admin@shangrila.gov.un");
		a.setPassword(pe.encode("shangrila@2021$"));
		repoA.save(a);
		
	}

}
