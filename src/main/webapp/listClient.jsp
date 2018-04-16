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
					<li class="nav-item active testMenu">
						<a class="nav-link" href="#">Liste des clients<span class="sr-only">(current)</span></a>
					</li>
				</ul>
			</div>
		</nav>
		
		<!-- contenu de la page -->
		
		<div class="creationArea">
			<label><h5>Création d'un nouveau client : </h5></label>
			<a class="btn btn-primary" href="ServletEditionClient?id=0">Créer</a>
		</div>
		
		
		
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Nom</th>
		      <th scope="col">Prenom</th>
		      <th scope="col">Modifier client</th>
		      <th scope="col">Gestion comptes</th>
		      <th scope="col">Effectuer virement</th>
		      <th scope="col">Supprimer client</th>
		    </tr>
		  </thead>
		  <tbody>
		  	
				<c:forEach items="${listClient}" var="client">
				    <tr>
				      <th scope="row">1</th>
				      <td><c:out value="${client.nom}"></c:out></td>
				      <td><c:out value="${client.prenom}"></c:out></td>
				      <td><a class="btn btn-primary" href="ServletEditionClient?id=<c:out value="${client.idClient}"></c:out>">Modifier client</a></td>
				      <td><a class="btn btn-primary" href="ServletListCompte?id=<c:out value="${client.idClient}"></c:out>">Gestion comptes</a></td>
				      <td><a class="btn btn-primary" href="ServletVirement">Effectuer virement</a></td>
				      <td><a class="btn btn-danger" href="ServletListClient?idDelete=<c:out value="${client.idClient}"></c:out>">Supprimer client</a></td>		      
				    </tr>
				</c:forEach>

		  </tbody>
		</table>
		
		
		

	</div>

</body>
</html>