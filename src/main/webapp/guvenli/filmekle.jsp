<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../header.jsp" />
   
  <form method="get" action="${rootPath }/filmekle">
		<table>
			<tr>
				<td>Film Türü:</td>
				<td>
					<select id="kategori-selectbox" name="askategori">
						<option selected disabled>Birini seçiniz</option>
						<c:forEach items="${kategoriler}" var="kategori">
							<option value="${kategori.id}">&nbsp;${kategori.ad}</option>
						</c:forEach>  
						<option value="diger">&nbsp;Diğer</option>
					</select>
					<input id="_kategori" type="text" name="kategori"> 
				</td>
			</tr>
			<tr>
				<td>Film Adı:</td>
				<td><input  type="text" name="filmadi"></td>
			</tr>
			<tr>
				<td>Yönetmen:</td>
				<td><input  type="text" name="yonetmen"></td>
			</tr>
			<tr>
				<td>Sene:</td>
				<td><input  type="text" name="sene"></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="Ekle"></td>
			</tr>
		</table>
		
		<c:if test="${not empty mesaj }">
			<p>mesaj</p>
		</c:if>
	</form>
    
<jsp:include page="../footer.jsp" />
