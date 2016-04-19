<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.usjt.TO.ProdutoTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width">
<title>Produto</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<!-- Default panel contents -->
	<div class="panel-heading">Produto</div>

	<!-- Table -->

	<table class="table table-striped">
	<jsp:useBean id="produto" class="com.usjt.TO.ProdutoTO" scope="request"/>

		<tr>
			<td>ID:</td>
			<td>Quantidade:</td>
			<td>Valor:</td>
			<td>Nome:</td>
			<td>Marca:</td>
			<td>Fornecedor:</td>
		</tr>
		<tr>
	
			<td>${produto.id}</td>
			<td>${produto.qtd}</td>
			<td>${produto.valor}</td>
			<td>${produto.nome}</td>
			<td>${produto.marca}</td>
			<td>${produto.fornecedor}</td>
		</tr>
	</table>

	<!--  <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	
	<script src="js/bootstrap.min.js"></script> -->
</body>
</html>