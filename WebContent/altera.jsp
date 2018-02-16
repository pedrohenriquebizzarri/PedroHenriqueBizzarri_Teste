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
				<div class="panel-heading">ALTERAR STATUS DO MOTORISTA</div>
				<div class="panel-body">
					<c:forEach items="${ListaMotoristaPesquisados}" var="mot_pes">
						<form action="ControleEdicao?opt=2&id=${mot_pes.id}" method="post">
							<div class="row">
								<div class="col-md-6">
									<label for="exampleInputEmail1">Dados</label>

									<p>ID: ${mot_pes.id}</p>
									<p>NOME: ${mot_pes.nome}</p>
									<p>CPF: ${mot_pes.cpf}</p>
									<p>DATA DE NASCIMENTO: ${mot_pes.nascimento}</p>
									<p>MODELO DO CARRO: ${mot_pes.modelo}</p>
									<c:choose>
										<c:when test="${mot_pes.status == true}">
											<p>STATUS: ATIVO</p>
										</c:when>
										<c:otherwise>
											<p>STATUS: INATIVO</p>
										</c:otherwise>
									</c:choose>

									<p>SEXO: ${mot_pes.sexo}</p>

								</div>
								<div class="col-md-6">
									<label for="exampleInputEmail1">Status</label>
									<div class="radio">
										<label> <input type="radio" name="radio_status"
											id="optionsRadios1" value="1">ATIVO
										</label>
									</div>
									<div class="radio">
										<label> <input type="radio" name="radio_status"
											id="optionsRadios2" value="0">INATIVO
										</label>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3 col-md-offset-11">
									<button type="submit" class="btn btn-default">ALTERAR</button>
								</div>
							</div>



						</form>
					</c:forEach>

				</div>
			</div>
		</div>
	</div>



	<!-- IMPORT BOT -->
	<%@ include file="import-bot.jsp"%>
</body>
</html>