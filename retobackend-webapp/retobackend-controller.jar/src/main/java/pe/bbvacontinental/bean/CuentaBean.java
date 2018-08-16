package pe.bbvacontinental.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class CuentaBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -518152426770964593L;
	@NotNull
	private Integer codigoCuenta;
	@NotNull
	private String numeroCuenta;
	@NotNull
	private String tipoCuenta;
	private String descTipoCuenta;
	private String codigoProducto;
	private String descProducto;
	private String saldo;
	@NotNull
	private String codigoMoneda;
	private String descMoneda;
	private String saldoMinimo;
	private Integer codigoPersona;
	private String estado;

	public Integer getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(Integer codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getDescTipoCuenta() {
		return descTipoCuenta;
	}

	public void setDescTipoCuenta(String descTipoCuenta) {
		this.descTipoCuenta = descTipoCuenta;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getDescProducto() {
		return descProducto;
	}

	public void setDescProducto(String descProducto) {
		this.descProducto = descProducto;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getCodigoMoneda() {
		return codigoMoneda;
	}

	public void setCodigoMoneda(String codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}

	public String getDescMoneda() {
		return descMoneda;
	}

	public void setDescMoneda(String descMoneda) {
		this.descMoneda = descMoneda;
	}

	public String getSaldoMinimo() {
		return saldoMinimo;
	}

	public void setSaldoMinimo(String saldoMinimo) {
		this.saldoMinimo = saldoMinimo;
	}

	public Integer getCodigoPersona() {
		return codigoPersona;
	}

	public void setCodigoPersona(Integer codigoPersona) {
		this.codigoPersona = codigoPersona;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
