package pe.bbvacontinental.util;

public class Mensajes {
	public static final String PARAM_MESSAGE = "message";
	public static final String PARAM_URL = "URL";
	public static final String PARAM_DATA = "data";
	public static final String PARAM_COD = "cod";
	public static final String PARAM_ERRORS = "errors";
	public static final String PARAM_ERROR_DETAIL = "msg";
	public static final String PARAM_VALUE_COD_OK = "ok";
	public static final String PARAM_VALUE_COD_EXCEP = "exception";

	public static final String MSG_SEARCH_NOFOUND = "No se encontraron registros que satisfagan los criterios de búsqueda.";
	public static final String MSG_SEARCH_NOFOUND_MAESTROS = "No existe registros para los criterios de búsqueda ingresados";

	/* mensajes web personalizado */
	public static final String STR_VALUE_REPLACE = "{value}";

	
	public static final String MSG_REGISTRO_ERROR_ACCION = "No se Indicó el Registro para realizar esta acción.";
	
	public static final String MSG_REGISTRO_ERROR_ELIMINAR = "No ha sido posible eliminar el Registro {value}, intente nuevamente.";
	public static final String MSG_REGISTRO_ERROR_GUARDAR = "No ha sido posible guardar el Registro {value}, intente nuevamente.";
	public static final String MSG_REGISTRO_YA_EXISTE = "{value} ingresado ya existe, ingrese otro dato.";
	public static final String MSG_REGISTRO_ERROR_ACTUALIZAR = "No ha sido posible actualizar, intente nuevamente.";

	public static final String DES_REGISTRO_ANULACION_EXITO = "Se anuló el Registro Nro {value} correctamente";
	public static final String DES_REGISTRO_NUEVO_EXITO = "Los datos ingresados se guardaron correctamente.";
	public static final String DES_REGISTRO_MODIFICACION_EXITO = "Los datos modificados se guardaron correctamente.";
	public static final String DES_REGISTRO_ELIMINAR_EXITO = "El registro se eliminó correctamente.";

	public static final String DES_MSG_EXCEPTION_SOAP = "Ocurrió un error en el Servicio Web.";

	public static final String CUS004_EXCP_001 = "Debe ingresar mínimo 3 caracteres";
	public static final String CUS004_EXCP_002 = "El Código de Registro es incorrecto. Debe ser 4 caracteres.";
	public static final String CUS004_EXCP_003 = "La fecha inicio debe ser igual o mayor a la fecha actual.";
	public static final String CUS004_EXCP_004 = "La fecha fin debe ser igual o mayor a la fecha inicio";
	public static final String CUS004_EXCP_006 = "Debe ingresar un código de persona.";
	public static final String CUS004_EXCP_007 = "Debe validar el Código de Registro.";
	public static final String CUS004_EXCP_008 = "El Código de Registro no existe.";
	public static final String CUS004_EXCP_009 = "El Código de Registro no se encuentra activo.";
	public static final String CUS004_EXCP_011 = "Existe cruce de fechas con otro permiso.";
	public static final String CUS004_EXCP_012 = "No es posible modificar el  permiso. Solo se modifican permisos posteriores a la fecha de hoy.";
	public static final String CUS004_EXCP_013 = "La fecha fin debe ser mayor o igual a la fecha actual.";
	public static final String CUS004_EXCP_014 = "No es posible eliminar un permiso iniciado.";
	public static final String CUS004_EXCP_015 = "Es obligatorio ingresar al menos un criterio de búsqueda.";
	
	public static final String CUS005_EXCP_E10 = "No es posible eliminar, el establecimiento se encuentra asociado a un bien fiscalizado en zona geográfica de régimen especial (ZRE) o zona geográfica de régimen complementario (ZRC)";

	private Mensajes() {
	}
}
