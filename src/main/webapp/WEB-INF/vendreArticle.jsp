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
<h1>Mon article à vendre</h1>


<c:if test="${!empty erreurPseudo}"> <!-- si une erreur d'identifiant ou de mot de passe est detecter on affiche le message personalisee pour ce cas -->
		<span> ${erreurPseudo}</span>
	</c:if> <br /><br />

<form method="post" action="${pageContext.request.contextPath}/ServletVendreUnArticle">
	
		<label for="nomArticle"> Nom de votre article : </label>
		<input type="text" name="nomArticle" id="nomArticle" required="required" />
	<br />
	<br />
		<label for="description"> Description de l'article : </label>
		<textarea name="description" id="description" required="required" rows="4" cols="50"/></textarea>
	<br />
	<br />
		<label for="date_debut_enchere"> date de début de l'enchère : </label>
		<input type="datetime-local" name="date_debut_enchere" id="date_debut_enchere" required="required" />
	<br />
	<br />
		<label for="date_fin_enchere"> date de fin de l'enchère : </label>
		<input type="datetime-local" name="date_fin_enchere" id="date_fin_enchere" required="required" />
	<br />
	<br />
		<label for="prix_initial"> Prix de base de l'enchère : </label>
		<input type="number" name="prix_initial" id="prix_initial" required="required"/>
	<br />
	<br />
		<label for="categorie"> Catégorie de l'article : </label>
		<input type="number" name="categorie" id="categorie" required="required" />
	<br />
	
	<button type="submit">Créer</button>
</form>
		<br />
		<br />
<form method="get" action="${pageContext.request.contextPath }/accueil">
	<button type="submit">Annuler</button>
</form>
		
		


</body>
</html>