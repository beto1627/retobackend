package pe.bbvacontinental.util;

public class Constantes {

	public static final String REGISTRO_NO_ELIMINADO = "0";

	public static final Integer COD_CATOLOGO_TIPO_DOCUMENTO = 1;
	public static final Integer COD_CATOLOGO_TIPO_CUENTA = 2;
	public static final Integer COD_CATOLOGO_TIPO_PRODUCTO = 3;
	public static final Integer COD_CATOLOGO_MONEDA = 4;
	public static final Integer COD_CATOLOGO_TIPO_MOVIMIENTO = 5;

	public static final Integer COD_CATOLOGO_MOVIMIENTO_RETIRO = 1;
	public static final Integer COD_CATOLOGO_MOVIMIENTO_DEPOSITO = 2;
	public static final Integer COD_CATOLOGO_MOVIMIENTO_TRANSFERENCIA = 3;

	public static final String CODIGO_ESTADO_ACTIVO = "S";
	public static final String CODIGO_ESTADO_INACTIVO = "N";

	public static final String PATH_PROPERTIES = "/src/main/resources/correo.properties";

	public static final String CORREO_HOST = "mail.smtp.host";
	public static final String CORREO_USER = "mail.smtp.user";
	public static final String CORREO_CLAVE = "mail.smtp.clave";
	public static final String CORREO_AUTENTICATION = "mail.smtp.auth";
	public static final String CORREO_ENABLE = "mail.smtp.starttls.enable";
	public static final String CORREO_PUERTO = "mail.smtp.port";
	public static final String CORREO_HOST_SMPT = "smtp.gmail.com";
	public static final String CORREO_PROTOCOL = "smtp";

	public static final String USER ="nameMail";
	public static final String CLAVE="passMail";
	public static final String HOST="smtp.gmail.com";
	public static final String AUTHENTICATION="true";
	public static final String ENABLE="true";
	public static final String PORT="587";

	public static final String CORREO_ASUNTO_ALERTA_AHORRO = "Alerta de ahorro BBVA";
}
