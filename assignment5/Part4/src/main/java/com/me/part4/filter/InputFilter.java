package com.me.part4.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InputFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String q = request.getParameter("q");
		if (q != null && q.matches("\\d+") && Integer.parseInt(q) > 0) {
			if (request.getParameter("txt11") != null)
			{
				for (int i = 1; i <= Integer.parseInt(q); i++) {
					if (!request.getParameter("txt" + i + "1").matches("^([0-9]+-)+[0-9]+$"))
						request.getRequestDispatcher("/books.htm").forward(request, response);
					if (!request.getParameter("txt" + i + "2").matches("^[A-Za-z0-9, ]++$"))
						request.getRequestDispatcher("/books.htm").forward(request, response);
					if (!request.getParameter("txt" + i + "3").matches("^[A-Za-z0-9. ]++$"))
						request.getRequestDispatcher("/books.htm").forward(request, response);
					if (!request.getParameter("txt" + i + "4").matches("^[0-9]+.[0-9]{0,2}$"))
						request.getRequestDispatcher("/books.htm").forward(request, response);
				}
			}
			chain.doFilter(request, response);
		} else
			request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
