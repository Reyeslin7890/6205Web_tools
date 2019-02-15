/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
        ModelAndView mv = new ModelAndView("index");
        String action = request.getParameter("action");
        
        if (action != null && action.equals("conn")) {
            String filename = request.getParameter("filename");
            mv.addObject("filename", filename);
        } else if (action != null && action.equals("add")) {
            ArrayList<String[]> rs = (ArrayList<String[]>) request.getSession().getAttribute("rs");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ass4", "root", "7890");
                String temp = "insert into Part7 value (";
                for (int i = 0; i < 24; i++) {
                    temp += "?,";
                }
                temp += "?);";
                PreparedStatement stm = conn.prepareStatement(temp);
                int i = 0;
                for (String[] str : rs){
                    i++;
                    for (int j = 1; j <= 25; j++) {
                        stm.setString(j, str[j-1]);
                    }
                    stm.addBatch();
                }
                mv.addObject("rowcount", i);
                stm.executeBatch();
                stm.close();
                conn.close();                
                return mv;
            } catch (SQLException e) {
                System.err.println("SQLException" + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.err.println("ClassNotFoundException" + e.getMessage());
            }
        }
        return mv;
    }

}
