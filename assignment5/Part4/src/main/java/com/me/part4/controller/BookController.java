package com.me.part4.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/books.htm")
public class BookController {

	@RequestMapping(value = "/", method = RequestMethod.POST)
	protected ModelAndView goToBook(HttpServletRequest request) {
		System.out.println("BookController");
		int q = Integer.parseInt(request.getParameter("q"));        
        if (q <= 0) {
            return new ModelAndView("index");
        }
        return new ModelAndView("add", "q", q);
	}
}
