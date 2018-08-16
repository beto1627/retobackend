package pe.bbvacontinental.daoImpl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.bbvacontinental.dao.MovimientoDAO;
import pe.bbvacontinental.model.Movimiento;

public class SqlMapMovimientoDAO extends SqlMapClientDaoSupport implements MovimientoDAO {

	@Override
	public void insertar(Movimiento movimiento) {
		getSqlMapClientTemplate().insert("movimiento.insert", movimiento);
	}

}
