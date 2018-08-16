package pe.bbvacontinental.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.bbvacontinental.bean.PersonaBean;
import pe.bbvacontinental.dao.PersonaDAO;
import pe.bbvacontinental.model.Persona;
import pe.bbvacontinental.service.PersonaService;
import pe.bbvacontinental.util.MaestrosException;
import pe.bbvacontinental.util.Util;

@Service("retobackend.personaService")
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaDAO personaDAO;

	@Override
	public PersonaBean get(Integer codigoPersona) throws MaestrosException {
		Persona persona;
		PersonaBean personaBean = null;
		try{
			persona = personaDAO.findByPrimaryKey(codigoPersona);
			personaBean = getPersonaBean(persona);
		}catch(Exception e){
			throw new MaestrosException(e.getMessage());
		}
		return personaBean;
	}
	
	private PersonaBean getPersonaBean(Persona persona){
		PersonaBean personaBean = new PersonaBean();
		if(Util.isNull(persona)){
			return personaBean;
		}
		
		personaBean.setCodigoPersona(persona.getCodigoPersona());
		personaBean.setTipoDocumento(persona.getTipoDocumento());
		personaBean.setNumeroDocumento(persona.getNumeroDocumento());
		personaBean.setNombre(persona.getNombre());
		personaBean.setEmail(persona.getEmail());
		personaBean.setEstado(persona.getEstado());
		
		return personaBean;
	}

}
