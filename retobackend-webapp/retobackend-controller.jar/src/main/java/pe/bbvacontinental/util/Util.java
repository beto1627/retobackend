package pe.bbvacontinental.util;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class Util {

	private Util() {
	}

	public static String processRawValue(String rawValue) {
		return processRawValue(rawValue, String.class);
	}

	@SuppressWarnings("unchecked")
	public static <T> T processRawValue(String rawValue, Class<T> classTarget) {
		if (StringUtils.isEmpty(rawValue)) {
			return null;
		}

		if (classTarget.isAssignableFrom(Long.class)) {
			return (T) Long.valueOf(rawValue);
		}

		if (classTarget.isAssignableFrom(Integer.class)) {
			return (T) Integer.valueOf(rawValue);
		}

		if (classTarget.isAssignableFrom(String.class)) {
			return (T) String.valueOf(rawValue);
		}

		if (classTarget.isAssignableFrom(Date.class)) {
			throw new UnsupportedOperationException();
		}

		return null;
	}

	

	public static String trim(String valor) {
		String result = "";
		if (!Util.isNull(valor)) {
			result = valor.trim();
		}
		return result;
	}

	public static boolean isNull(Object object) {
		if (object == null)
			return true;
		return false;
	}

	public static boolean isNullOrEmpty(String object) {
		if (object == null) {
			return true;
		} else {
			if (object.isEmpty())
				return true;
		}
		return false;
	}

	public static boolean isNullOrEmpty(Integer object) {
		if (object == null) {
			return true;
		} else {
			if (object == 0)
				return true;
		}
		return false;
	}

	public static boolean isNullOrEmpty(Long object) {
		if (isNull(object)) {
			return true;
		} else {
			if (object.intValue() == 0)
				return true;
		}
		return false;
	}

	public static boolean isNullOrEmpty(Elemento object) {
		if (object == null)
			return true;
		return false;
	}

	public static boolean isNullOrEmpty(Date object) {
		if (object == null)
			return true;
		return false;
	}

	public static boolean isNullOrEmpty(List listObject) {
		if (listObject == null) {
			return true;
		} else {
			if (listObject.isEmpty())
				return true;
		}
		return false;
	}

	public static boolean isNullOrEmpty(Double object) {
		if (Util.isNull(object))
			return true;
		return false;
	}

	/**
	 * Busca coincidenta del parametro filtro en el Parametro Contenedor.
	 * 
	 * @param filtro
	 * @param contenedor
	 * @return
	 */
	public static boolean like(String filtro, String contenedor) {
		boolean isContain = false;
		if (!Util.isNullOrEmpty(filtro) && !Util.isNullOrEmpty(contenedor)) {
			String valor1 = Util.trim(filtro).toUpperCase();
			String valor2 = Util.trim(contenedor).toUpperCase();
			if (valor2.contains(valor1))
				isContain = true;
		}else if(Util.isNullOrEmpty(filtro)){
			isContain = true;
		}
		return isContain;
	}
	public static boolean validarExprReg(String ExprReg,String texto) {
		boolean valid = true;
		Pattern p = Pattern.compile(ExprReg);
	      Matcher m = p.matcher(texto);
	      if (m.find())
	    	  valid = false;
		return valid;
	}
	
	public static boolean longitudValida(String cadena, Integer longitud){
		if(isNullOrEmpty(cadena)){
			return false;
		}
		if(cadena.length()!=longitud){
			return false;
		}
		return true;
	}
	
	public static boolean equiv(String cadena1, String cadena2){
		if(isNullOrEmpty(cadena1) || isNullOrEmpty(cadena2)){
			return false;
		}
		if(cadena1.compareTo(cadena2)==0){
			return true;
		}
		return false;
	}
	
	public static Integer toInt(String cadena){
		if(isNullOrEmpty(cadena)){
			return null;
		}
		try{
			return Integer.parseInt(cadena);
		}catch(Exception e){
			return null;
		}
	}
	
	public static Double toDouble(String cadena){
		if(isNullOrEmpty(cadena)){
			return null;
		}
		try{
			return Double.parseDouble(cadena);
		}catch(Exception e){
			return null;
		}
	}
}
