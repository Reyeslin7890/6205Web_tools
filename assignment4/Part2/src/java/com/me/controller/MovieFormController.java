/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.pojo.Movie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Reyes
 */
public class MovieFormController extends SimpleFormController {

    public MovieFormController() {
        //Initialize controller properties here or 
        //in the Web Application Context
        setCommandClass(Movie.class);
        setCommandName("movie");
        setSuccessView("moviesuccess");
        setFormView("movieform");
    }

    @Override
    protected void doSubmitAction(Object command) throws Exception {
        Movie movie = (Movie) command;

        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        sess.save(movie);
        tx.commit();
        sess.close();

    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    /*
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object command, 
            BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView(getSuccessView());
        //Do something...
        return mv;
    }
     */
}
