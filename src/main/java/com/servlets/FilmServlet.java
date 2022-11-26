package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.dao.FilmDAO;
import com.entity.Film;

/**
 * Servlet implementation class FilmlerServlet
 */
public class FilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int katid = Integer.valueOf(request.getParameter("katid"));
		ArrayList<Film> filmler = new FilmDAO().kategoriyeAitFilmleriGetir(katid);
		request.setAttribute("filmler", filmler);
		request.getRequestDispatcher("filmler.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
