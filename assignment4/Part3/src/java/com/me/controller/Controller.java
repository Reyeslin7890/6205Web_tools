/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Reyes
 */
public class Controller extends AbstractController {

    public Controller() {
    }

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("1231231231233333333333333fffffffffffff");
        String quan = request.getParameter("quan");
        int q;
        try {
            q = Integer.parseInt(quan);
        } catch (Exception e) {
            return new ModelAndView("index");
        }
        if (q <= 0) {
            return new ModelAndView("index");
        }
        return new ModelAndView("add", "q", q);
    }
}
