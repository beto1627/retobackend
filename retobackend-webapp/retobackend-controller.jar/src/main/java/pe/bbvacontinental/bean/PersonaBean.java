package pe.bbvacontinental.bean;

import java.io.Serializable;

public class PersonaBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8073883593280321869L;
	private Integer codigoPersona;
	private Integer tipoDocumento;
	private String numeroDocumento;
	private String nombre;
	private String email;
	private String estado;

	public Integer getCodigoPersona() {
		return codigoPersona;
	}

	public void setCodigoPersona(Integer codigoPersona) {
		this.codigoPersona = codigoPersona;
	}

	public Integer getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
