var URL_POST_LISTAR_CUENTAS = '/cuenta/listar';
var URL_POST_MOSTRAR_TRANSFERENCIA = '/cuenta/mostrarTransferencia';
var URL_POST_MOSTRAR_HABITOS_AHORRO = '/cuenta/mostrarHabitosAhorro';

var $btnListarCuentas = $('#btnListarCuentas');
var $btnRegistrarTransferencia = $('#btnRegistrarTransferencia');
var $btnHabitosAhorro = $('#btnHabitosAhorro');

var $codigoPersona = $('#codigoPersona');

var $modalAuxiliar = $('#modalAuxiliar');

var $tablaCuentas = $('#tablaCuentas');
var $dtTablaCuentas;

$(document).ready(function(){
	inicializarEventos();
	listarCuentas();
});
function inicializarEventos(){
	$btnListarCuentas.click(function(){
		listarCuentas();
	});
	$btnRegistrarTransferencia.click(function(){
		mostrarRegistrarTransferencia();
	});
	$btnHabitosAhorro.click(function(){
		mostrarHabitosAhorro();
	});
}

var columnsCuentas = [{
	"data":"numeroCuenta",
	"className": "text-left",
	"orderable": true,
    "defaultContent": ""
},{
	"data":"descTipoCuenta",
	"className": "text-left",
	"orderable": true,
    "defaultContent": ""
},{
	"data":"descProducto",
	"className": "text-left",
	"orderable": true,
    "defaultContent": ""
},{
	"data":"saldo",
	"className": "text-right",
	"orderable": true,
    "defaultContent": ""
},{
	"data":"descMoneda",
	"className": "text-left",
	"orderable": true,
    "defaultContent": ""
}];

function listarCuentas(){
	var fnSuccess =  function(data, b){
		clearDataTable($dtTablaCuentas);
		if(data.message){
			LENGUAJE_DATATABLE.sZeroRecords = data.message;
			LENGUAJE_DATATABLE.sEmptyTable = data.message;
		}
		$dtTablaCuentas = createDataTable($tablaCuentas, data.data, columnsCuentas);
	}
	var fnError =  function(data, b){
		if(data.responseJSON.message){
			showMessageDiv('.modal-footer','danger',data.responseJSON.message);
		}
	}
	var params = {
			"codigoPersona" : $codigoPersona.val()
	}
	callPOST(URL_POST_LISTAR_CUENTAS, params, fnSuccess, fnError, null,'#contentCuentas .content-msg');
}
function mostrarRegistrarTransferencia(){
    var fnSuccess = function(v,c,j){
    	document.getElementById("tituloModal").innerHTML = "Realizar Transferencia";
    }
    var params = {
		   "codigoPersona" : $codigoPersona.val()
    };
    loadModal($modalAuxiliar, URL_CONTEXT_PATH + URL_POST_MOSTRAR_TRANSFERENCIA, params, fnSuccess);
}
function mostrarHabitosAhorro(){
    var fnSuccess = function(v,c,j){
    	document.getElementById("tituloModal").innerHTML = "Hábitos Ahorro";
    }
    var params = {
		   "codigoPersona" : $codigoPersona.val()
    };
    loadModal($modalAuxiliar, URL_CONTEXT_PATH + URL_POST_MOSTRAR_HABITOS_AHORRO, params, fnSuccess);
}