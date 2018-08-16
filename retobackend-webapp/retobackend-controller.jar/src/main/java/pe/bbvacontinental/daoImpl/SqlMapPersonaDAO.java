package pe.bbvacontinental.daoImpl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.bbvacontinental.dao.PersonaDAO;
import pe.bbvacontinental.model.Persona;

public class SqlMapPersonaDAO extends SqlMapClientDaoSupport implements PersonaDAO{

	@Override
	public Persona findByPrimaryKey(Integer codigoPersona) {
		Persona record = (Persona) getSqlMapClientTemplate().queryForObject("persona.findByPrimaryKey", codigoPersona);
        return record;
	}

	@Override
	public Integer update(Persona persona) {
		Integer rows = getSqlMapClientTemplate().update("persona.update", persona);
        return rows;
	}

}
