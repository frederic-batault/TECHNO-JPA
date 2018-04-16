<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
					<li class="nav-item active testMenu">
						<a class="nav-link" href="#">Virement<span class="sr-only">(current)</span></a>
					</li>
				</ul>
			</div>
		</nav>
		
		<!-- contenu de la page -->
		
		<div class="row positionTableCreditDebit">
			<div class="debitArea col">
				<h3>Compte à débiter </h3>
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Numéro compte</th>
				      <th scope="col">Date création</th>
				      <th scope="col">Type</th>
				      <th scope="col">Solde</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <td><input class="form-check-input positionRadio" type="radio" name="comptedebit" id="exampleRadios1" value="option1" checked></td>
				      <td>987654</td>
				      <td>02/02/2016</td>
				      <td>Courant</td>
				      <td>1200</td>      
				    </tr>
				    <tr>
				      <td><input class="form-check-input positionRadio" type="radio" name="comptedebit" id="exampleRadios2" value="option1" checked></td>
				      <td>987655</td>
				      <td>02/02/2016</td>
				      <td>Epargne</td>
				      <td>321321.00</td>
				    </tr>
				    <tr>
				      <td><input class="form-check-input positionRadio" type="radio" name="comptedebit" id="exampleRadios3" value="option1" checked></td>
				      <td>987656</td>
				      <td>02/02/2016</td>
				      <td>Epargne</td>
				      <td>32100.00</td>
				    </tr>
				  </tbody>
				</table>
			</div>
			
			<div class="creditArea col">
				<h3>Compte à créditer</h3>
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Numéro compte</th>
				      <th scope="col">Date création</th>
				      <th scope="col">Type</th>
				      <th scope="col">Solde</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <td><input class="form-check-input positionRadio" type="radio" name="compteCredit" id="exampleRadios4" value="option1" checked></td>
				      <td>987654</td>
				      <td>02/02/2016</td>
				      <td>Courant</td>
				      <td>1200</td>      
				    </tr>
				    <tr>
				      <td><input class="form-check-input positionRadio" type="radio" name="compteCredit" id="exampleRadios5" value="option1" checked></td>
				      <td>987655</td>
				      <td>02/02/2016</td>
				      <td>Epargne</td>
				      <td>321321.00</td>
				    </tr>
				    <tr>
				      <td><input class="form-check-input positionRadio" type="radio" name="compteCredit" id="exampleRadios6" value="option1" checked></td>
				      <td>987656</td>
				      <td>02/02/2016</td>
				      <td>Epargne</td>
				      <td>32100.00</td>
				    </tr>
				  </tbody>
				</table>
			</div>
		</div>
		
		<div>
			
			<form class="row">
				<h3 class="col-sm-2">Somme : </h3>
				<input type="text" class="col-sm-4 positionInputSomme">
				<a class="btn btn-primary col-sm-1" href="#">Virement</a>
			</form>
		</div>
		

	</div>

</body>
</html>