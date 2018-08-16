package pe.bbvacontinental.bean;

import java.io.Serializable;

public class CatalogoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4917955504259395808L;
	private Integer codigoCatalogo;
	private Integer codigoDetalle;
	private String descripcion;
	private String estado;

	public Integer getCodigoCatalogo() {
		return codigoCatalogo;
	}

	public void setCodigoCatalogo(Integer codigoCatalogo) {
		this.codigoCatalogo = codigoCatalogo;
	}

	public Integer getCodigoDetalle() {
		return codigoDetalle;
	}

	public void setCodigoDetalle(Integer codigoDetalle) {
		this.codigoDetalle = codigoDetalle;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
