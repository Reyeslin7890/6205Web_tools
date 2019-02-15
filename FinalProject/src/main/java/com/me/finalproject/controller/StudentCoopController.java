package com.me.finalproject.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.me.finalproject.dao.CoopDAO;
import com.me.finalproject.dao.ResumeDAO;
import com.me.finalproject.dao.StudentDAO;
import com.me.finalproject.pojo.Resume;
import com.me.finalproject.pojo.Student;
import com.me.finalproject.pojo.User;
import com.me.finalproject.pojo.Coop;
import com.me.finalproject.validator.CoopValidator;

@Controller
public class StudentCoopController {
	@Autowired
	@Qualifier("coopValidator")
	CoopValidator validator;

	@Autowired
	@Qualifier("studentDao")
	StudentDAO studentDao;

	@Autowired
	@Qualifier("coopDao")
	CoopDAO coopDao;

	@Autowired
	@Qualifier("resumeDao")
	ResumeDAO resumeDao;

	@RequestMapping(value = "/student/stu/upload.htm", method = RequestMethod.GET)
	public ModelAndView uploadForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return new ModelAndView("student_upload", "resume", new Resume());
	}

	@RequestMapping(value = "/student/stu/upload.htm", method = RequestMethod.POST)
	public ModelAndView uploadSuccess(HttpServletRequest request, @ModelAttribute("resume") Resume resume,
			BindingResult result) throws Exception {
		CommonsMultipartFile fileinMemory = resume.getResume();
		resume.setFilename(fileinMemory.getOriginalFilename());
		File file = new File("C:/Users/Reyes/Desktop/New folder", fileinMemory.getOriginalFilename());
		fileinMemory.transferTo(file);
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("user");
		try {
			resumeDao.saveResume(resume, student.getUid());
		} catch (Exception e) {
			System.out.println("Error in saving resume:" + e.getMessage());
			return new ModelAndView("student_home", "message", "Upload Fail");
		}
		return new ModelAndView("student_home", "message", "Upload Success");
	}

	@RequestMapping(value = "/student/stu/search.htm", method = RequestMethod.GET)
	public ModelAndView searchcoop(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String search = request.getParameter("search");
		String by = request.getParameter("by");
		System.out.println("in search coop");
		List<Coop> coops = null;
		try {
			if (by != null && by.equals("org"))
				coops = coopDao.searchEmp(search);
			if (by != null && by.equals("title"))
				coops = coopDao.searchTitle(search);
		} catch (Exception e) {
			System.out.println("error in search coop:" + e.getMessage());
		}
		ObjectMapper mapper = new ObjectMapper();
		session.setAttribute("coops", mapper.writeValueAsString(coops));
		return new ModelAndView("student_search");
	}

	@RequestMapping(value = "/student/stu/apply.htm", method = RequestMethod.GET)
	public ModelAndView applycoop(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cid = request.getParameter("cid");
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("user");
		try {
			String message = "Apply Success";
			if (studentDao.updateStudent(cid, student)==null) message = "Already applied";
			return new ModelAndView("student_search", "message", message);
		} catch (Exception e) {

			System.out.println("error in apply coop:" + e.getMessage());
			return new ModelAndView("student_search", "message", "Apply failed");
		}

	}

	@RequestMapping(value = "/student/stu/view.htm", method = RequestMethod.GET)
	public ModelAndView viewcoop(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StudentViewCoop");
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("user");
		try {
			Student s = studentDao.get(student.getUid());
			System.out.println(s.getUid());
			ObjectMapper mapper = new ObjectMapper();
			return new ModelAndView("student_view", "cs", mapper.writeValueAsString(s.getCoopstudent()));
		} catch (Exception e) {

			System.out.println("error in view coop:" + e.getMessage());
			return new ModelAndView("error", "errorMessage", "View coop failed");
		}

	}

}
