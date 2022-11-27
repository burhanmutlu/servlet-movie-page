package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.dao.FilmDAO;
import com.entity.Film;

/**
 * Servlet implementation class FavoriEkleServlet
 */
public class FavoriEkleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriEkleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int filmid = Integer.valueOf(request.getParameter("filmid"));
		
		Film film = new FilmDAO().filmAyrintiGetir(filmid);
		
		ArrayList<Film> favoriler = new ArrayList<Film>();
		if (request.getSession().getAttribute("favoriler") != null) {
			favoriler = (ArrayList<Film>)request.getSession().getAttribute("favoriler");
		}
		
		favoriler.add(film);
		request.getSession().setAttribute("favoriler", favoriler);
		
		request.getRequestDispatcher("filmdetay?filmid="+filmid).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
