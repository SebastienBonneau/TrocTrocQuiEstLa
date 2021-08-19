<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="include/header.jsp"></jsp:include>
	
	<h2>Liste des enchères</h2>
	
	<form method="post" action="${pageContext.request.contextPath}/ServletAccueil">
		<label for="Filtre">Filtres : </label>
		<br />
		<input type="search" name="artsearch" id="artsearch"/>
		<br />
		<label for="categorie">Catégorie : </label>
		<select name="categorie">
		    <c:forEach items="${listCategorie}" var="categorie">
		        <option value="${categorie.id}">${categorie.name}</option>
		    </c:forEach>
		</select>
		
	</form>
</body>
</html>