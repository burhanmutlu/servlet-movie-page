package com.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GuvenlikFiltre extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		if( ((HttpServletRequest)request).getSession().getAttribute("kullanici")==null ) {
			String path = request.getServletContext().getContextPath();
			((HttpServletResponse)response).sendRedirect(path + "/uyegiris.jsp");
		}
		
		chain.doFilter(request, response);
	}

}
