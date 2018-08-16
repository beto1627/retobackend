<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/a/js/bootstrap/3.3.2/plugins/bootstrap-datepicker/bootstrap-datepicker.min.css" rel="stylesheet">
<%@include file="header.jsp"%>
<title>BBVA Continental</title>
</head>
<body>
	<section class="container-fluid">
		<br class="sep">
		<div class="row">
			<div class="panel panel-default">
				<form action="" id="formulario">
					<div class="panel-body">
						<h3>Bienvenido: <i style="color:blue">${persona.nombre}</i></h3>
						<hr>
						<h3>Resumen de Productos</h3>
						<br/>
					    <input type="hidden" name="codigoPersona" id="codigoPersona" value="${persona.codigoPersona}"/>
					    <div class="col-sm-12 col-xs-12"  align="left">
						   <div class="">
							   <div class="input-group">							   		
									<span class="input-group-btn">
										<button id="" class="btn btn-primary text" type="button"><i class="glyphicon glyphicon-align-justify" aria-hidden="true"></i></button>
										<!-- <button id="btnListarCuentas" class="btn btn-primary text" type="button"><i class="glyphicon glyphicon-unchecked" aria-hidden="true"></i>&nbsp;Mis Cuentas</button> -->
										<button id="btnRegistrarTransferencia" class="btn btn-primary text" type="button"><i class="glyphicon glyphicon-usd" aria-hidden="true"></i>&nbsp;Transferencias</button>
										<button id="btnHabitosAhorro" class="btn btn-primary text" type="button"><i class="glyphicon glyphicon-heart" aria-hidden="true"></i>&nbsp;H&aacute;bitos de Ahorro</button>
									</span>
								</div> 
						   </div>
						</div>
						<div class="">
							<div class="panel panel-default">
								<div class="panel-body">
							 		<div class="" >
										<div id="contentCuentas">
											<hr />
											<div class="content-msg"></div>
											<table id="tablaCuentas" class="table">
												<thead>
													<tr>
														<th scope="col">N° de Cuenta</th>
														<th scope="col">Tipo de Cuenta</th>
														<th scope="col">Producto</th>
														<th scope="col">Saldo</th>
														<th scope="col">Divisa</th>
													</tr>
												</thead>
											</table>
										</div>
									</div>
							 	</div> 
							</div>
						</div>
						<div class="col-sm-12 col-xs-12 modal-footer text-center">
						   <div class="col-sm-2 col-xs-12 col-sm-offset-5" align="center"> 
						   	<button id="btnContinuar" class="btn btn-link" type="button">Continuar&nbsp;<i class="glyphicon glyphicon-chevron-right" aria-hidden="true"></i></button>
						   </div>
						   <div class="col-sm-1 col-xs-12 col-sm-offset-4" align="center"> 
						   	<button id="btnCancelar" class="btn btn-link" type="button"><i class="glyphicon glyphicon-remove-sign" aria-hidden="true"></i>&nbsp;Cancelar</button>
						   </div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
	<div class="modal fade" id="modalAuxiliar" tabindex="-1" role="dialog" aria-labelledby="tituloModal">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Cerrar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="tituloModal"></h4>
				</div>
				<div class="modal-body">
				</div>
			</div>
		</div>
	</div>
</body>
<%@include file="footer.jsp"%>
<script src="${pageContext.request.contextPath}/resources/a/js/bootstrap/3.3.2/plugins/bootstrap-datepicker/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/a/js/bootstrap/3.3.2/plugins/bootstrap-datepicker/bootstrap-datepicker.es.js"></script>
<script src="${pageContext.request.contextPath}/resources/a/js/cuentas.js" type="text/javascript"></script>
</html>