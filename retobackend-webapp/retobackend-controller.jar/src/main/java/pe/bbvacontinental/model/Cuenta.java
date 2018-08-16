package pe.bbvacontinental.model;

import java.io.Serializable;

public class Cuenta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7449114202635262753L;
	private Integer codigoCuenta;
	private String numeroCuenta;
	private String tipoCuenta;
	private String descTipoCuenta;
	private String codigoProducto;
	private String descProducto;
	private Double saldo;
	private String codigoMoneda;
	private String descMoneda;
	private Double saldoMinimo;
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

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
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

	public Double getSaldoMinimo() {
		return saldoMinimo;
	}

	public void setSaldoMinimo(Double saldoMinimo) {
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
