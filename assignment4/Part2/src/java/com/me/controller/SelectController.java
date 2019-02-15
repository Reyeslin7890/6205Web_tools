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
public class SelectController extends AbstractController {

    public SelectController() {
    }

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String selection = request.getParameter("selection");
        if (selection.equals("Browse Movies")) {
            mv.setViewName("search");
        } else{
            mv.setViewName("redirect:/movieform.htm");
        }
        return mv;
    }

}
