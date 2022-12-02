package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.dao.abstracts.KullaniciDAO;
import com.entity.Kisi;

public class KullaniciSilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String sifre = request.getParameter("sifre");
		
		Kisi kisi = (Kisi)request.getSession().getAttribute("kullanici");
		
		if (sifre.equals(kisi.getSifre()) ) {
			
			KullaniciDAO k = new com.dao.KullaniciDAO();
			if (k.kullaniciSil(kisi)) {
				request.getSession().invalidate();
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} else {
			String mesaj = "hatalı";
			request.setAttribute("mesaj", mesaj);
			request.getRequestDispatcher("hesapsil.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
