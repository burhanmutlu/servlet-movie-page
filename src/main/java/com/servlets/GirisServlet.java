package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.abstracts.KullaniciDAO;
import com.entity.Kisi;

public class GirisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Kisi kullanici = new Kisi(request.getParameter("kullaniciadi"), request.getParameter("sifre"));
		
		boolean k = new com.dao.KullaniciDAO().kullaniciKontrol(kullanici);
		
		if (k) {
			KullaniciDAO kdao = new com.dao.KullaniciDAO();
			kullanici.setId( kdao.getKullaniciHesapId(kullanici) );
			request.getSession().setAttribute("kullanici", kullanici);
			response.sendRedirect("index.jsp");
		} else {
			String mesaj = "Kullanıcı adı veya şifre hatalı";
			request.setAttribute("mesaj", mesaj);
			request.getRequestDispatcher("uyegiris.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
