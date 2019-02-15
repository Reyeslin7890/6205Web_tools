package com.me.part2.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.me.part2.view.MyView;


@Controller
public class DataController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage() {
		return "index";
	}

	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public ModelAndView pagination(HttpServletRequest request) {
		String pg = request.getParameter("pg");
		System.out.println(pg);
		return new ModelAndView("index", "pg", pg);
	}

	@RequestMapping(value = "/connect.htm", method = RequestMethod.POST)
	public ModelAndView connect(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("index");
		HttpSession sess = request.getSession();
		String filename = request.getParameter("filename");
		ArrayList<String[]> rs = new ArrayList<String[]>();

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
			mv.addObject("pg", 1);
		} catch (SQLException e) {
			System.err.println("SQLException" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException" + e.getMessage());
		}
		return mv;
	}

	@RequestMapping(value = "/salesorder.xls", method = RequestMethod.POST)
	protected ModelAndView saveExcel() {		
		return new ModelAndView(new MyView());

	}
}
