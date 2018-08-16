package pe.bbvacontinental.bean;

import java.util.Date;

public class MovimientoBean {
	private Integer codigoMovimiento;
	private Double monto;
	private Integer codigoMoneda;
	private Date fechaProceso;
	private Integer codigoCuentaOrigen;
	private String numeroCuentaOrigen;
	private Integer codigoCuentaDestino;
	private String numeroCuentaDestino;
	private String tipoMovimiento;
	private String descripcionTipoMovimiento;

	public Integer getCodigoMovimiento() {
		return codigoMovimiento;
	}

	public void setCodigoMovimiento(Integer codigoMovimiento) {
		this.codigoMovimiento = codigoMovimiento;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Date getFechaProceso() {
		return fechaProceso;
	}

	public void setFechaProceso(Date fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public Integer getCodigoCuentaOrigen() {
		return codigoCuentaOrigen;
	}

	public void setCodigoCuentaOrigen(Integer codigoCuentaOrigen) {
		this.codigoCuentaOrigen = codigoCuentaOrigen;
	}

	public String getNumeroCuentaOrigen() {
		return numeroCuentaOrigen;
	}

	public void setNumeroCuentaOrigen(String numeroCuentaOrigen) {
		this.numeroCuentaOrigen = numeroCuentaOrigen;
	}

	public Integer getCodigoCuentaDestino() {
		return codigoCuentaDestino;
	}

	public void setCodigoCuentaDestino(Integer codigoCuentaDestino) {
		this.codigoCuentaDestino = codigoCuentaDestino;
	}

	public String getNumeroCuentaDestino() {
		return numeroCuentaDestino;
	}

	public void setNumeroCuentaDestino(String numeroCuentaDestino) {
		this.numeroCuentaDestino = numeroCuentaDestino;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getDescripcionTipoMovimiento() {
		return descripcionTipoMovimiento;
	}

	public void setDescripcionTipoMovimiento(String descripcionTipoMovimiento) {
		this.descripcionTipoMovimiento = descripcionTipoMovimiento;
	}

	public Integer getCodigoMoneda() {
		return codigoMoneda;
	}

	public void setCodigoMoneda(Integer codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}

}
