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

	<h1>ENI-Encheres</h1>
	
	<!-- 
	
	
	CHANGE LE LIEN DECONNEXION
	
	
	 -->
	<c:if test="${!empty sessionScope.utilisateur}"> <!-- si on trouve une session on affiche les href des pages disponible comme utilisateur connecter -->
		<a href="${pageContext.request.contextPath}/ServeltEnchere">Encheres</a>  <a href="${pageContext.request.contextPath}/ServletVendreArticle">Vendre un article</a>  <a href="${pageContext.request.contextPath}/ServletMonProfil">Mon profil</a>  <a href="${pageContext.request.contextPath}/ServletSeConnecter">Deconnexion</a> 
	</c:if>
	<c:if test="${empty sessionScope.utilisateur}"> <!-- si aucune session trouve on propose a l'utilisateur les href d'inscription ou de connexion -->
		<a href="${pageContext.request.contextPath}/ServletSinscrire">S'inscrire</a> - <a href="${pageContext.request.contextPath}/ServletSeConnecter">Se connecter</a>
	</c:if>
	
	<h2>Liste des enchères</h2>
	
	<form method="post" action="${pageContext.request.contextPath}/ServletAccueil">
		<label for="Filtre">Filtres : </label>
		<br />
		<input type="search" name="article" id="article"/>
		<br />
		<label for="categorie">Catégorie : </label>
		<select name="categorie">
		    <c:forEach items="${listCategorie}" var="categorie">
		        <option value="${categorie.id}"
		        	<cif test="${categorie.id eq selectedCatID}"selected="selected"></cif>
		        	>
		        	${categorie.libelle}
		        </option>
		    </c:forEach>
		</select>
	</form>
</body>
</html>