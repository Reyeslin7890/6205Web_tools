package com.me.part4.controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.part4.pojo.Book;

@Controller
@RequestMapping("/add.htm")
public class AddController {

	@RequestMapping(value = "/", method = RequestMethod.POST)
	protected ModelAndView addBooks(HttpServletRequest request) throws Exception {
		int q = Integer.parseInt(request.getParameter("q"));

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session ses = sf.openSession();

		try {
			ses.beginTransaction();
			for (int i = 1; i <= q; i++) {
				Book b = new Book();
				b.setIsbn(request.getParameter("txt" + i + "1"));
				b.setTitle(request.getParameter("txt" + i + "2"));
				b.setAuthor(request.getParameter("txt" + i + "3"));
				b.setPrice(Double.parseDouble(request.getParameter("txt" + i + "4")));
				ses.save(b);
			}
			ses.getTransaction().commit();
			ses.close();
		} catch (HibernateException e) {
			ses.getTransaction().rollback();
			throw new Exception("Exception while adding books: " + e.getMessage());
		}
		return new ModelAndView("success");
	}
}
