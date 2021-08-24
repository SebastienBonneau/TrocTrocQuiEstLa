	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Mon profil</h1>


	<c:if test="${!empty erreurPseudo}"> <!-- si une erreur De pseudo existant est detecter on affiche le message personalisee pour ce cas -->
			<span> ${erreurPseudo}</span>
		</c:if> <br /><br />

<form method="post" action="${pageContext.request.contextPath}/ServletSinscrire">
		<label for="pseudo"> Pseudo : </label>
		<input type="text" name="pseudo" id="pseudo" required="required" />
	<br />
	<br />
		<label for="prenom"> Prenom : </label>
		<input type="text" name="prenom" id="prenom" required="required" />
	<br />
	<br />
		<label for="telephone"> Téléphone : </label>
		<input type="tel" name="telephone" id="telephone" required="required" />
	<br />
	<br />
		<label for="codePostal"> Code postal : </label>
		<input type="text" name="codePostal" id="codePostal" required="required" />
	<br />
	<br />
		<label for="motDePasse"> Mot de passe : </label>
		<input type="password" name="motDePasse" id="motDePasse" required="required"/>
	<br />
	<br />
		<label for="nom"> Nom : </label>
		<input type="text" name="nom" id="nom" required="required" />
	<br />
	<br />
		<label for="email"> Email : </label>
		<input type="email" name="email" id="email" required="required" autofocus="autofocus" />
	<br />
	<br />
		<label for="rue">  Rue : </label>
		<input type="text" name="rue" id="rue" required="required"/>
	<br />
	<br />
		<label for="ville"> Ville : </label>
		<input type="text" name="ville" id="ville" required="required"/>
	<br />
	<br />
		<label for="confirmation"> Confirmation : </label>
		<input type="password" name="confirmation" id="confirmation" required="required"/>
		<br />
	<br />
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