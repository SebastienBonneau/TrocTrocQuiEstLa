<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>

	<h1>TrocTroc Qui est la ?</h1>

	<c:if test="${!empty sessionScope.utilisateur}"> <!-- si on trouve une session on affiche les href des pages disponible -->
		<a href="${pageContext.request.contextPath}/ServeltListeDesEncheres">Encheres</a>  <a href="${pageContext.request.contextPath}/ServletVendreUnArticle">Vendre un article</a>  <a href="${pageContext.request.contextPath}/ServletAfficherUnProfil">Mon profil</a>  <form action="${pageContext.request.contextPath}/ServletSeDeconnecter" method="post"> <input type="submit" value="Se déconnecter" /></form>
		<br />
		<br /> 
		Bonjour : ${utilisateur.nom} ${utilisateur.prenom}
	</c:if>
	
	<c:if test="${empty sessionScope.utilisateur}"> <!-- si aucune session trouve on propose a l'utilisateur les href d'inscription ou de connexion -->
		<a href="${pageContext.request.contextPath}/ServletSinscrire">S'inscrire</a> - <a href="${pageContext.request.contextPath}/ServletSeConnecter">Se connecter</a>
	</c:if>
	
	<h2>Liste des enchères</h2>
		
		<form method="post" action="${pageContext.request.contextPath}/accueil">
			<label for="Filtre">Filtres : </label>
			<br />
			<input type="search" name="article" id="article"/>
			<br />
				<br />
			<br />	
			Categorie :&nbsp;
			<select name="categorie"> <!-- liste deroulante des categorie dynamique via la session (récupere directement les categorie de la BDD) -->
			    <c:forEach items="${listeCategorie}" var="categorie">
			        <option value="${categorie.no_categorie}" 
			        	<cif test="${categorie.no_categorie eq selectedCatID}"selected="selected"></cif>
			        	>
			        	${categorie.libelle} <!-- affiche le libelle des categorie -->
			        </option>
			    </c:forEach>
			</select>
			<input type="submit" value="Rechercher"/>
		</form>
		
	<ul>
	<!--  Je crée un <li> pour chaque élément ${enchere} de ma liste ${listeArticle} -->
		<c:forEach var="enchere" items="${listeArticle}"> <!-- liste les enchere EC de la BDD avec des information récuperer par une session -->
			<li>
				<span>
				${enchere.nom_article} 
				Prix : ${enchere.prix_vente} 
				Fin de l'enchère : ${enchere.date_fin_enchere} 
				Vendeur : 
				</span>
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>