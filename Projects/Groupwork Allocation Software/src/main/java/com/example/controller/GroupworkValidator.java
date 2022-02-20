package com.example.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.domain.Groupwork;
import com.example.repository.GroupworkRepository;

public class GroupworkValidator implements Validator {
	
	@Autowired
	GroupworkRepository repoC;

	@Override
	public boolean supports(Class<?> clazz) {
		return Groupwork.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Groupwork a = (Groupwork) target;
		
		if (a.getGroupSize() < 2) {
			errors.rejectValue("groupSize", " ", "Groups must be comprised of at least 2 students");
		}
		
		if (a.getModulePercent() <0) {
			errors.rejectValue("modulePercent", " ", "Number cannot be negative");
		}
		
		if (a.getModulePercent() >100) {
			errors.rejectValue("modulePercent", " ", "Module weight cannot be greater than 100%");
		}
		
		if (a.getDeadline() == null) {
			errors.rejectValue("deadline", "", "You must enter a deadline!");
		}
		
		if (a.getDeadline() != null && a.getDeadline().before(new Date())) {
			errors.rejectValue("deadline", " ", "The deadline must not be less than the current date");
		}
	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "There must be a name");
	}

}
