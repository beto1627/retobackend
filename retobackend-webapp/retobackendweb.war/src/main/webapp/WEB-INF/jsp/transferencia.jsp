<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<form id="frmTransferencia">
	<div class="row">
		<div class="col-sm-12 col-xs-12">
			<div class="row form-group">
                 <label for="tipoBien" class="col-sm-4 col-xs-12 control-label">Cuenta Origen:</label>
                 <div class="col-sm-4 col-xs-12">
                    <select class="form-control required" name="codigoCuentaOrigen" id="codigoCuentaOrigen">
                    	<c:forEach var="item" begin="0" items="${lstCuentas}">
							<option value="${item.codigo}">${item.descripcion}</option>
						</c:forEach>
			  		</select>
                 </div>                                                       
            </div>
            <div class="row form-group">
                 <label for="cantBien" class="col-sm-4 col-xs-12 control-label">Cuenta Destino:</label>
                 <div class="col-sm-4 col-xs-12">
                     <input class="form-control required" name="numeroCuentaDestino" id="numeroCuentaDestino" type="text" />
                 </div>                                                     
            </div>
            <div class="row form-group">
                 <label for="tipoBien" class="col-sm-4 col-xs-12 control-label">Divisa:</label>
                 <div class="col-sm-4 col-xs-12">
                    <select class="form-control required" name="codigoMoneda" id="codigoMoneda">
                    	<c:forEach var="item" begin="0" items="${lstMonedas}">
							<option value="${item.codigoDetalle}">${item.descripcion}</option>
						</c:forEach>
			  		</select>
                 </div>                                                       
            </div>
            <div class="row form-group">
                 <label for="cantBien" class="col-sm-4 col-xs-12 control-label">Monto:</label>
                 <div class="col-sm-4 col-xs-12">
                     <input class="form-control required" name="monto" id="monto" type="text" style="text-align:right" value="0.00"/>
                 </div>                                                     
            </div>
            <div class="col-sm-12 col-xs-12 modal-footer" style="text-align:center;">
				<button type="button" id="btnCancelar" class="btn btn-danger" onclick="" data-dismiss="modal">Cancelar</button>
				<button type="button" id="btnOK" class="btn btn-primary" onclick="">OK</button>
			</div>
		</div>
	</div>		
</form>
<script src="${pageContext.request.contextPath}/resources/a/js/transferencia.js" type="text/javascript"></script>