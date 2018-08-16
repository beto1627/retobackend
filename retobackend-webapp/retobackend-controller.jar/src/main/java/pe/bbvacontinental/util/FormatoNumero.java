package pe.bbvacontinental.util;

import java.text.DecimalFormat;

public class FormatoNumero {
	private FormatoNumero(){
		
	}
	
	public static String formatear(Double numero){
		DecimalFormat formateador = new DecimalFormat("###,###.00");
		try{
			return formateador.format(numero);
		}catch(Exception e){
			return formateador.format(0);
		}
	}
}
