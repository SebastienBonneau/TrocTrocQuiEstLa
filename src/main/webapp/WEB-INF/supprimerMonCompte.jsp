<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Suppression compte</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>

<form action="${pageContext.request.contextPath}/ServletSupprimerMonCompte" method="post">
	<input type="submit" value="Confirmation suppression" />
</form>

<form action="${pageContext.request.contextPath}/ServletAccueil" method="post">
	<input type="submit" value="Annuler" />
</form>

</body>
</html>