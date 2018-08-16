package pe.bbvacontinental.dao;

import pe.bbvacontinental.model.Persona;

public interface PersonaDAO {
	public Integer update(Persona persona);
	
	public Persona findByPrimaryKey(Integer codigoPersona);
}
