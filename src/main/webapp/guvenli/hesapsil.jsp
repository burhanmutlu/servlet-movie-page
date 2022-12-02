<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="../header.jsp" />
   
   Hesabınızı silmek için aşağıdaki şifrenizi giriniz.

   
   <form method="post" action="hesapsil">
   	<table>
	   	<tr>
	   		<td>
	   			<input type="password" name="sifre">
	   		</td>
	   		<td>
	   			<input type="submit" value="hesabı sil">
	   		</td>
	   	</tr>
   	</table>
   	
   	<c:if test="${not empty mesaj }">
			<p style="color: red">${mesaj }</p>
	</c:if>
   </form>

    
<jsp:include page="../footer.jsp" />