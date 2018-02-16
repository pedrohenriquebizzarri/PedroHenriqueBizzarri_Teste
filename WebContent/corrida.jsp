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
<title>CORRIDAS</title>
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
							<td>NOME DO MOTORISTA</td>
							<td>CPF DO MOTORISTA</td>
							<td>SEXO MOTORISTA</td>
							<td>NOME DO PASSAGEIRO</td>
							<td>CPF DO PASSAGEIRO</td>
							<td>SEXO PASSAGEIRO</td>
							<td>VALOR DA CORRIDA</td>
						</tr>
						<c:forEach items="${ListaCorridas}" var="cor">
							<tr>
								<td>${cor.id}</td>
								<td>${cor.motorista.nome}</td>
								<td>${cor.motorista.cpf}</td>
								<td>${cor.motorista.sexo}</td>
								<td>${cor.passageiro.nome}</td>
								<td>${cor.passageiro.cpf}</td>
								<td>${cor.passageiro.sexo}</td>
								<td>R$ ${cor.valor}0</td>
							</tr>
						</c:forEach>
					</table>
					<div class="row">
						<div class="col-md-3 col-md-offset-11">
							<a href="ControleLista?opt=3"> ATUALIZAR </a>
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
				<div class="panel-heading">CADASTRAR CORRIDAS</div>
				<div class="panel-body">
					<form action="ControleCadastro?opt=3" method="post">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="exampleInputEmail1">Escolha um Passageiro</label> <select
										class="form-control" name="passageiro">
										<c:forEach items="${ListaPassageiros}" var="pas">
											<option value="${pas.id}">${pas.nome}-${pas.cpf}-
												${pas.sexo}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Escolha um Motorista</label>
									<select class="form-control" name="motorista">
										<c:forEach items="${ListaMotoristas}" var="mot">
											<option value="${mot.id}">${mot.nome}-${mot.cpf}-
												${mot.sexo}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="exampleInputEmail1">Valor da Corrida</label> <input
										type="text" class="form-control" id="exampleInputEmail1"
										placeholder="00.00" name="valor">
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