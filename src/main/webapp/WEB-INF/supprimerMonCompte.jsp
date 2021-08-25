<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="${pageContext.request.contextPath}/ServletSupprimerMonCompte" method="post"> <input type="submit" value="Confirmation suppression" /></form>
<form action="${pageContext.request.contextPath}/ServletAccueil" method="post"> <input type="submit" value="Annuler" /></form>


</body>
</html>