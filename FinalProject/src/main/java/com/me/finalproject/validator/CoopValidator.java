package com.me.finalproject.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.finalproject.pojo.Coop;
import com.me.finalproject.pojo.Employer;

public class CoopValidator implements Validator{

	@Override
	public boolean supports(Class<?> _class) {
		return _class.equals(Coop.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Coop coop = (Coop) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.title", "Title Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.invalid.description", "Description Required");
		
		
	}

}
