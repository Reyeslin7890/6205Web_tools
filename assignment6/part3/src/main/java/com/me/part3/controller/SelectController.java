package com.me.part3.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/movie.htm")
public class SelectController {

	@RequestMapping(value = "movie.htm", method = RequestMethod.POST)
	protected ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String selection = request.getParameter("selection");
		ModelAndView mv = new ModelAndView("index");
		if (selection.equals("Add New Movie to Database"))
			mv.setViewName("redirect:/movieform.htm");
		if (selection.equals("Browse Movies"))
			mv.setViewName("search");
		return mv;
	}
}
