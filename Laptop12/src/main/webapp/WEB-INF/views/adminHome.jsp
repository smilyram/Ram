<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
<link rel="stylesheet" 	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>

<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">

		<ul class="nav navbar-nav">
			<li class="active"><a href="home.html">Home</a></li>
			
			<ul class="nav navbar-nav navbar-right">
			<li><a href="ViewCustomer">View Users</a></li>
			<li><a href="addItem">AddItems</a></li>
			<li><a href="ViewItem">All Products</a></li>
			<li><a href="logout">Logout</a></li>
			</ul>
		</ul>
		
	</div>
	</nav>
<img src="resources/images/admin.jpg" style="width:100%;height:75%">
	<%@include file="footer.jsp" %>
	
	
	