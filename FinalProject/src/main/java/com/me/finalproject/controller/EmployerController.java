package com.me.finalproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.finalproject.dao.EmployerDAO;
import com.me.finalproject.pojo.Employer;
import com.me.finalproject.pojo.User;
import com.me.finalproject.validator.EmployerValidator;

@Controller
public class EmployerController {
	@Autowired
	@Qualifier("employerDao")
	EmployerDAO employerDao;

	@Autowired
	@Qualifier("employerValidator")
	EmployerValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/employer/emp/logout.htm", method = RequestMethod.GET)
	public ModelAndView EmployerLogout(HttpServletRequest request) {
		System.out.println("EmployerLogout");
		HttpSession sess = request.getSession();
		sess.setAttribute("user", null);
		return new ModelAndView("select_role");
	}

	@RequestMapping(value = "/employer/login.htm", method = RequestMethod.GET)
	public ModelAndView EmployerLogin() {
		System.out.println("EmployerLogin");
		return new ModelAndView("emp_login");
	}

	@RequestMapping(value = "/employer/login.htm", method = RequestMethod.POST)
	public String Employer_Login(HttpServletRequest request) {
		System.out.println("Employer_Login");
		HttpSession session = request.getSession();
		try {

			System.out.print("loginEmployer");

			Employer emp = employerDao.get(request.getParameter("username"), request.getParameter("password"));

			if (emp == null) {
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return "error";
			}

			session.setAttribute("user", emp);
			return "emp_home";
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
			return "error";
		}
	}

	@RequestMapping(value = "/employer/register.htm", method = RequestMethod.GET)
	public ModelAndView EmployerRegister() {
		System.out.println("employer_register");
		return new ModelAndView("emp_register", "employer", new Employer());
	}

	@RequestMapping(value = "/employer/register.htm", method = RequestMethod.POST)
	public ModelAndView Employer_Register(HttpServletRequest request, @ModelAttribute("employer") Employer emp,
			BindingResult result) throws Exception {
		validator.validate(emp, result);
		User u = employerDao.get(emp.getUsername());
		if (result.hasErrors() || u != null) {
			return new ModelAndView("emp_register", "employer", emp);
		}

		try {

			System.out.print("registerNewUser");
			Employer e = employerDao.register(emp);

			request.getSession().setAttribute("user", e);

			return new ModelAndView("emp_home", "user", e);

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
	}

}
