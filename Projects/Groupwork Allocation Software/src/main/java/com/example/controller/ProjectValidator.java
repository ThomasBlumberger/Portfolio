package com.example.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.domain.Project;

public class ProjectValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Project.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Project a = (Project) target;
		
		if (a.getMaxNumOfProjects() < 0) {
			errors.rejectValue("maxNumOfProjects", " ", "Number cannot be negative ");
		}
		
		if (a.getMaxNumOfProjects() == 0) {
			errors.rejectValue("maxNumOfProjects", " ", "There has to be one or more groups ");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "There must be a name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "", "There must be a description");
		
	}

}
