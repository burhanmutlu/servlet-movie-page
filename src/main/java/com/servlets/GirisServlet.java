package com.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.abstracts.KullaniciDAO;

/**
 * Servlet implementation class GirisServlet
 */
public class GirisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GirisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String kullanici = request.getParameter("kullaniciadi");
		String sifre = request.getParameter("sifre");
		
		boolean k = new com.dao.KullaniciDAO().kullaniciKontrol(kullanici, sifre);
	
		
		if (k) {
			request.getSession().setAttribute("kullanici", kullanici);
			response.sendRedirect("index.jsp");
		} else {
			String mesaj = "Kullanıcı adı veya şifre hatalı";
			request.setAttribute("mesaj", mesaj);
			request.getRequestDispatcher("uyegiris.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
