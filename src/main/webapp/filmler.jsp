<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="header.jsp" />
   
   <c:forEach items="${filmler}" var="film" >
   		<a href="filmdetay?filmid=${film.id}">${film.ad}</a><br>
   </c:forEach>
    
<jsp:include page="footer.jsp" />