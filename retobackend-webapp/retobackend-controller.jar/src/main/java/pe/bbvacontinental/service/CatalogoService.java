package pe.bbvacontinental.service;

import java.util.List;

import pe.bbvacontinental.bean.CatalogoBean;
import pe.bbvacontinental.util.MaestrosException;

public interface CatalogoService {
	public List<CatalogoBean> buscar(Integer codigoCatalogo) throws MaestrosException;
}
