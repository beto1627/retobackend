$(document).ready(function(){
	$('.eventNone').click(function(event){
		event.preventDefault();	
	});
	$.ajaxSetup({ cache:false,"contentType":"application/json" });
	$('[data-toggle="tooltip"]').tooltip();
});
setInterval(function () {
    if (document.documentMode <= 8) {
        $('.ieOnly').css("display", "block");
        $('.iColor i').css("display", "none");
        $("input[type='checkbox'], input[type='radio']").css({
            width:"18px",
            height:"18px"
        });
    } else {
        $('.iColor i').css("display", "block");
    }
    $('.modal:visible').length && $(document.body).addClass('modal-open');
    //se calcula la altura con sus margenes y se añade en el backdrop
    var heightWindow = $(window).outerHeight(true);
    var heightModal = $('.modal-dialog:visible').outerHeight(true);
    if(heightWindow>heightModal)
    	$('.modal-backdrop:visible').height(heightWindow)
    else
    	$('.modal-backdrop:visible').height(heightModal)
}, 100);
var URL_COMBOS = '/comun/cargarCombos';
 var LENGUAJE_DATATABLE = {
                "sProcessing": "Procesando...",
                "sLengthMenu": "Mostrar _MENU_ registros",
                "sZeroRecords": "No existe registros para los criterios de búsqueda ingresados.",
                "sEmptyTable": "No existe registros para los criterios de búsqueda ingresados.",
                "sInfo": "Se muestran del _START_ al _END_ de un total de _TOTAL_ resultados ",
                "sInfoEmpty": "Se muestran del 0 al 0 de un total de 0 resultados",
                "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
                "sInfoPostFix": "",
                "sSearch": "Buscar Perzonalizado:",
                "sUrl": "",
                "sInfoThousands": ",",
                "sLoadingRecords": "Cargando...",
                "oPaginate": {
                    "sFirst": "Primero",
                    "sLast": "Último",
                    "sNext": "Siguiente >>",
                    "sPrevious": "<< Anterior"
                },
                "oAria": {
                    "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                    "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                }
            };

