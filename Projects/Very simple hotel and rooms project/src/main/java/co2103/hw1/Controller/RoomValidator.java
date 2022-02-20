package co2103.hw1.Controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import co2103.hw1.domain.Room;

public class RoomValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Room.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Room a = (Room) target;
		
			if(a.getGuests() <1 || a.getGuests() >12 ) {
				errors.rejectValue("guests", " ", "The number of guests must be between 1 and 12!");
				}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", " ", "The Room has to have a name");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", " ", "The Room has to have a description");
			
			if(!a.getCategory().equalsIgnoreCase("suite")) {
				if(!a.getCategory().equalsIgnoreCase("penthouse")) {
					if(!a.getCategory().equalsIgnoreCase("simple")) {
				errors.rejectValue("category", " ", "The category must be either suite, penthouse or simple");
				
			}
			}
			}
	}
	
	}

