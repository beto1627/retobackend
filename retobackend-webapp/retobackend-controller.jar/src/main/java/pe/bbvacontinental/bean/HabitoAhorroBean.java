package pe.bbvacontinental.bean;

import javax.validation.constraints.NotNull;

public class HabitoAhorroBean {
	@NotNull
	private Integer codigoPersona;
	@NotNull
	private Integer codigoCuenta;
	@NotNull
	private Double saldoMinimo;
	@NotNull
	private String email;

	public Integer getCodigoPersona() {
		return codigoPersona;
	}

	public void setCodigoPersona(Integer codigoPersona) {
		this.codigoPersona = codigoPersona;
	}

	public Integer getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(Integer codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public Double getSaldoMinimo() {
		return saldoMinimo;
	}

	public void setSaldoMinimo(Double saldoMinimo) {
		this.saldoMinimo = saldoMinimo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
