$.fn.validForm = function(){
	var result = true;
	this.find('input.required').each(function(index,input){
		var me = $(input);
		var type = me.attr('type');
		var habilitado = me.attr('disabled');
		if(type=="text" && habilitado !=='disabled'){
			var value = $.trim(me.val())
			if(!isNoEmpty(value)){
				showMessageInput(me,"danger","Campo obligatorio");
				if(result)
					result = false;
			}else{
				showMessageInput(me,'success','');
			}
		}
	});
	this.find('select.required').each(function(index,input){
		var me = $(input);			
			var value = $.trim(me.val())
			var habilitado = me.attr('disabled');
			if(!isNoEmpty(value) && habilitado !=='disabled'){
				showMessageInput(me,"danger","Campo obligatorio");
				if(result)
					result = false;
			}else{
				showMessageInput(me,'success','');
			}
	});
	this.find('textarea.required').each(function(index,input){
		var me = $(input);			
			var value = $.trim(me.val())
			var habilitado = me.attr('disabled');
			if(!isNoEmpty(value) && habilitado !=='disabled'){
				showMessageInput(me,"danger","Campo obligatorio");
				if(result)
					result = false;
			}else{
				showMessageInput(me,'success','');
			}
	});
	return result;
};
$.fn.serializeObject = function(){
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push($.trim(this.value) || '');
        } else {
            o[this.name] = $.trim(this.value) || '';
        }
    });
    return o;
};

$.fn.serializeObjectNew = function(){
    var o = {};
    var a = this.serializeArray();
    var value;
    var name;
    $.each(a, function() {
    	value = $.trim(this.value) || ''
    	name = this.name;
        if (o[name] !== undefined) {
            if (!o[name].push) {
                o[name] = [o[name]];
            }
            o[name].push(value);
        } else {
			if(name.indexOf('.')>=0){
				var name1 = name.substring(0, name.indexOf('.'));
				var name2 = name.substring(name.indexOf('.') + 1, name.length);
				if(o[name1]==undefined){
					o[name1] = {};
				}
				if(name2.indexOf('.')>=0){
					var name3 = name2.substring(name2.indexOf('.') + 1, name2.length);
					var name2 = name2.substring(0, name2.indexOf('.'));
					if(o[name1][name2]==undefined){
						o[name1][name2] = {};
					}
					o[name1][name2][name3] = value;
				}else{
					o[name1][name2] = value;
				}
			}else{
				o[name] = value;
			}
        }
    });
    return o;
};

$.fn.serializeObjectToParam = function(){
	var obj  = this.serializeObject();
	var array = Object.keys(obj);
	var strParams = "";
	array.forEach(function(e,b){
		strParams += "&" + e + "=" + obj[e]; 
	});
	//JSON.stringify(parametros);
	return strParams;
}
$.fn.validRegExp = function(regexpr,message){
	var value = this.val();
	if(!value.match(regexpr) && value.length > 0){
		//if(evalNull(message)){
			showMessageInput(this,'danger',message)
		//}
		return true;
	}else{
		showMessageInput(this,'success','');
		return false;
	}
}
$.fn.messageValidation = function(errors){
	if($.isArray(errors)){
		var me = this;
		$.each(errors, function (id, error) {
			var input = $(me.find('[name = ' + error.cod + ']'));
			showMessageInput(input,'danger',error.msg);
        });
	}
}
var waitingDialog = waitingDialog || (function ($) {
    'use strict';

                // Creating modal dialog's DOM
                var $dialog = $(
                               '<div class="modal fade" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-hidden="true" style="padding-top:15%; overflow-y:visible;">' +
                               '<div class="modal-dialog modal-m">' +
                               '<div class="modal-content" style="width: 50%;  left: 25%; right: 25%;">' +
                                               '<div class="modal-header"><h4 style="margin:0;"></h4></div>' +
                                               '<div class="modal-body">' +
                                                               '<div class="progress progress-striped active" style="margin-bottom:0;"><div class="progress-bar" style="width: 100%"></div></div>' +
                                               '</div>' +
                               '</div></div></div>');

                return {
                               /**
                               * Opens our dialog
                               * @param message Custom message
                               * @param options Custom options:
                               *                                                             options.dialogSize - bootstrap postfix for dialog size, e.g. "sm", "m";
                               *                                                             options.progressType - bootstrap postfix for progress bar type, e.g. "success", "warning".
                               */
                               show: function (message, options) {
                                               // Assigning defaults
                                               if (typeof options === 'undefined') {
                                                               options = {};
                                               }
                                               if (typeof message === 'undefined') {
                                                               message = 'Procesando ...';
                                               }
                                               var settings = $.extend({
                                                               dialogSize: 'm',
                                                               progressType: '',
                                                               onHide: null // This callback runs after the dialog was hidden
                                               }, options);

                                               // Configuring dialog
                                               $dialog.find('.modal-dialog').attr('class', 'modal-dialog').addClass('modal-' + settings.dialogSize);
                                               $dialog.find('.progress-bar').attr('class', 'progress-bar');
                                               if (settings.progressType) {
                                                               $dialog.find('.progress-bar').addClass('progress-bar-' + settings.progressType);
                                               }
                                               $dialog.find('h4').text(message);
                                               // Adding callbacks
                                               if (typeof settings.onHide === 'function') {
                                                               $dialog.off('hidden.bs.modal').on('hidden.bs.modal', function (e) {
                                                                              settings.onHide.call($dialog);
                                                               });
                                               }
                                               // Opening dialog
                                               $dialog.modal();
                               },
                               /**
                               * Closes dialog
                               */
                               hide: function () { 
                            		   $dialog.modal('hide');
                               }
                };

})(jQuery);         

$.extend(
		{
		    redirectPost: function(location, args)
		    {
		        var form = $('<form></form>');
		        form.attr("method", "post");
		        form.attr("action", location);

		        $.each( args, function( key, value ) {
		            var field = $('<input></input>');

		            field.attr("type", "hidden");
		            field.attr("name", key);
		            field.attr("value", value);

		            form.append(field);
		        });
		        $(form).appendTo('body').submit();
		    }
		});