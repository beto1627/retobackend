package pe.bbvacontinental.daoImpl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import pe.bbvacontinental.dao.CuentaDAO;
import pe.bbvacontinental.model.Cuenta;
import pe.bbvacontinental.model.Persona;

public class SqlMapCuentaDAO extends SqlMapClientDaoSupport implements CuentaDAO{
	
	public Integer update(Cuenta cuenta){
		Integer rows = getSqlMapClientTemplate().update("cuenta.update", cuenta);
        return rows;
	}
	
	@Override
	public Cuenta findByPrimaryKey(Integer codigoCuenta) {
		Cuenta record = (Cuenta) getSqlMapClientTemplate().queryForObject("cuenta.findByPrimaryKey", codigoCuenta);
        return record;
	}

	@Override
	public List<Cuenta> findByParameter(Cuenta cuenta) {
		List<Cuenta> lstCuentas = (List<Cuenta>) getSqlMapClientTemplate().queryForList("cuenta.findByParameter", cuenta);
        return lstCuentas;
	}

}
