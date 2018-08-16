var URL_POST_REGISTRAR_TRANSFERENCIA= '/cuenta/realizarTransferencia';

var $btnCancelar = $('#btnCancelar');
var $btnOK = $('#btnOK');
var $frmTransferencia= $('#frmTransferencia');

var $codigoCuentaOrigen = $('#codigoCuentaOrigen');
var $numeroCuentaDestino = $('#numeroCuentaDestino');
var $codigoMoneda = $('#codigoMoneda');
var $monto = $('#monto');

$(document).ready(function(){
	inicializarEventos();
});
function inicializarEventos(){
	$btnOK.click(function(){
		registrarTransferencia();
	});
}
function registrarTransferencia(){
	if(!$frmTransferencia.validForm()){
		return false;
	}
	
	var fnSuccess =  function(data, b){
		alert('Operación Exitosa');
		listarCuentas();
		$modalAuxiliar.modal('hide');
	}
	var fnError =  function(data, b){
		if(data.responseJSON.message){
			showMessageDivModal($('.modal-footer'),'danger', data.responseJSON.message, null, false);
		}
	}
	
	var params = $frmTransferencia.serializeObjectNew();
	
	callPOST(URL_POST_REGISTRAR_TRANSFERENCIA, params, fnSuccess, fnError, null, null);
}
