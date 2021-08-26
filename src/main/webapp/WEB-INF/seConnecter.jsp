	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Se Connecter</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>

<div id="fond" >
	<h1> TrocTroc Qui est la ?</h1>						
</div>	

	<c:if test="${!empty erreur}"> <!-- si une erreur d'identifiant ou de mot de passe est detecter on affiche le message personalisee pour ce cas -->
		<span> ${erreur}</span>
	</c:if> <br /><br />
	
	
	
	<form method="post" action="${pageContext.request.contextPath}/ServletSeConnecter">
	<br />
	<br />
	<br />
	<br />
	<br />
	<div class="identifiant">
		
		<input type="text" name="identifiant" placeholder="Pseudo ou Email" id="identifiant" />
	</div>
			<br />
			<br />
		<input type="password" name="motDePasse" placeholder="Mot de passe" id="motDePasse" />
			<br />
			<br />
			<br />
			<br />
		<button type="submit" id="connexion" > Connexion </button>
			<br />
			<br />
		<input type="checkbox" /> Se souvenir de moi
			<br />
		<a href="..."> Mot de Passe oublié</a>
			
	</form>

	<form method="get" action="./ServletSinscrire">
		<button type="submit">Creer un compte</button>
	</form>

</body>
</html>