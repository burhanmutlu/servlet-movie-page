package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.FilmDAO;
import com.entity.Film;

public class FilmAyrintiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int filmid = Integer.valueOf( request.getParameter("filmid") );
		
		Film film = new FilmDAO().filmAyrintiGetir(filmid);
		request.setAttribute("film", film);
		
		request.getRequestDispatcher("filmayrinti.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
