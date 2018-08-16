package pe.bbvacontinental.util;

import java.io.Serializable;
import java.util.Date;

public class ElementoRegistro extends Elemento implements Serializable{
	
	private static final long serialVersionUID = 2053406531577594027L;

	private Short numVersion;
    
    private Integer numVerreg;
    
	private String codOrigen;
	
	private String indCondicion;
	
    private String codEstado;
    
    private Integer numRefmodif;
    
    private String fecBajaDefault;
    
    private String fecBajaString;
    
    private String codTipbien;

    private Date fecBaja;
    
    private Date fecAlta;

    private String numRuc;
    

    final public Short getNumVersion() {
		return numVersion;
	}

	final public void setNumVersion(Short numVersion) {
		this.numVersion = numVersion;
	}

	final public String getCodOrigen() {
		return codOrigen;
	}

	final public void setCodOrigen(String codOrigen) {
		this.codOrigen = codOrigen;
	}
	
	final public String getIndCondicion() {
		return indCondicion;
	}

	final public void setIndCondicion(String indCondicion) {
		this.indCondicion = indCondicion;
	}


	public String getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(String codEstado) {
		this.codEstado = codEstado == null ? null : codEstado.trim();
	}

	public Integer getNumVerreg() {
		return numVerreg;
	}

	public void setNumVerreg(Integer numVerreg) {
		this.numVerreg = numVerreg;
	}

	public Integer getNumRefmodif() {
		return numRefmodif;
	}

	public void setNumRefmodif(Integer numRefmodif) {
		this.numRefmodif = numRefmodif;
	}

	public String getCodTipbien() {
		return codTipbien;
	}

	public void setCodTipbien(String codTipbien) {
		this.codTipbien = codTipbien == null ? null : codTipbien.trim();
	}

	public Date getFecBaja() {
		return fecBaja;
	}

	public void setFecBaja(Date fecBaja) {
		this.fecBaja = fecBaja;
	}

	public Date getFecAlta() {
		return fecAlta;
	}

	public void setFecAlta(Date fecAlta) {
		this.fecAlta = fecAlta;
	}

	public String getNumRuc() {
		return numRuc;
	}

	public void setNumRuc(String numRuc) {
		this.numRuc = numRuc == null ? null : numRuc.trim();
	}

	public String getFecBajaDefault() {
		return fecBajaDefault;
	}

	public void setFecBajaDefault(String fecBajaDefault) {
		this.fecBajaDefault = fecBajaDefault;
	}

	public String getFecBajaString() {
		return fecBajaString;
	}

	public void setFecBajaString(String fecBajaString) {
		this.fecBajaString = fecBajaString;
	}
}
