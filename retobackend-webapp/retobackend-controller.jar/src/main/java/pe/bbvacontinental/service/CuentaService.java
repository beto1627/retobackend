package pe.bbvacontinental.service;

import java.util.List;

import pe.bbvacontinental.bean.CuentaBean;
import pe.bbvacontinental.util.MaestrosException;

public interface CuentaService {
	public List<CuentaBean> buscar(Integer codigoPersona) throws MaestrosException;
}
