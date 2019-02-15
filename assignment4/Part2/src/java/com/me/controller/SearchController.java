/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Reyes
 */
public class SearchController extends AbstractController {

    public SearchController() {
    }

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String keyword = request.getParameter("keyword");
        ModelAndView mv = new ModelAndView("result", "keyword", keyword);
        HttpSession session = request.getSession();
        String sb = request.getParameter("searchby");
        Connection conn = null;
        ResultSet rs = null;
        Statement stm = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/moviedb", "root", "7890");
            stm = conn.createStatement();
            String sql = "select * from movies where " + sb + " like '%" + keyword + "%'";
            rs = stm.executeQuery(sql);
            ArrayList<String[]> result = new ArrayList<>();
            while (rs.next()) {
                String[] temp = new String[5];
                temp[0] = rs.getString(1);
                temp[1] = rs.getString(2);
                temp[2] = rs.getString(3);
                temp[3] = rs.getString(4);
                temp[4] = rs.getString(5);
                result.add(temp);
            }
            session.setAttribute("result", result);            
        } catch (SQLException e) {
            System.err.println("SQLException" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException" + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                 System.err.println("Finally SQLException" + e.getMessage());
            }
        }
        return mv;
    }

}
