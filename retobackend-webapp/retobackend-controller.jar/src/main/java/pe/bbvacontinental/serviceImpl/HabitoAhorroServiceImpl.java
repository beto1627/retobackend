package pe.bbvacontinental.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.bbvacontinental.bean.HabitoAhorroBean;
import pe.bbvacontinental.dao.CuentaDAO;
import pe.bbvacontinental.dao.PersonaDAO;
import pe.bbvacontinental.model.Cuenta;
import pe.bbvacontinental.model.Persona;
import pe.bbvacontinental.service.HabitoAhorroService;
import pe.bbvacontinental.util.MaestrosException;

@Service("retobackend.habitoAhorroService")
public class HabitoAhorroServiceImpl implements HabitoAhorroService {

	@Autowired
	private PersonaDAO personaDAO;
	@Autowired
	private CuentaDAO cuentaDAO;
	
	@Override
	public void registrarHabito(HabitoAhorroBean habitoAhorroBean) throws MaestrosException{
		Persona persona;
		Cuenta cuenta;
		try{
			persona = personaDAO.findByPrimaryKey(habitoAhorroBean.getCodigoPersona());
			cuenta = cuentaDAO.findByPrimaryKey(habitoAhorroBean.getCodigoCuenta());
			
			persona.setEmail(habitoAhorroBean.getEmail());
			personaDAO.update(persona);
			
			cuenta.setSaldoMinimo(habitoAhorroBean.getSaldoMinimo());
			cuentaDAO.update(cuenta);
			
		}catch(Exception e){
			throw new MaestrosException(e.getMessage());
		}
	}

}
