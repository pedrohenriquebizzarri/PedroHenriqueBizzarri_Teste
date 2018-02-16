<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>ERRO</title>
<!-- IMPORT TOP -->
<%@include file="import-top.jsp"%>
</head>
<body>
	<br>
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="panel panel-default">
				<div class="panel-heading">ERRO</div>
				<div class="panel-body">
					<h5>${Erro}</h5>
					<p>${Detalhe}</p>
					<br> <a href="index.jsp">VOLTAR AO INICIO</a>
				</div>
			</div>
		</div>
	</div>


	<!-- IMPORT BOT -->
	<%@ include file="import-bot.jsp"%>
</body>
</html>