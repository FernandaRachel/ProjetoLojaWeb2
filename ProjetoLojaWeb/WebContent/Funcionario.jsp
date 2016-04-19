<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.usjt.TO.FuncionarioTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width">
<title>Funcionario</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="panel-heading">Funcionario</div>
	<table class="table table-striped">


		<jsp:useBean id="funcionario" class="com.usjt.TO.FuncionarioTO"
			scope="request" />

		<tr>
			<td>ID Funcionário:</td>
			<td>Usuario:</td>
			<td>Senha:</td>
			<td>RG:</td>

		</tr>

		<tr>
			<td>${funcionario.idFuncionario}</td>
			<td>${funcionario.usuario}</td>
			<td>${funcionario.senha}</td>
			<td>${funcionario.rg}</td>
		</tr>

	</table>
</body>
</html>