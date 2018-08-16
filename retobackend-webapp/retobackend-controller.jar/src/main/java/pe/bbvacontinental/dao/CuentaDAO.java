package pe.bbvacontinental.dao;

import java.util.List;

import pe.bbvacontinental.model.Cuenta;

public interface CuentaDAO {
	
	public Integer update(Cuenta cuenta);

	public Cuenta findByPrimaryKey(Integer codigoCuenta);

	public List<Cuenta> findByParameter(Cuenta cuenta);
}
