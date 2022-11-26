<%@page import="com.dao.KategoriDAO"%>
<%@page import="com.entity.Kategori"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%
    	ArrayList<Kategori> kategoriler = new KategoriDAO().butunKategorileriGetir();
    	request.setAttribute("kategoriler", kategoriler);
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Film Sitesi</title>
</head>
<body>
<div id="main">
	<div id="header">
		<h2>Film Sitesi</h2>
	</div>
	<div>
		<a href="index.jsp">Anasayfa</a>&nbsp;&nbsp;&nbsp;
		<a href="hakkimizda.jsp">Hakkımızda</a>&nbsp;&nbsp;&nbsp;
		<a href="login.jsp">Üye Girişi</a>&nbsp;&nbsp;&nbsp;
	</div>
	
	<div id="contentmain">
		<div id="menu">
			<c:forEach items="${kategoriler}" var="kategori">
			
				<a href="filmler?katid=${kategori.getId()}">${kategori.getAd()}</a><br>
			
			</c:forEach>
			
		<br><hr>
		</div>
		<div id="content">
