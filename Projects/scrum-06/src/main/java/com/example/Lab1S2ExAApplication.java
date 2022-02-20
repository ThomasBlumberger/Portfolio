package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.controller.EmailSystem;
import com.example.domain.Admin;
//domains
import com.example.domain.Role;
import com.example.repository.AdminRepository;


@SpringBootApplication
public class Lab1S2ExAApplication implements ApplicationRunner{

	@Autowired
	private PasswordEncoder pe;
	
	@Autowired
	private AdminRepository repoa;

    public Role rConvenor = new Role("CONVENOR");
	public Role rStudent = new Role("STUDENT");
	public Role rAdmin = new Role("ADMIN");
	
	public static EmailSystem emailSystem = new EmailSystem();
	
	public static void main(String[] args) {
		SpringApplication.run(Lab1S2ExAApplication.class, args);
	}
	
	public void run(ApplicationArguments args) throws Exception {
		if (repoa.findByUsername("admin1") == null) {
			Admin a1 = new Admin();
			a1.setName("Example Admin");
			a1.setPassword(pe.encode("GiveUs100%"));
			a1.setUsername("admin1");
			a1.setEmail("scrumgroup6uol@gmail.com");
			repoa.save(a1);
		}
	}
	
}
