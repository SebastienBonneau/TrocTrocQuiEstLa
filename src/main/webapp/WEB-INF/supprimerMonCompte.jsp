	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Suppression compte</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<c:if test="${!empty erreur}"> <!-- si une erreur d'identifiant ou de mot de passe est detecter on affiche le message personalisee pour ce cas -->
		<span> ${erreur}</span>
	</c:if> <br /><br />
	
<form action="${pageContext.request.contextPath}/ServletSupprimerMonCompte" method="post">
	<input type="submit" value="Confirmation suppression" />
</form>

<form action="${pageContext.request.contextPath}/accueil" method="post">
	<input type="submit" value="Annuler" />
</form>

</body>
</html>