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
<link rel="stylesheet" href="assets/style.css">
</head>
<body>
<div id="main">
	<div id="header">
		<h2>Film Sitesi</h2>
	</div>
	<div>
		<a href="index.jsp">Anasayfa</a>&nbsp;&nbsp;&nbsp;
		<c:if test="${empty kullanici }">
			<a href="uyegiris.jsp">Üye Girişi</a>&nbsp;&nbsp;&nbsp;
			<a href="uyekayit.jsp">Üye Kayıt</a>&nbsp;&nbsp;&nbsp;
		</c:if>
		<c:if test="${not empty kullanici }">
			<a href="uyecikis">Üye Çıkışı</a>&nbsp;&nbsp;&nbsp;
			<a href="guvenli/filmekle.jsp">Film Ekle</a>&nbsp;&nbsp;&nbsp;
		</c:if>
		
		<c:if test="${not empty kullanici }" >
			<span>merhaba ${kullanici}</span>
		</c:if>
	</div>
	
	<div id="contentmain">
		<div id="menu">
			<h4>Kategoriler</h4>
				<c:forEach items="${kategoriler}" var="kategori">
					<a href="filmler?katid=${kategori.getId()}">${kategori.getAd()}</a><br>
				</c:forEach>
				
			<br><hr>
			<c:if test="${not empty favoriler}">
				<h4>Favoriler</h4>
				<c:forEach items="${favoriler}" var="film" >
					<a href="filmdetay?filmid=${film.id}">${film.ad }</a><br>
				</c:forEach>
			</c:if>
		</div>
		<div id="content">
