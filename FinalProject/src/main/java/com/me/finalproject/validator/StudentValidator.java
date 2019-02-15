package com.me.finalproject.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.finalproject.pojo.Student;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class _class) {
		return _class.equals(Student.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Student student = (Student) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.invalid.user", "First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "error.invalid.user", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email.emailAddress",
				"Email Required");

	}

}
