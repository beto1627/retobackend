package pe.bbvacontinental.daoImpl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.bbvacontinental.dao.CatalogoDAO;
import pe.bbvacontinental.model.Catalogo;

public class SqlMapCatalogoDAO extends SqlMapClientDaoSupport implements CatalogoDAO{

	@Override
	public List<Catalogo> findByParameter(Catalogo catalogo) {
		List<Catalogo> lstCatalogos = (List<Catalogo>) getSqlMapClientTemplate().queryForList("catalogo.findByParameter", catalogo);
        return lstCatalogos;
	}

}
