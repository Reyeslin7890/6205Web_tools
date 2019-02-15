package com.me.finalproject.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.finalproject.dao.StudentDAO;
import com.me.finalproject.pojo.Student;
import com.me.finalproject.pojo.User;
import com.me.finalproject.validator.StudentValidator;

@Controller
public class StudentController {
	@Autowired
	@Qualifier("studentDao")
	StudentDAO studentDao;

	@Autowired
	@Qualifier("studentValidator")
	StudentValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/student/stu/logout.htm", method = RequestMethod.GET)
	public ModelAndView EmployerLogout(HttpServletRequest request) {
		System.out.println("StudentLogout");
		HttpSession sess = request.getSession();
		sess.setAttribute("user", null);
		return new ModelAndView("select_role");
	}
	
	@RequestMapping(value = "/student/login.htm", method = RequestMethod.GET)
	public ModelAndView studentLogin() {
		System.out.println("StudentLogin");
		return new ModelAndView("student_login");
	}

	@RequestMapping(value = "/student/login.htm", method = RequestMethod.POST)
	public String student_Login(HttpServletRequest request) {
		System.out.println("Student_Login_Post");
		HttpSession session = request.getSession();
		try {

			System.out.print("loginStudent");

			Student student = studentDao.get(request.getParameter("username"), request.getParameter("password"));

			if (student == null) {
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return "error";
			}

			session.setAttribute("user", student);
			return "student_home";
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
			return "error";
		}
	}

	@RequestMapping(value = "/student/register.htm", method = RequestMethod.GET)
	public ModelAndView studentRegister() {
		System.out.println("Student_register");
		return new ModelAndView("student_register", "student", new Student());
	}

	@RequestMapping(value = "/student/register.htm", method = RequestMethod.POST)
	public ModelAndView student_Register(HttpServletRequest request, @ModelAttribute("student") Student student,
			BindingResult result) throws Exception {
		validator.validate(student, result);
		User u = studentDao.get(student.getUsername());
		if (result.hasErrors() || u!=null) {
			return new ModelAndView("student_register", "student", student);
		}

		try {

			System.out.print("registerNewUser");
			Student s = studentDao.register(student);

			request.getSession().setAttribute("user", s);

			return new ModelAndView("student_home");

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/student/ajax.htm", method = RequestMethod.POST)
	public String ajax(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		try {
			User user = studentDao.get(username);
			if (user!=null) out.println("The username is occupied!");
		} catch (Exception e) {
			System.out.println("exception in ajax:" + e.getMessage());
		}
		
		return null;
	}

}
