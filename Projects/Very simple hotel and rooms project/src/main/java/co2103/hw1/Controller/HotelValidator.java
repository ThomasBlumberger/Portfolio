package co2103.hw1.Controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Hotel;

public class HotelValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Hotel.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Hotel a = (Hotel) target;
		
		for(Hotel ex : Hw1Application.hotels) {
			if (a.getId() == ex.getId()) {
				errors.rejectValue("id"," ", "ID is already in use");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", " ", "The Hotel has to have a name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", " ", "The Hotel has to have a description");

	}

}
