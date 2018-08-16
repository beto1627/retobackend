package pe.bbvacontinental.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.bbvacontinental.bean.CatalogoBean;
import pe.bbvacontinental.dao.CatalogoDAO;
import pe.bbvacontinental.model.Catalogo;
import pe.bbvacontinental.service.CatalogoService;
import pe.bbvacontinental.util.Constantes;
import pe.bbvacontinental.util.MaestrosException;
import pe.bbvacontinental.util.Util;

@Service("retobackend.catalogoService")
public class CatalogoServiceImpl implements CatalogoService {
	
	@Autowired
	private CatalogoDAO catalogoDAO;

	@Override
	public List<CatalogoBean> buscar(Integer codigoCatalogo) throws MaestrosException{
		List<CatalogoBean> lstCatalogoBeans = new ArrayList<CatalogoBean>();
		List<Catalogo> lstCuentas;
		try{
			Catalogo record = new Catalogo();
			record.setCodigoCatalogo(codigoCatalogo);
			record.setEstado(Constantes.CODIGO_ESTADO_ACTIVO);
			lstCuentas = catalogoDAO.findByParameter(record);
			for(Catalogo catalogo : lstCuentas){
				lstCatalogoBeans.add(getCatalogoBean(catalogo));
			}
		}catch(Exception e){
			throw new MaestrosException(e.getMessage());
		}
		return lstCatalogoBeans;
	}
	
	private CatalogoBean getCatalogoBean(Catalogo catalogo){
		CatalogoBean catalogoBean = new CatalogoBean();
		if(Util.isNull(catalogo)){
			return catalogoBean;
		}
		
		catalogoBean.setCodigoCatalogo(catalogo.getCodigoCatalogo());
		catalogoBean.setCodigoDetalle(catalogo.getCodigoDetalle());
		catalogoBean.setDescripcion(catalogo.getDescripcion());
		catalogoBean.setEstado(catalogo.getEstado());
		
		return catalogoBean;
	}

}
