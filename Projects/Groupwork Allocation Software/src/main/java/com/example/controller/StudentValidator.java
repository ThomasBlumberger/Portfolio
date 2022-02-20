package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.domain.LivesWithCircumstance;
import com.example.domain.Student;
import com.example.repository.StudentRepository;

public class StudentValidator implements Validator {

	@Autowired
	private StudentRepository srepo;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Student student = (Student) target;
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "", "You must provide their username.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "You must provide their full name");
	}

}
