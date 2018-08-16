package pe.bbvacontinental.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.bbvacontinental.bean.CuentaBean;
import pe.bbvacontinental.dao.CuentaDAO;
import pe.bbvacontinental.model.Cuenta;
import pe.bbvacontinental.service.CuentaService;
import pe.bbvacontinental.util.Constantes;
import pe.bbvacontinental.util.FormatoNumero;
import pe.bbvacontinental.util.MaestrosException;
import pe.bbvacontinental.util.Util;

@Service("retobackend.cuentaService")
public class CuentaServiceImpl implements CuentaService{
	
	@Autowired
	private CuentaDAO cuentaDAO;

	@Override
	public List<CuentaBean> buscar(Integer codigoPersona) throws MaestrosException {
		List<CuentaBean> lstCuentaBeans = new ArrayList<CuentaBean>();
		List<Cuenta> lstCuentas;
		try{
			Cuenta record = new Cuenta();
			record.setCodigoPersona(codigoPersona);
			record.setEstado(Constantes.CODIGO_ESTADO_ACTIVO);
			lstCuentas = cuentaDAO.findByParameter(record);
			for(Cuenta cuenta : lstCuentas){
				lstCuentaBeans.add(getCuentaBean(cuenta));
			}
		}catch(Exception e){
			throw new MaestrosException(e.getMessage());
		}
		return lstCuentaBeans;
	}
	
	private CuentaBean getCuentaBean(Cuenta cuenta){
		CuentaBean cuentaBean = new CuentaBean();
		if(Util.isNull(cuenta)){
			return cuentaBean;
		}
		
		cuentaBean.setCodigoCuenta(cuenta.getCodigoCuenta());
		cuentaBean.setNumeroCuenta(cuenta.getNumeroCuenta());
		cuentaBean.setTipoCuenta(cuenta.getTipoCuenta());
		cuentaBean.setDescTipoCuenta(cuenta.getDescTipoCuenta());
		cuentaBean.setCodigoProducto(cuenta.getCodigoProducto());
		cuentaBean.setDescProducto(cuenta.getDescProducto());
		cuentaBean.setSaldo(FormatoNumero.formatear(cuenta.getSaldo()));
		cuentaBean.setCodigoMoneda(cuenta.getCodigoMoneda());
		cuentaBean.setDescMoneda(cuenta.getDescMoneda());
		cuentaBean.setSaldoMinimo(FormatoNumero.formatear(cuenta.getSaldoMinimo()));
		cuentaBean.setCodigoPersona(cuenta.getCodigoPersona());
		cuentaBean.setEstado(cuenta.getEstado());
		
		return cuentaBean;
	}

}
