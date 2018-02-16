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
<title>MOTORISTAS</title>
<!-- IMPORT TOP -->
<%@include file="import-top.jsp"%>
</head>
<body>
	<!-- IMPORT NAVBAR -->
	<%@include file="import-navbar.jsp"%>

	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">TABELA</div>
				<div class="panel-body">
					<table class="table table-bordered">
						<tr class="success">
							<td>ID</td>
							<td>NOME</td>
							<td>CPF</td>
							<td>DATA DE NASCIMENTO</td>
							<td>MODELO DO CARRO</td>
							<td>STATUS</td>
							<td>SEXO</td>
							<td>AÇÃO</td>
						</tr>
						<c:forEach items="${ListaMotoristas}" var="mot">
							<tr>
								<td>${mot.id}</td>
								<td>${mot.nome}</td>
								<td>${mot.cpf}</td>
								<td>${mot.nascimento}</td>
								<td>${mot.modelo}</td>
								<c:choose>
									<c:when test="${mot.status == true}">
										<td>ATIVO</td>
									</c:when>
									<c:otherwise>
										<td>INATIVO</td>
									</c:otherwise>
								</c:choose>

								<td>${mot.sexo}</td>
								<td><a class="btn btn-default"
									href="ControleEdicao?opt=1&id=${mot.id}" role="button"> <span
										class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								</a></td>
							</tr>
						</c:forEach>
					</table>
					<div class="row">
						<div class="col-md-3 col-md-offset-11">
							<a href="ControleLista?opt=2"> ATUALIZAR </a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">CADASTRAR MOTORISTA</div>
				<div class="panel-body">
					<form action="ControleCadastro?opt=2" method="post">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="exampleInputEmail1">Nome</label> <input type="text"
										class="form-control" id="exampleInputEmail1"
										placeholder="Exemplo nome completo" name="nome">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">CPF</label> <input
										type="text" class="form-control" id="exampleInputPassword1"
										placeholder="000.000.000-00" name="cpf">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Modelo do Carro</label> <input
										type="text" class="form-control" id="exampleInputPassword1"
										placeholder="Modelo exemplo" name="modelo">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="exampleInputEmail1">Data de Nascimento</label> <input
										type="text" class="form-control" id="exampleInputEmail1"
										placeholder="DD/MM/YYYY" name="nascimento">
								</div>
								<label for="exampleInputEmail1">Sexo</label>
								<div class="radio">
									<label> <input type="radio" name="radio_sexo"
										id="optionsRadios1" value="Masculino" checked>Masculino
									</label>
								</div>
								<div class="radio">
									<label> <input type="radio" name="radio_sexo"
										id="optionsRadios2" value="Feminino">Feminino
									</label>
								</div>

							</div>
						</div>


						<button type="submit" class="btn btn-default">CADASTRAR</button>
					</form>
				</div>
			</div>
		</div>
	</div>



	<!-- IMPORT BOT -->
	<%@ include file="import-bot.jsp"%>
</body>
</html>