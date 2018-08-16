package pe.bbvacontinental.service;

import pe.bbvacontinental.util.MaestrosException;

public interface MailService {
	public void enviarAlerta(Integer codigoPersona, Integer codigoCuenta) throws MaestrosException;
}
