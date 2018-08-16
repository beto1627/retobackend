package pe.bbvacontinental.model;

import java.io.Serializable;
import java.util.Date;

public class Movimiento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6761657725365083445L;
	private Integer codigoMovimiento;
	private Double monto;
	private Integer codigoMoneda;
	private Date fechaProceso;
	private Integer codigoCuentaOrigen;
	private String numeroCuentaOrigen;
	private Integer codigoCuentaDestino;
	private String numeroCuentaDestino;
	private Integer tipoMovimiento;

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

	public Integer getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(Integer tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Integer getCodigoMoneda() {
		return codigoMoneda;
	}

	public void setCodigoMoneda(Integer codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}
}