function evalNull(object){
	var result = false;
	if(object != null && typeof object !="undefined"){
		if(object instanceof Array){
			if(object.length > 0)
				result = true;
		}else{
			result = true;			
		}
	}
	return result;
}
function getRowSelect(table){
	var data = table.rows('.selected').data();
	var array = [];
	if(data.length>0){
		for (var i = 0; i < data.length; i++) {
			array.push(data[i]);
		}
		return array;
	}else{
		alert("No ha seleccionado ning&uacute;n Registro.");
	}	
}
function isNoEmpty(object){
	var result = false;
	if(object!= null && object!="" && typeof object !="undefined"){
		if(object instanceof Array){
			if(object.length > 0)
				result = true;
		}else{
			result = true;			
		}
	}
	return result;
}
function createDataTable($ideTable,data,columns,columnDefs,options){
	var config = {
			bLengthChange : false,
			paging : true,
			//searching : false,
			"destroy": true,
			info : true,
			'bDestroy' : true,
			responsive : true,
			bAutoWidth : false,
			"language" : LENGUAJE_DATATABLE
	};
	if(!evalNull(options))config.searching= false;
	$.fn.extend(config,options);
	if(evalNull(data)){
		if($.isArray(data))
			config.data = data;
	}else{
		config.data = [];
	}
	if(evalNull(columns))
		config.columns = columns;
	if(evalNull(columnDefs))
		config.columnDefs =  columnDefs;
	var dataTable = $ideTable.DataTable(config);
	$(".dataTables_wrapper th").append("<div class='caret_up'></div><div class='caret_down'></div>");
	return dataTable;
}
function clearDataTable(dataTable){ 
	if(dataTable){
		dataTable.clear().draw();
		dataTable.destroy();
		dataTable=null;
	}
};
function callPOST(queryUrl, params, fnSuccess, fnError, fnComplete,idDomMessage) {
	waitingDialog.show();
	$.ajaxSetup({"contentType":"application/json" }); 
	var _fnSuccess = function(v, c, object) {
		if (c == 'success' && object.readyState == 4 && object.status == 200) {
			if (jQuery.isFunction(fnSuccess))
				fnSuccess(v, c);
		}
	}
	var _fnError = function(object, c, errorThrown) {
    	var message = object.responseJSON.message;
    	if (object.responseJSON.errors != null) {
    		if( object.responseJSON.errors instanceof Array ){
	    		message += '<ul>';
	        	var items = [];
		        	$.each(object.responseJSON.errors, function (id, error) {
		                items.push('<li>' + error.msg + '</li>');
		            });
	        	message += items.join('');
	        	message += '</ul>';
    		}
    	}
		if(typeof idDomMessage != 'undefined'){	
			showMessageDiv(idDomMessage,'danger',message)
		}
	}
	if(params instanceof Array){
		limpiarValoresNullArray(params);
	}else{
		limpiarValoresNull(params);
	}
	var jqxhr = $.post(URL_CONTEXT_PATH + queryUrl, JSON.stringify(params), _fnSuccess);
	jqxhr.always(function(){waitingDialog.hide();});
	if (jQuery.isFunction(fnError))
		jqxhr.fail(fnError);
	else
		jqxhr.fail(_fnError);
	if (jQuery.isFunction(fnComplete))
		jqxhr.always(fnComplete);
	return jqxhr
}
function callGET(queryUrl, params, fnSuccess, fnError, fnComplete,idDomMessage) {
	waitingDialog.show();
	var _fnSuccess = function(v, c, object) {
		if (c == 'success' && object.readyState == 4 && object.status == 200) {
			if (jQuery.isFunction(fnSuccess))
				fnSuccess(v, c);
		}
	}
	var _fnError = function(object, c, errorThrown) {
    	var message = object.responseJSON.message;
    	if (object.responseJSON.errors != null) {
    		if( object.responseJSON.errors instanceof Array ){
	    		message += '<ul>';
	        	var items = [];
		        	$.each(object.responseJSON.errors, function (id, error) {
		                items.push('<li>' + error.msg + '</li>');
		            });
	        	message += items.join('');
	        	message += '</ul>';
    		}
    	}
		if(typeof idDomMessage != 'undefined'){	
			showMessageDiv(idDomMessage,'danger',message)
		}
	}
	var jqxhr = $.get(URL_CONTEXT_PATH + queryUrl, params, _fnSuccess);
	jqxhr.always(function(){waitingDialog.hide();});
	if (jQuery.isFunction(fnError))
		jqxhr.fail(fnError);
	else
		jqxhr.fail(_fnError);
	if (jQuery.isFunction(fnComplete))
		jqxhr.always(fnComplete);
	return jqxhr
}
function loadModal($modalLoad, url, data, fnSuccess,fnError,fnHiddenModal) {
	waitingDialog.show();
	$modalLoad.find('.modal-body').empty();
	if (!evalNull(data))
		data = {};
	if (evalNull(url)) {
		$.ajaxSetup({"contentType":'application/x-www-form-urlencoded; charset=UTF-8' });		
		$modalLoad.find('.modal-body').load(url,limpiarValoresNull(data), function(result,status) {
			if(status == 'success'){
				if (jQuery.isFunction(fnSuccess))
					fnSuccess(result);
				$modalLoad.modal({
					show : true,
					backdrop: "static"
				});	
				$modalLoad.on('hidden.bs.modal', function (e) {
					if(jQuery.isFunction(fnHiddenModal))
						fnHiddenModal($modalLoad);
				})
			}else if(status == 'error'){
				if (jQuery.isFunction(fnError))
					fnError(result);				
			}
			waitingDialog.hide();
		});
	}
}
function showMessageDiv(idDomParent,type,message,titulo){
	try {
		var divDom = $(idDomParent);
		if(divDom.find('.alert').get().length > 0){
			divDom.find('.alert').get().forEach(function(item, index){
				$(item).remove();
			});
		}		
		var divMessage = $('<div class="alert alert-dismissible" role="alert"/>').html(message);
		divMessage.prepend('<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>');
		if(type =='success'){
			divMessage.addClass('alert-success');
		}else if(type == 'info'){
			divMessage.addClass('alert-info');
		}else if(type == 'warning'){
			divMessage.addClass('alert-warning');
		}else if(type == 'danger'){
			divMessage.addClass('alert-danger');
		}else if(type == 'light'){
			divMessage = '';
		}
		//verificar si esta en un modal
		var divModal = $(idDomParent).parents('.modal').get(0);
		if(divModal != null){
			divMessage.addClass('alert-fixed');
		}
		divDom.find('.alert').get().forEach(function(item, index){
			$(item).remove();
		});
		divDom.prepend(divMessage);
	}
	catch(err) {
		alert(err);
		alert(message);
	}
}
function showMessageDivModal(idDomParent,type,message,titulo,isModal){
	try {
		var divDom = $(idDomParent);
		if(divDom.find('.alert').get().length > 0){
			divDom.find('.alert').get().forEach(function(item, index){
				$(item).remove();
			});
		}		
		var divMessage = $('<div class="alert alert-dismissible" role="alert"/>').html(message);
		divMessage.prepend('<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>');
		if(type =='success'){
			divMessage.addClass('alert-success');
		}else if(type == 'info'){
			divMessage.addClass('alert-info');
		}else if(type == 'warning'){
			divMessage.addClass('alert-warning');
		}else if(type == 'danger'){
			divMessage.addClass('alert-danger');
		}
		//verificar si esta en un modal
		if(evalNull(isModal)){
			if(isModal)
				divMessage.addClass('alert-fixed');
		}else{
			var divModal = $(idDomParent).parents('.modal').get(0);
			if(divModal != null){
				divMessage.addClass('alert-fixed');
			}
		}
		divDom.find('.alert').get().forEach(function(item, index){
			$(item).remove();
		});
		divDom.prepend(divMessage);
	}
	catch(err) {
		alert(err);
		alert(message);
	}
}
function formatIndicador(data){
	var html = data;
	if(data =='1')
		html = '<strong class="text-success">SI</strong>';
	else
		html = '<strong class="text-danger">NO</strong>';
	return html;
}
function formatNull(data){
	if(evalNull(data)){
		return data;
	}else{
		return "";
	}	
}
function showMessageInput(dom,type,message){
	var divModal;
	if(typeof dom =='string')
		divModal = $(dom).parents('.form-group').get(0);
	else 
		divModal = dom.parents('.form-group').get(0);;
	var $divModal =$(divModal)
	$divModal.addClass('has-feedback');
	$divModal.removeClass('has-error');
	$divModal.removeClass('alert-info');
	$divModal.removeClass('has-success');
	$divModal.removeClass('has-danger');
	if(type=="success"){
		$divModal.addClass('has-success');
	}else if(type == 'info'){
		//$divModal.addClass('has-error has-danger');
	}else if(type == 'warning'){
		$divModal.addClass('has-error has-danger');
	}else if(type == 'danger'){
		$divModal.addClass('has-error has-danger');
	} 
	var $divInputGroup = $divModal.children('.input-group');
	var $divContenInput  = $divInputGroup.children('.content-input-group');
	var divIcon = $('<span class="glyphicon form-control-feedback" aria-hidden="true"/>');
	if(type=="success"){
		divIcon.addClass('glyphicon-ok');
	}else if(type == 'info'){
		divIcon.addClass('glyphicon-info-sign');
	}else if(type == 'warning'){
		divIcon.addClass('glyphicon-remove');
	}else if(type == 'danger'){
		divIcon.addClass('glyphicon-remove');
	}
	if(isNoEmpty($divContenInput)){
		$divContenInput.children('.form-control-feedback').remove();
		$divContenInput.append(divIcon)
	}else{
		$divModal.children('.form-control-feedback').remove();
		$divModal.append(divIcon)
	}
	$divModal.children('.help-block').remove();
	if(evalNull(message)&&isNoEmpty(message)){
		var divMessage = $('<div class="help-block with-errors"/>').html(message);
		$divModal.append(divMessage);		
	}
}

