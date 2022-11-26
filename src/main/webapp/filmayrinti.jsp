<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="header.jsp" />
   
   <h3>${film.ad}</h3>
   <table style="border:1px solid; border-color:gray;">
  <tr>
    <td>Senesi:</td>
    <td>${film.sene}</td>
  </tr>
  <tr>
    <td>Yönetmeni:</td>
    <td>${film.yonetmen.ad}</td>
  </tr>
  <tr>
    <td>Kategori:</td>
    <td>${film.kategori.ad}</td>
  </tr>
</table><br><br>

<a href="favoriekle?filmid=${film.id}">Favori olarak ekle</a>

   
    
<jsp:include page="footer.jsp" />