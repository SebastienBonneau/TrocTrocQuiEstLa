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
	
	<c:if test="${!empty sessionScope.utilisateur}"> <!-- si on trouve une session on affiche les href des pages disponible comme utilisateur connecter -->
		<a href="./encheres.jsp">Encheres</a>  <a href="./vendreArticle.jsp">Vendre un article</a>  <a href="./monProfil.jsp">Mon profil</a>  <a href="./seConnecter.jsp">Deconnexion</a> 
	</c:if>
	<c:if test="${empty sessionScope.utilisateur}"> <!-- si aucune session trouve on propose a l'utilisateur les href d'inscription ou de connexion -->
		<a href="./inscription.jsp">S'inscrire</a> - <a href="./seConnecter.jsp">Se connecter</a>
	</c:if>

</body>
</html>