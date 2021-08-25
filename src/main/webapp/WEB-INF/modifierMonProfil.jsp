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

	<h1>Modifier mon profil</h1>

	<c:if test="${!empty sessionScope.utilisateur}"> <!-- si on trouve une session on affiche les href des pages disponible comme utilisateur connecter -->
	
		<form method="post" action="${pageContext.request.contextPath}/ServletEnregistrerModificationDuProfil">
				<input type="hidden" id="no_utilisateur" name="no_utilisateur" value="${utilisateur.no_utilisateur}">
				<label for="pseudo"> Pseudo : </label>
				<input type="text" name="pseudo" id="pseudo" required="required" value="${utilisateur.pseudo}"/>
			<br />
			<br />
				<label for="prenom"> Prenom : </label>
				<input type="text" name="prenom" id="prenom" required="required" value="${utilisateur.prenom}"/>
			<br />
			<br />
				<label for="telephone"> Téléphone : </label>
				<input type="tel" name="telephone" id="telephone" required="required" value="${utilisateur.telephone}"/>
			<br />
			<br />
				<label for="codePostal"> Code postal : </label>
				<input type="text" name="codePostal" id="codePostal" required="required" value="${utilisateur.code_postal}"/>
			<br />
			<br />
				<label for="motDePasse"> Mot de passe : </label>
				<input type="password" name="motDePasse" id="motDePasse" required="required" value="${utilisateur.mot_de_passe}"/>
			<br />
			<br />
				<label for="nom"> Nom : </label>
				<input type="text" name="nom" id="nom" required="required" value="${utilisateur.nom}"/>
			<br />
			<br />
				<label for="email"> Email : </label>
				<input type="email" name="email" id="email" required="required" autofocus="autofocus" value="${utilisateur.email}"/>
			<br />
			<br />
				<label for="rue">  Rue : </label>
				<input type="text" name="rue" id="rue" required="required" value="${utilisateur.rue}"/>
			<br />
			<br />
				<label for="ville"> Ville : </label>
				<input type="text" name="ville" id="ville" required="required" value="${utilisateur.ville}"/>
			<br />
			<br />
				<label for="confirmation"> Confirmation : </label>
				<input type="password" name="confirmation" id="confirmation" required="required" value="${utilisateur.mot_de_passe}"/>
				<br />
			<br />
			<br />
			<button type="submit">Enregistrer</button>
		</form>
			<br />
			<br />
		<form method="get" action="${pageContext.request.contextPath }/ServletSupprimerMonCompte">
			<button type="submit">Supprimer</button>
		</form>

	</c:if>
	
</body>
</html>