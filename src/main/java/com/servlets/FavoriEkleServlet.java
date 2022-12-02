package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

import com.dao.FilmDAO;
import com.entity.Film;
import com.entity.Kisi;

public class FavoriEkleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int filmid = Integer.valueOf(request.getParameter("filmid"));
		
		Film film = new FilmDAO().filmAyrintiGetir(filmid);
		Kisi k = (Kisi)request.getSession().getAttribute("kullanici");
		HashSet<Film> favoriler = new HashSet<Film>();
		FilmDAO fdao = new FilmDAO();

		if (request.getSession().getAttribute("favoriler") != null) {
			favoriler = (HashSet<Film>)request.getSession().getAttribute("favoriler");
		}
		
		favoriler.add(film);
		if (k != null) {
			fdao.yeniFavoriEkle(film, k.getId());
		}

		request.getSession().setAttribute("favoriler", favoriler);
		request.getRequestDispatcher("filmdetay?filmid="+filmid).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
