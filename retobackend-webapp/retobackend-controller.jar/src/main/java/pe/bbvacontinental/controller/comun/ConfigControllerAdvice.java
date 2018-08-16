package pe.bbvacontinental.controller.comun;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pe.bbvacontinental.util.BussinessJSONException;
import pe.bbvacontinental.util.FormatoConstantes;
import pe.bbvacontinental.util.MaestrosException;
import pe.bbvacontinental.util.MensajeBean;
import pe.bbvacontinental.util.Mensajes;
import pe.bbvacontinental.util.Util;

@ControllerAdvice
public class ConfigControllerAdvice extends ResponseEntityExceptionHandler {

    private static final Log log = LogFactory.getLog(ConfigControllerAdvice.class);
    
    private MessageSource messageSource;
    
    private ObjectMapper jacksonMapper;
    
    @Autowired
    public ConfigControllerAdvice(MessageSource messageSource, ObjectMapper jacksonMapper) {
        this.messageSource = messageSource;
        this.jacksonMapper = jacksonMapper;
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(FormatoConstantes.FORMAT_FECHA_DDMMYYYY);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
    @ExceptionHandler(value = {BussinessJSONException.class})
    public final Object handleGeneralExceptionJSON(Exception ex, WebRequest request){
    	HttpHeaders headers = new HttpHeaders();
        Map<String, Object> body = new HashMap<String, Object>();       
    	return handleExceptionInternal(ex, body, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
    
    @ExceptionHandler(value = {MaestrosException.class, Exception.class, HttpClientErrorException.class})
    public final Object handleGeneralException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        Map<String, Object> body = new HashMap<String, Object>();
        if (ex instanceof HttpClientErrorException) {
            HttpClientErrorException httpClientEx = (HttpClientErrorException) ex;
            if (MediaType.APPLICATION_JSON.isCompatibleWith(httpClientEx.getResponseHeaders().getContentType()) && 
                    StringUtils.hasText(httpClientEx.getResponseBodyAsString())) {
                try {
                    Map<String, Object> mpResult = jacksonMapper.readValue(httpClientEx.getResponseBodyAsString(), new TypeReference<HashMap<String, Object>>(){});
                    body.put(Mensajes.PARAM_MESSAGE, mpResult.get("msg"));
                    body.put(Mensajes.PARAM_ERRORS, mpResult.get(Mensajes.PARAM_ERRORS));
                }
                catch (Exception innerEx) {
                    log.warn("Ignored", innerEx);
                }
            }
        }
    	String ajaxRequest = "XMLHttpRequest";
    	if(!ajaxRequest.equals(request.getHeader("X-Requested-With"))){
    		ModelAndView viewE = new ModelAndView("PagM");
    		MensajeBean mensajeBean = new MensajeBean();
			mensajeBean.setMensajeerror(ex.getMessage());
			mensajeBean.setMensajesol("Vuelva a intentar ejecutar la aplicacion. Si el problema continua, intente salir del Menu e ingresar nuevamente.");
			viewE.addObject("beanM",mensajeBean);
    		return viewE;
    	}else{
    		return handleExceptionInternal(ex, body, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    	}
    }
    @SuppressWarnings("unchecked")
	@Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (body instanceof Map && request instanceof ServletWebRequest) {
            ServletWebRequest servletRequest = (ServletWebRequest) request; 
            Map<String, Object> response = (Map<String, Object>) body;
            response.put("URL", servletRequest.getRequest().getRequestURL().toString());
            response.put(Mensajes.PARAM_COD, Mensajes.PARAM_VALUE_COD_EXCEP);
            if (Util.isNullOrEmpty(ex.getMessage()) && response.get(Mensajes.PARAM_MESSAGE) == null)
                response.put(Mensajes.PARAM_MESSAGE, "Ocurrió un error en la Petición.");
            else if(response.get(Mensajes.PARAM_MESSAGE) == null){
            	response.put(Mensajes.PARAM_MESSAGE, ex.getMessage());
            }
        }
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute("javax.servlet.error.exception", ex, WebRequest.SCOPE_REQUEST);
        }
        log.error("handledException", ex);
        return new ResponseEntity<Object>(body, headers, status);
    }
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        BindingResult result = ex.getBindingResult();
        List<ObjectError> objectErrors = result.getAllErrors();
        Map<String, Object> message = processObjectErrors(objectErrors, ex);
        message.put(Mensajes.PARAM_MESSAGE, "Hay errores de validación:");
        return handleExceptionInternal(ex, message, headers, status, request);
    }
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) { 
    		Map<String, Object> message = new HashMap<String, Object>();
    		message.put(Mensajes.PARAM_MESSAGE, "El input '" + ex.getParameterName() + "'  de tipo '" + ex.getParameterType() + "' no está presente.");
		return handleExceptionInternal(ex, message, headers, status, request);
	}
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult result = ex.getBindingResult();
        List<ObjectError> objectErrors = result.getAllErrors();
        Map<String, Object> message = processObjectErrors(objectErrors, ex);
        message.put(Mensajes.PARAM_MESSAGE, "Hay errores de validación:");
        return handleExceptionInternal(ex, message, headers, status, request);
    }
     
	@SuppressWarnings("serial")
	private Map<String, Object> processObjectErrors(List<ObjectError> objectErrors, Exception ex) {
        Map<String, Object> message = new HashMap<String, Object>();
        List<Map<String, Object>> detailFields = new ArrayList<Map<String,Object>>();
        for (final ObjectError objError: objectErrors) {
            if (objError instanceof FieldError) {
            	Map<String, Object> mapDetailsField = new HashMap<String, Object>(){};
            	mapDetailsField.put(Mensajes.PARAM_COD, ((FieldError) objError).getField());
            	mapDetailsField.put(Mensajes.PARAM_ERROR_DETAIL, resolveLocalizedErrorMessage(objError));
            	detailFields.add(mapDetailsField);
            }
            else {
            	Map<String, Object> mapDetailsField = new HashMap<String, Object>(){};
            	mapDetailsField.put(Mensajes.PARAM_COD, objError.getCode());
            	mapDetailsField.put(Mensajes.PARAM_ERROR_DETAIL, resolveLocalizedErrorMessage(objError));
            	detailFields.add(mapDetailsField);
            }
        }
        message.put(Mensajes.PARAM_ERRORS, detailFields);
        return message;
    }
    
    private String resolveLocalizedErrorMessage(ObjectError fieldError) {
        Locale currentLocale =  LocaleContextHolder.getLocale();
        return messageSource.getMessage(fieldError, currentLocale);
    }
}