function llenarCombo(dom,arrayData, config){
	var combo = dom,
		displayCombo = 'descripcion',
		valueCombo = 'codigo';

	combo.empty();

	if(config && config.display) 
		displayCombo = config.display;

	if(config && config.value) 
		valueCombo = config.value;
	
	if(config && config.placeholder){ 
		combo.append('<option value="" selected disabled>' + config.placeholder + '</option>');
	}

	for(var i=0; i<arrayData.length; i++){
		var opcion = '<option value='+ arrayData[i][valueCombo] +'>'+ arrayData[i][displayCombo] +'</option>';
		combo.append(opcion);
	}
}
function limpiarValoresNull(o){
	for(var i in o) { 
		if (o.hasOwnProperty(i)) {
			if(!isNoEmpty(o[i])){
				delete o[i];
			}
			if(Array.isArray(o[i])){
				o[i] = limpiarValoresNullArray(o[i]);
			}
		}
	}
	return o;
}
function limpiarValoresNullArray(array){
	var nuevoArray = [];
	array.forEach(function(obj){
		nuevoArray.push(limpiarValoresNull(obj));
	})
	return nuevoArray;
}
//Ubicar visualmente un elemento html en la pantalla
function posicionVisual(idTarget) {
    var container = $(idTarget).parent();
    var alturaContainer = container.offset().top;
    //console.log(container);
    $('body').animate({
        //scrollTop: $(idTarget).offset().top - container.offset().top + container.scrollTop()
        scrollTop: $(idTarget).offset().top - alturaContainer + alturaContainer / 4
    }, 1000);

};
function enviarForm(params,url){
	var form_ = $('#formDescarga'); 
	if(evalNull(form_.get(0))) 
		form_.remove();
	form_ = $('<form id="formDescarga" action="' + URL_CONTEXT_PATH + url + '" method="post" />');
	for (var key in params) {
	    if (params.hasOwnProperty(key)) {
	       form_.append($('<input type="hidden" name="' + key + '" value="'+params[key]+'"/>'));
	    }
	  }
	$('body').append(form_);
	form_.submit();
}

