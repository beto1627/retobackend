package pe.bbvacontinental.service;

import pe.bbvacontinental.bean.PersonaBean;
import pe.bbvacontinental.util.MaestrosException;

public interface PersonaService {
	public PersonaBean get(Integer codigoPersona) throws MaestrosException;
}
