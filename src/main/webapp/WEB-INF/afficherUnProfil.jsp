<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>

	<h1>Mon Profil</h1>
	
	<c:if test="${!empty sessionScope.utilisateur}"> <!-- si on trouve une session on affiche les href des pages disponible comme utilisateur connecter -->
		<ul>
			<li>Pseudo : ${utilisateur.pseudo}</li>
			<li>Nom : ${utilisateur.nom}</li>
			<li>Prénom : ${utilisateur.prenom}</li>
			<li>Email : ${utilisateur.email}</li>
			<li>Téléphone : ${utilisateur.telephone}</li>
			<li>Rue : ${utilisateur.rue}</li>
			<li>Code Postal : ${utilisateur.code_postal}</li>
			<li>Ville : ${utilisateur.ville}</li>
		</ul>
	</c:if>
	
	<form method="post" action="${pageContext.request.contextPath}/ServletModifierMonProfil">
		<button type="submit">Modifier</button>
	</form>
	
	<form method="post" action="${pageContext.request.contextPath}/accueil">
		<button type="submit">Accueil</button>
	</form>
	
</body>
</html>