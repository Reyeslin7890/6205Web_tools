package com.me.part3.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.part3.dao.MovieDAO;
import com.me.part3.pojo.Movie;

@Controller
@RequestMapping("/search.htm")
public class SearchController {

	@Autowired
	@Qualifier("movieDAO")
	MovieDAO movieDAO;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	protected ModelAndView searchMovie(HttpServletRequest request) {
		String keyword = request.getParameter("keyword");
		String searchby = request.getParameter("searchby");
		try {
			List<Movie> movies = movieDAO.search(keyword, searchby);
			request.getSession().setAttribute("result", movies);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("result","keyword",keyword);
	}

}
