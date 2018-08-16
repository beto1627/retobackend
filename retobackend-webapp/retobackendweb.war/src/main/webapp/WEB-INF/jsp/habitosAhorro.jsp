<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<form id="frmHabitosAhorro">
	<div class="row">
		<div class="col-sm-12 col-xs-12">
			<div class="row form-group">
				 <input type="hidden" name="codigoPersona" id="codigoPersona" value="${codigoPersona}"/>
                 <label for="tipoBien" class="col-sm-4 col-xs-12 control-label">Cuenta Origen:</label>
                 <div class="col-sm-4 col-xs-12">
                    <select class="form-control required" name="codigoCuenta" id="codigoCuenta">
                    	<c:forEach var="item" begin="0" items="${lstCuentas}">
							<option value="${item.codigo}">${item.descripcion}</option>
						</c:forEach>
			  		</select>
                 </div>                                                       
            </div>
            <div class="row form-group">
                 <label for="cantBien" class="col-sm-4 col-xs-12 control-label">Saldo Mínimo:</label>
                 <div class="col-sm-4 col-xs-12">
                     <input class="form-control required" name="saldoMinimo" id="saldoMinimo" type="text" style="text-align:right" value="0.00"/>
                 </div>                                                     
            </div>
            <div class="row form-group">
                 <label for="cantBien" class="col-sm-4 col-xs-12 control-label">Email:</label>
                 <div class="col-sm-4 col-xs-12">
                     <input class="form-control required" name="email" id="email" type="text" style="text-align:left" value=""/>
                 </div>                                                     
            </div>
            <div class="col-sm-12 col-xs-12 modal-footer" style="text-align:center;">
				<button type="button" id="btnCancelar" class="btn btn-danger" onclick="" data-dismiss="modal">Cancelar</button>
				<button type="button" id="btnOK" class="btn btn-primary" onclick="">OK</button>
			</div>
		</div>
	</div>		
</form>
<script src="${pageContext.request.contextPath}/resources/a/js/habitosAhorro.js" type="text/javascript"></script>