function descargar(params,url){
	waitingDialog.show();
	enviarForm(params,url);
	setTimeout(function(){ 
		waitingDialog.hide();
	}, 1500);
}
function descargarArchivo(idArchivo){
	descargar({"idArchivo":idArchivo},"/comunoficio/descargarArchivo");
}
//showMensajeConfirmacion('asdasd',function(){alert('SI');},'titulo')
function showMensajeConfirmacion(mensaje,fn,titulo,fnHiddenModal){
	var idRamdon = Math.round(Math.random()*10009874621);
	var $m = $('<div class="modal fade" id="m'+idRamdon+'" tabindex="-1" role="dialog" aria-labelledby="'+titulo+'" aria-hidden="true"/>');
	var $mDialog = $('<div class="modal-dialog">');
	var $mContent = $('<div class="modal-content">');
	if(evalNull(titulo)){
		$mContent.append('<div class="modal-header"><h3 class="modal-title">' + titulo + '</h3></div>');
	}
	var mBody = $('<div class="modal-body">');
	mBody.append('<div class="row">'+
		'<div class="col-md-6 col-xs-6 text-center ">'+
			'<button data-dismiss="modal" type="button" class="btn btn-link no-modal">NO</button>'+
		'</div>'+
		'<div class="col-md-6 col-xs-6 text-center ">'+
			'<button id="btnConfirmarAgregarAuditor" type="button" class="btn si-modal btn-primary">SI</button>'+
		'</div>'+
	'</div>');
	mBody.prepend('<p class="text-justify">' + mensaje + '</p>');
	var btnSI = $(mBody.find('.si-modal').get(0));
	btnSI.click(function(){
		fn();
		btnNO.click()
	});
	var btnNO = $(mBody.find('.no-modal').get(0));
	btnNO.click(function(){
		$m.modal('hide');
	});
	$m.on('hidden.bs.modal', function (e) {
		$m.remove();
		if($.isFunction(fnHiddenModal))
			fnHiddenModal($m);
	})
	$m.append($mDialog);
	$mDialog.append($mContent);
	$mContent.append(mBody);
	$m.modal({
		show : true,
		backdrop: "static"
	});			
}

