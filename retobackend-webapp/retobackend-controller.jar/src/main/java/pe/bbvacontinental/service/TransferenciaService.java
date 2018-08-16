package pe.bbvacontinental.service;

import pe.bbvacontinental.bean.MovimientoBean;
import pe.bbvacontinental.util.MaestrosException;

public interface TransferenciaService {
	public void realizarTransferencia(MovimientoBean movimientoBean) throws MaestrosException;
}
