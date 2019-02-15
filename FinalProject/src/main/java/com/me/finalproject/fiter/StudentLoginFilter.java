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

import com.me.finalproject.pojo.Student;


public class StudentLoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			if (session.getAttribute("user")==null || !(session.getAttribute("user") instanceof Student)) request.getRequestDispatcher("/").forward(request, response);
			else chain.doFilter(request, response);		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