function fnKeyDownAlphaNumeric(e){
	console.info(event);
	 // Allow: backspace, tab,  escape, enter, punto
   if ($.inArray(e.keyCode, [ 8, 9, 27, 13, 190]) !== -1 ||
        // Allow: Ctrl+A, Command+A SELECCIONAR
       (e.keyCode === 65 && (e.ctrlKey === true || e.metaKey === true)) || 
       //Control + v
       (e.keyCode == 86 && (e.ctrlKey || e.metaKey === true))||
        // Allow: home, end, left, right, down, up
       (e.keyCode >= 35 && e.keyCode <= 40)) {
            // let it happen, don't do anything
            return ;
   }
   // Ensure that it is a number and stop the keypress, y tilde
   if ((e.shiftKey || (e.keyCode < 65 || e.keyCode > 90)) && 
		   ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) || e.keyCode == 186) {
       e.preventDefault();
   }
}
function fnKeyDownNumeric(e){
	console.info(event);
	 // Allow: backspace, tab,  escape, enter, punto
    if ($.inArray(e.keyCode, [ 8, 9, 27, 13, 190, 110]) !== -1 ||
         // Allow: Ctrl+A, Command+A SELECCIONAR
        (e.keyCode === 65 && (e.ctrlKey === true || e.metaKey === true)) ||
        //Control + v
        (e.keyCode == 86 && (e.ctrlKey || e.metaKey === true))||
         // Allow: home, end, left, right, down, up
        (e.keyCode >= 35 && e.keyCode <= 40)) {
             // let it happen, don't do anything
             return ;
    }
    // Ensure that it is a number and stop the keypress, y tilde
    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105) || e.keyCode == 186) {
        e.preventDefault();
    }
}

