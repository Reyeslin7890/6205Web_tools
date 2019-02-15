package com.me.finalproject.fiter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.me.finalproject.pojo.Employer;


public class EmployerLoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			System.out.println("EmpFilter");
			if (session.getAttribute("user")==null || !(session.getAttribute("user") instanceof Employer)) request.getRequestDispatcher("/").forward(request, response);
			else chain.doFilter(request, response);		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
