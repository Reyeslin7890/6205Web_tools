package com.me.part3.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.part3.dao.MovieDAO;
import com.me.part3.pojo.Movie;

@Controller
@RequestMapping("/movieform.htm")
public class MovieFormController {

	@Autowired
	@Qualifier("movieDAO")
	MovieDAO movieDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected ModelAndView initForm(HttpServletRequest request) {
		return new ModelAndView("movieform", "movie", new Movie());
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	protected ModelAndView addMovie(@ModelAttribute("movie") Movie movie, BindingResult result) {
		try {
			movieDAO.create(movie);			
			return new ModelAndView("moviesuccess");
		} catch (Exception e) {
			System.out.println("error with adding movie: "+e.getMessage());
			return new ModelAndView("index");
		}
	}

}
