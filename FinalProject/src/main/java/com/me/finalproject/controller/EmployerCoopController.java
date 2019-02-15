package com.me.finalproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.finalproject.dao.CoopDAO;
import com.me.finalproject.dao.EmployerDAO;
import com.me.finalproject.dao.StudentDAO;
import com.me.finalproject.pojo.Coop;
import com.me.finalproject.pojo.CoopStudent;
import com.me.finalproject.pojo.Employer;
import com.me.finalproject.pojo.Student;
import com.me.finalproject.pojo.User;
import com.me.finalproject.validator.CoopValidator;

@Controller
public class EmployerCoopController {

	@Autowired
	@Qualifier("coopValidator")
	CoopValidator validator;

	@Autowired
	@Qualifier("coopDao")
	CoopDAO coopDao;

	@Autowired
	@Qualifier("studentDao")
	StudentDAO studentDao;

	@Autowired
	@Qualifier("employerDao")
	EmployerDAO employerDao;

	@RequestMapping(value = "/employer/emp/post.htm", method = RequestMethod.GET)
	public ModelAndView coopForm() {
		return new ModelAndView("emp_post", "coop", new Coop());
	}

	@RequestMapping(value = "/employer/emp/post.htm", method = RequestMethod.POST)
	public ModelAndView coopSuccess(HttpServletRequest request, @ModelAttribute("coop") Coop coop, BindingResult result)
			throws Exception {

		validator.validate(coop, result);
		if (result.hasErrors()) {
			return new ModelAndView("emp_post", "coop", coop);
		}

		try {
			System.out.println("postcoop");
			HttpSession session = request.getSession();
			coop.setPostedby((Employer) session.getAttribute("user"));
			coopDao.savecoop(coop);
			return new ModelAndView("emp_post", "message", "Coop posted successfully");

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while post a coop");
		}
	}

	@RequestMapping(value = "/employer/emp/view.htm", method = RequestMethod.GET)
	public ModelAndView viewCoop(HttpServletRequest request) throws Exception {
		System.out.println("ViewCoop");
		HttpSession session = request.getSession();
		User emp = (User) session.getAttribute("user");
		try {
			List<Coop> coops = coopDao.get(emp.getUid());
			ObjectMapper mapper = new ObjectMapper();
			return new ModelAndView("emp_view", "coops", mapper.writeValueAsString(coops));
		} catch (Exception e) {
			System.out.println("Error in view coops: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while viewing coops");
		}
	}

	@RequestMapping(value = "/employer/emp/coop.htm", method = RequestMethod.GET)
	public ModelAndView viewDetail(HttpServletRequest request) throws Exception {
		try {
			String cid = request.getParameter("cid");
			Coop c = coopDao.getByCoopId(cid);
			ModelAndView mv = new ModelAndView("emp_viewdetail");
			mv.addObject("c", c);
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writeValueAsString(c.getCoopstudents()));
			mv.addObject("students", mapper.writeValueAsString(c.getCoopstudents()));
			return mv;
		} catch (Exception e) {
			System.out.println("Error in view detail: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while viewing details");
		}
	}

	@RequestMapping(value = "/employer/emp/operation.htm", method = RequestMethod.GET)
	public ModelAndView accept(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("emp_viewdetail");
		String csid = request.getParameter("csid");
		String status = request.getParameter("status");
		System.out.println("Accept:" + csid);
		try {
			CoopStudent cs = coopDao.updateCoopStudent(csid, status);
			Coop c = cs.getCoop();
			mv.addObject("c", cs.getCoop());
			System.out.println(c.getCid());
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writeValueAsString(c.getCoopstudents()));
			mv.addObject("students", mapper.writeValueAsString(c.getCoopstudents()));
			return mv;
		} catch (Exception e) {
			System.out.println("Error in view detail: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while viewing details");
		}
	}

	@ResponseBody
	@RequestMapping(value = "/employer/ajax.htm", method = RequestMethod.POST)
	public String ajax(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		try {
			User user = employerDao.get(username);
			if (user!=null) out.println("The username is occupied!");
		} catch (Exception e) {
			System.out.println("exception in ajax:" + e.getMessage());
		}
		
		return null;
	}
}
