package com.me.finalproject.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.finalproject.pojo.Employer;

public class EmployerValidator implements Validator {
	@Override
	public boolean supports(Class _class) {
		return _class.equals(Employer.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employer emp = (Employer) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.invalid.user", "First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "error.invalid.user", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email.emailAddress",
				"Email Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orgname", "error.invalid.password", "Password Required");

	}
}
