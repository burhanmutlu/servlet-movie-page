package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.dao.FilmDAO;
import com.entity.Film;
import com.entity.Kategori;
import com.entity.Yonetmen;

public class FilmEkleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Kategori k = new Kategori();
		Yonetmen y = new Yonetmen();
		
		k.setAd(request.getParameter("kategori"));
		y.setAd(request.getParameter("yonetmen"));
		String filmAdi = request.getParameter("filmadi");
		int sene = Integer.valueOf( request.getParameter("sene"));
		
		Film f = new Film();
		f.setKategori(k);
		f.setYonetmen(y);
		f.setAd(filmAdi);
		f.setSene(sene);
		
		FilmDAO fdao = new FilmDAO();
		
		boolean b = fdao.yeniFilmEkle(f);

		if (b) {
			response.sendRedirect("index.jsp");
		} else {
			String mesaj = "tekrar deneyiniz";
			request.setAttribute("mesaj", mesaj);
			request.getRequestDispatcher( "${rootPath}/guvenli/filmekle.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
