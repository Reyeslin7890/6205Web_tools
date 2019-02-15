/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        HttpSession sess = request.getSession();
        if (action != null && action.equals("conn")) {
            String filename = request.getParameter("filename");
            ArrayList<String[]> rs = new ArrayList<>();
            try {
                Class.forName("org.relique.jdbc.csv.CsvDriver");
                Connection conn = DriverManager.getConnection("jdbc:relique:csv:d:/");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet results = stmt.executeQuery("SELECT * FROM " + filename);
                int count = 0;
                while (results.next()) {
                    String[] row = new String[25];
                    for (int i = 0; i < 25; i++) {
                        row[i] = results.getString(i + 1);
                    }
                    rs.add(row);                    
                }
                results.close();
                stmt.close();
                conn.close();
                sess.setAttribute("rs", rs);
            } catch (SQLException e) {
                System.err.println("SQLException" + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.err.println("ClassNotFoundException" + e.getMessage());
            }
        } else if (action != null && action.equals("add")) {
            ArrayList<String[]> rs = (ArrayList<String[]>) sess.getAttribute("rs");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ass4", "root", "7890");
                String temp = "insert into Part6 value (";
                for (int i = 0; i < 24; i++) {
                    temp += "?,";
                }
                temp += "?);";
                PreparedStatement stm = conn.prepareStatement(temp);
                int i = 0;
                for (String[] row : rs) {
                    i++;
                    for (int j = 1; j <= 25; j++) {
                        stm.setString(j, row[j-1]);
                    }
                    stm.addBatch();                   
                }
                stm.executeBatch();
                stm.close();
                conn.close();
                mv.addObject("rowcount", i);
                sess.setAttribute("rs", null);
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
