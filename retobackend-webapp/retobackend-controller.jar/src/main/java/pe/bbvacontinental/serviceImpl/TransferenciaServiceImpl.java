package pe.bbvacontinental.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pe.bbvacontinental.bean.MovimientoBean;
import pe.bbvacontinental.dao.CuentaDAO;
import pe.bbvacontinental.dao.MovimientoDAO;
import pe.bbvacontinental.dao.PersonaDAO;
import pe.bbvacontinental.model.Cuenta;
import pe.bbvacontinental.model.Movimiento;
import pe.bbvacontinental.model.Persona;
import pe.bbvacontinental.service.MailService;
import pe.bbvacontinental.service.TransferenciaService;
import pe.bbvacontinental.util.Constantes;
import pe.bbvacontinental.util.Excepciones;
import pe.bbvacontinental.util.MaestrosException;
import pe.bbvacontinental.util.Util;

@Service("retobackend.transferenciaService")
public class TransferenciaServiceImpl implements TransferenciaService {

	@Autowired
	private MovimientoDAO movimientoDAO;
	@Autowired
	private CuentaDAO cuentaDAO;
	@Autowired
	private PersonaDAO personaDAO;
	@Autowired
	@Qualifier("retobackend.mailService")
	private MailService mailService;

	@Override
	public void realizarTransferencia(MovimientoBean movimientoBean) throws MaestrosException{
		try {
			Integer codigoCuentaDestino = obtenerCuenta(movimientoBean.getNumeroCuentaDestino());
			Cuenta cuentaOrigen = cuentaDAO.findByPrimaryKey(movimientoBean.getCodigoCuentaOrigen());
			
			Double saldo = cuentaOrigen.getSaldo();
			
			if(saldo<movimientoBean.getMonto()){
				throw new MaestrosException(Excepciones.EXC_02);
			}
			
			saldo -= movimientoBean.getMonto();
			cuentaOrigen.setSaldo(saldo);
			cuentaDAO.update(cuentaOrigen);

			Movimiento movimiento = prepararMovimiento(movimientoBean, codigoCuentaDestino);
			movimientoDAO.insertar(movimiento);
			
			evaluarHabitoAhorro(cuentaOrigen);
		} catch (Exception e) {
			throw new MaestrosException(e.getMessage());
		}
	}
	
	private void evaluarHabitoAhorro(Cuenta cuenta){
		if(Util.isNullOrEmpty(cuenta.getSaldoMinimo()) || cuenta.getSaldoMinimo()<=0){
			return;
		}
		Persona persona = personaDAO.findByPrimaryKey(cuenta.getCodigoPersona());
		if(Util.isNullOrEmpty(persona.getEmail())){
			return;
		}
		
		if(cuenta.getSaldo()>cuenta.getSaldoMinimo()){
			return;
		}
		
		mailService.enviarAlerta(cuenta.getCodigoPersona(), cuenta.getCodigoCuenta());
	}

	private Integer obtenerCuenta(String numeroCuenta) {
		Cuenta record = new Cuenta();
		record.setNumeroCuenta(numeroCuenta);
		List<Cuenta> lstCuentaDestinos = cuentaDAO.findByParameter(record);
		if (Util.isNullOrEmpty(lstCuentaDestinos)) {
			throw new MaestrosException(Excepciones.EXC_01);
		}
		return lstCuentaDestinos.get(0).getCodigoCuenta();
	}

	private Movimiento prepararMovimiento(MovimientoBean movimientoBean, Integer codigoCuentaDestino){
		Movimiento movimiento = new Movimiento();
		movimiento.setMonto(movimientoBean.getMonto());
		movimiento.setCodigoMoneda(movimientoBean.getCodigoMoneda());
		movimiento.setCodigoCuentaOrigen(movimientoBean.getCodigoCuentaOrigen());
		movimiento.setCodigoCuentaDestino(codigoCuentaDestino);
		movimiento.setTipoMovimiento(Constantes.COD_CATOLOGO_MOVIMIENTO_TRANSFERENCIA);
		movimiento.setFechaProceso( new Date());
		
		return movimiento;
	}
}