function subirArchivoAdjunto(inputFile, params, fnSuccess, fnError) {
	var $file = $(inputFile);
	var parent = $file.parents('.input-group');
	var rutaArchivo = $(inputFile).val();
	if(!$.isEmptyObject(rutaArchivo)){
		var files = $file[0].files;
		var extension = rutaArchivo.substr(rutaArchivo.lastIndexOf('.') + 1)
				.toLowerCase();
		if (files[0].size > 0
				&& files[0].size <= MAXIMO_PESO_ARCHIVOS
				&& (extension == 'pdf' || extension == 'jpg' || extension == 'jpge' || extension == 'png')
				&& rutaArchivo !== '') {
			var reader = new FileReader();
			var file = files[0];
			reader.readAsDataURL(file);
			reader.onload = function() {
				var readerResult = reader.result;
				var bytes = readerResult.split("base64,")[1];
				var archivo = {
					"nomArc" : file.name,
					"desMimeType" : file.type,
					"cntPesoArc" : file.size,
					"blob" : bytes
				};
				if (reader.readyState == 2) {
					$.extend(archivo, params);
					fnSuccess(archivo);
				} else {
					fnError();
				}
			};
		}
	}else{
		var archivo = {
				"nomArc" : '',
				"cntPesoArc" : 0,
				"desMimeType" : '', 
				"blob" : ''
		};
		$.extend(archivo, params);
		fnSuccess(archivo);
	}
}
function prepararArchivo(inputFile) {
	if(inputFile.files[0].size > MAXIMO_PESO_ARCHIVOS){
		showMessageInput($(inputFile),'danger',EXCEPCION_PESO_MAX_ARCHIVO);
		limpiarAdjunto($(inputFile));
	}else{
		showMessageInput($(inputFile),'success','');
		var $file = $(inputFile);
		var parent = $(inputFile).parents('.input-group');
		var rutaArchivo = $(inputFile).val();
		var startIndex = (rutaArchivo.indexOf('\\') >= 0 ? rutaArchivo
				.lastIndexOf('\\') : rutaArchivo.lastIndexOf('/'));
		var nombreArchivo = rutaArchivo.substring(startIndex);
		if (nombreArchivo.indexOf('\\') === 0 || nombreArchivo.indexOf('/') === 0) {
			nombreArchivo = nombreArchivo.substring(1);
		}
		var hdnFileDescripcion = parent.find('.fileDescripcion');
		hdnFileDescripcion.val(nombreArchivo);
		parent.find('.group-trash button').show();
		parent.find('button.btnAdjuntar span').text("Cambiar");
	}
}
function limpiarAdjunto(button) {
	var parent = $(button).parents('.input-group');
	parent.children('.input-file-imagen').val('');
	parent.children('.fileDescripcion').val('');
	parent.find('button.btnAdjuntar span').text('Adjuntar');
	parent.find('.group-trash button').hide();
	desactivarDescarga(parent.find('.group-download button'));
}
function desactivarDescarga(input){
	var btnDescargar2 = $(input).parents('.input-group').find('.group-download button');
	btnDescargar2.off('click').hide();
}
function descargarArchivo(parametros, url){
	var urlWindow = URL_CONTEXT_PATH + url;
	if(!$.isEmptyObject(parametros)){
		urlWindow += "?" + $.param(parametros);
	}
	windowDescarga = window.open(urlWindow, "windowDescarga", "width=768,height=600");
}
function posicionMensaje(){
    $('.modal').bind('click', function () {
        var alturaPan = screen.height;
        var puntoReferencia = alturaPan - 120;
        var modalActual = $(this);
        modalActual.scroll(function (event) {
            var position = modalActual.scrollTop();
            $('.bloque-mensaje').css({
                top: position + puntoReferencia,
                bottom: 'auto'
            });
        });
    });
};
function showMensajeConfirmSiNo($contenedor,fnSI,fnNo,messaje){
	if(typeof messaje == 'undefined')
		msj = '¿Est&aacute;s seguro que desea continuar?';
	else 
		msj = messaje;
	var contentMsj = $('<section class="contenedor-mensaje"><div style="" class="bloqueo-modal"/></section>');
	var bloqueMsj = $('<div style="" class="bloque-mensaje row lg"><div class="col-md-12 col-xs-12"><p class="mensaje">'+msj+'</p></div></div>');
	contentMsj.append(bloqueMsj);
	var $contentNO = $('<div class="col-md-3 col-xs-6 col-md-push-3">');
	var $btnNO = $('<button type="button" class="opcion-no btn btn-primary">NO</button>');
	var $contentSI = $('<div class="col-md-3 col-xs-6 col-md-push-3">');
	var $btnSI = $('<button type="button"class="opcion-si btn btn-primary">S&Iacute;</button>');
	$contentSI.append($btnSI);
	$contentNO.append($btnNO);
	bloqueMsj.append($contentNO);
	bloqueMsj.append($contentSI);
	contentMsj.find('.bloque-mensaje').addClass('bg-info');
	contentMsj.find('.bloque-mensaje').removeClass('bg-danger');
	$btnSI.off('click').click(function(){
		if($.isFunction(fnSI))
			fnSI();
		$btnSI.off('click');
		contentMsj.fadeOut(200,function(){
			contentMsj.remove();
		});
	})
	$btnNO.off('click').click(function(){
		if($.isFunction(fnNo))
			fnNo();
		$btnNO.off('click');
		contentMsj.fadeOut(200,function(){
			contentMsj.remove();
		});
	})
	$contenedor.append(contentMsj);
	contentMsj.fadeIn(200);
	if (screen.width <= 640) {
	    posicionMensaje();
	}
}
function dehabilitarAdjunto(inputFile,flag){
	var parent = $(inputFile).parents('.input-group');
	parent.find('button.btnAdjuntar span').text('Adjuntar');
	parent.find('button.btnAdjuntar').prop("disabled", flag);
	parent.children('.fileDescripcion').prop("disabled", flag);
	limpiarAdjunto(inputFile);
	desactivarDescarga(inputFile)
}
function quitarMensajeValidacion($form){
	$form.find('input[type=text], select, input[type=file]').each(function(e,input){
		var $input = $(input);
		showMessageInput($input,'info','')
	})
}
function ajaxCall(action, parametros, tipo, successCallBack, errorCallBack) {
	//waitingDialog.show();
	if (tipo == 'POST') {
		data = JSON.stringify(parametros);
	} else {
		data = parametros;
	}
	var _successCallBack;
	if($.isFunction(successCallBack)){
		_successCallBack = function(a,c,v,b,d){
			successCallBack(a,c,v,b,d);
			//waitingDialog.hide();
		}
	}else{
		_successCallBack = function(a,c,v,b,d){
			//waitingDialog.hide();
		}
	}
	var _errorCallBack;
	if($.isFunction(errorCallBack)){
		_errorCallBack = function(a,c,v,b,d){
			errorCallBack(a,c,v,b,d);
			//waitingDialog.hide();
		}
	}else{
		_errorCallBack = function(a,c,v,b,d){
			//waitingDialog.hide();
		}
	}
	$.ajax({
		type : tipo,
		async : false,
		cache : false,
		contentType : 'application/json',
		url : action,
		data : data,
		dataType : 'json',
		success : _successCallBack,
		error : _errorCallBack
	});
}
function habilitarRowSelectionDataTable(content, dtTabla, boton){
	$('#' + content + ' tbody').off('click').on('click', 'tr', function () {
		if ( $(this).hasClass('selected') ) {
			$(this).removeClass('selected');
			if(boton){
				boton.attr('disabled', true);
			}
		}else {
			dtTabla.$('tr.selected').removeClass('selected');
			$(this).addClass('selected');
			if(boton){
				boton.attr('disabled', false);
			}
		}
	} );
}
function createColumnNumeroOrden(dtTabla, nroColumn){
	dtTabla.on( 'order.dt search.dt', function () {
		dtTabla.column(nroColumn, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
}
function esValidoRequerido(field){
	for (var i = 0; i < field.length; i+=1) {
    	showMessageInput(field[i],"success");
    }
	var esValido = true;
	for (var i = 0; i < field.length; i+=1) {
		if(isEmpty(field[i].val())){
			showMessageInput(field[i],"danger","Campo obligatorio");
			esValido = false;
		}else{
			showMessageInput(field[i],"success");
		}
	}
	return esValido;
}
function isEmpty(value){
	if(value && value!=undefined && value!=null && value!=''){
		return false;
	}
	return true;
}
function serializeDtTable(params, dtTable, atributeName){
	params[atributeName] = [];
	for(var i = 0; i<dtTable.data().length; i++){
		params[atributeName].push(dtTable.data()[i]);
	}
	return params;
}
function limpiarDtTable(dtTable){
	for(var i = 0; i<dtTable.data().length; i++){
		dtTabla.row(dtTable.data()[i]).remove().draw( false );
	}
}