package com.me.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Reyes
 */
public class LoginController extends AbstractController {

    public LoginController() {
    }

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
        String remember = request.getParameter("rememberMe");
        ModelAndView mav = new ModelAndView();
        
        if (action.equals("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals("admin") && password.equals("admin")) {
                if (remember != null) {
                    Cookie cookie1 = new Cookie("username", username);
                    cookie1.setMaxAge(60);
                    Cookie cookie2 = new Cookie("password", password);
                    cookie2.setMaxAge(60);
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);
                }
                session.setAttribute("username", username);
                mav.setViewName("searchCourse");                
            } else {
                mav.setViewName("redirect:/redirect.jsp");
            }
            } else if (action.equals("logout")) {
            session.invalidate();
            mav.setViewName("redirect:/redirect.jsp");
        }
        return mav;
    }

}
