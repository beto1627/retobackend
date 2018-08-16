var URL_POST_REGISTRAR_HABITO_AHORRO= '/cuenta/registrarHabitoAhorro';

var $btnCancelar = $('#btnCancelar');
var $btnOK = $('#btnOK');
var $frmHabitosAhorro= $('#frmHabitosAhorro');

var $codigoCuentaOrigen = $('#codigoCuentaOrigen');
var $saldoMinimo = $('#saldoMinimo');
var $email = $('#email');

$(document).ready(function(){
	inicializarEventos();
});
function inicializarEventos(){
	$btnOK.click(function(){
		registrarHabitoAhorro();
	});
}
function registrarHabitoAhorro(){
	//if(!$frmHabitosAhorro.validForm()){
	//	return false;
	//}
	
	var fnSuccess =  function(data, b){
		alert('Operación Exitosa');
		$modalAuxiliar.modal('hide');
	}
	var fnError =  function(data, b){
		if(data.responseJSON.message){
			showMessageDivModal($('.modal-footer'),'danger', data.responseJSON.message, null, false);
		}
	}
	
	var params = $frmHabitosAhorro.serializeObjectNew();
	
	callPOST(URL_POST_REGISTRAR_HABITO_AHORRO, params, fnSuccess, fnError, null, null);
}
