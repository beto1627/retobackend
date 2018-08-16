package pe.bbvacontinental.util;

public class ExpresionesRegulares {
	public static final String EXPRREG_CODPERSONAL = "^([0-9A-ZÑ]{4})$";
	public static final String EXPRREG_TEXTO = "^[\\w\\s,.\\-\\_&+?¿!¡:,.;()¡\\\"#'$%/=*-\\[\\]{}_<>@áéíóúÁÉÍÓÚñÑ°]+$";
	public static final String EXPRREG_NOMBRES_APELLIDOS = "^[A-Za-záéíóúÁÉÍÓÚñÑ\\s]+$";
	public static final String EXPRREG_NUMRUC = "^[1-9]{1}[0-9]{10}$";
	public static final String EXPRREG_NUMSOLICITUD = "^([1-9]{1}[0-9]{0,10})$";
	public static final String EXPRREG_ALPHANUMERIC = "^[a-zA-Z0-9ñÑ]*$";
	public static final String EXPRREG_ALPHA = "^[a-zA-ZñÑ]*$";
	/**
	 * Expresion regular para fechas entre el 2000 y 2199
	 * El formato es dd/mm/yyyy
	 * constantes = EXPRREG_FECHA
	 */
	public static final String EXPRREG_FECHA = "^([0-2][0-9]|3[0-1])\\/(0[0-9]|1[0-2])\\/(20|21)([0-9][0-9])?[0-9][0-9]$";
	public static final String EXPRREG_CORREO = "^[_a-zA-Z0-9-]+(.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(.[a-zA-Z0-9-]+)+(.[a-zA-Z]{2,4})$";
	public static final String EXPRREG_NUMERO_POSITIVO = "^\\d+$";
	public static final String EXPRREG_NUMERO_CELULAR = "^[9]{1}[0-9]{8}$";

	private ExpresionesRegulares() {
	}
}