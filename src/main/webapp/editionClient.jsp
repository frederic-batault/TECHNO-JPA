<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ProxiBanque</title>

<!-- cdn pour utilisation de bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
	integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
	integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
	crossorigin="anonymous"></script>

	<!-- css ajouter -->
	<link rel="stylesheet" href="css/style.css">

</head>
<body>

	<!-- container central -->
	<div class="container">
	
		<!-- menu -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item">
						<a class="nav-link" href="ServletListClient">Liste des clients</a>
					</li>
					<li class="nav-item active">
						<a class="nav-link" href="#">Edition d'un client<span class="sr-only">(current)</span></a>
					</li>
				</ul>
			</div>
		</nav>
		
		
		<form method="POST" action="ServletEditionClient" class="positionEdition">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputFirstName">Nom</label>
					<input type="text" class="form-control" id="inputFirstName" placeholder="Nom" name="leNom" value="<c:out value="${client.nom }"></c:out>"/>
				</div>
				<div class="form-group col-md-6">
					<label for="inputLastName">Prénom</label>
					<c:choose>
						<c:when test="${client.prenom == '' }">
							<input type="text" class="form-control" id="inputLastName" placeholder="Prénom" name="lePrenom"/>
						</c:when>
						<c:otherwise>
							<input type="text" class="form-control" id="inputLastName" placeholder="Prénom" name="lePrenom" value="<c:out value="${client.prenom }"></c:out>"/>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail4">E-mail</label>
				<c:choose>
					<c:when test="${client.email == '' }">
						<input type="email" class="form-control" id="inputEmail4" placeholder="E-mail" name="leMail"/>
					</c:when>
					<c:otherwise>
						<input type="email" class="form-control" id="inputEmail4" placeholder="E-mail" name="leMail" value="<c:out value="${client.email }"></c:out>"/>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="form-group">
				<label for="inputAddress2">Address</label>
				<c:choose>
					<c:when test="${client.adresse == '' }">
						<input type="text" class="form-control" id="inputAddress2" placeholder="Address" name="lAdresse"/>
					</c:when>
					<c:otherwise>
						<input type="text" class="form-control" id="inputAddress2" placeholder="Address" name="lAdresse" value="<c:out value="${client.adresse }"></c:out>"/>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="form-row">
				<div class="form-group col-md-3">
					<label for="inputFirstName">Code Postal</label>
					<c:choose>
						<c:when test="${client.codePostal == '' }">
							<input type="text" class="form-control" id="inputFirstName" placeholder="Code Postal" name="leCodePostal"/>
						</c:when>
						<c:otherwise>
							<input type="text" class="form-control" id="inputFirstName" placeholder="Code Postal" name="leCodePostal" value="<c:out value="${client.codePostal }"></c:out>"/>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="form-group col-md-9">
					<label for="inputLastName">Ville</label>
					<c:choose>
						<c:when test="${client.ville == '' }">
							<input type="text" class="form-control" id="inputLastName" placeholder="Ville" name="laVille"/>
						</c:when>
						<c:otherwise>
							<input type="text" class="form-control" id="inputLastName" placeholder="Ville" name="laVille" value="<c:out value="${client.ville }"></c:out>"/>
						</c:otherwise>
					</c:choose>
				</div>
			</div>

			<c:choose>
				<c:when test="${client.idClient > 0 }">
					<button type="submit" class="btn btn-primary">Mettre à jour</button>
				</c:when>
				<c:otherwise>
					<button type="submit" class="btn btn-primary">Créer</button>
				</c:otherwise>
			</c:choose>

		</form>
		
		
		
		
		
		

	</div>

</body>
</html>