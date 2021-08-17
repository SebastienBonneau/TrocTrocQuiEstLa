<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Se Connecter</title>
</head>
<body>

	<h1> ENI-Enchères</h1>						
	
	<c:if test="${!empty success}">
	<span class="success">La création a été effectuée avec succès</span>
	</c:if>
	
	<c:if test="${!empty erreur}">
		<span class="error"> ${erreur}</span>
	</c:if>
	
	<form method="POST" action="./ServletSeConnecter">
	
		<label for="identifiant"> Identifiant : </label>
		<input type="text" name="identifiant" id="identifiant" />
			<br />
			<br />
			<br />
		<label for="motDePasse"> Mot de passe : </label>
		<input type="text" name="motDePasse" id="motDePasse" />
			<br />
			<br />
		<button type="submit" > Connexion </button>
			<br />
			<br />
		<input type="checkbox" /> Se souvenir de moi
			<br />
		<a href="..."> Mot de Passe oublié</a>
			
	</form>

	<form method="post" action="./ServletCreerUnCompte">
		<button type="submit">Creer un compte</button>
	</form>

</body>
</html>