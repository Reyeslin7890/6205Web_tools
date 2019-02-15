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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Reyes
 */
public class AddController extends AbstractController {

    public AddController() {
    }

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int q = Integer.parseInt(request.getParameter("q"));
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stm = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/booksdb", "root", "7890");
            String query = "insert into book value (?,?,?,?);";
            stm = conn.prepareStatement(query);
            for (int i = 1; i <= q; i++) {
                for (int j = 1; j <= 3; j++) {
                    String txt = request.getParameter("txt" + i + j);
                    stm.setString(j, txt);
                }
                String txt = request.getParameter("txt" + i + "4");
                stm.setFloat(4, Float.parseFloat(txt));
                stm.execute();
            }
        } catch (NumberFormatException e) {
            System.err.println("NumberFormatException" + e.getMessage());
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
        return new ModelAndView("success", "q", q);
    }

}
