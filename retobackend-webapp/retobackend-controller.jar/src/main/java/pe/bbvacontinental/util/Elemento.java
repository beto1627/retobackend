package pe.bbvacontinental.util;

import java.math.BigDecimal;
import java.util.Date;

public abstract class Elemento {
	
    private String indDel;
    
    private String indDelFiltro;
    
    private String codUsucrea;
    
    private String dirIpusucrea;
    
    private Date fecCrea;
    
    private String codUsumodif;
    
    private String dirIpusumodif;
    
    private Date fecModif;
    
    private Integer numItem;//Numero secuencial en la capa de presentacion
    
	public String getIndDel() {
		return indDel;
	}

	public void setIndDel(String indDel) {
		this.indDel = indDel;
	}

	public String getCodUsucrea() {
		return codUsucrea;
	}

	public void setCodUsucrea(String codUsucrea) {
		this.codUsucrea = codUsucrea;
	}

	public String getDirIpusucrea() {
		return dirIpusucrea;
	}

	public void setDirIpusucrea(String dirIpusucrea) {
		this.dirIpusucrea = dirIpusucrea;
	}

	public Date getFecCrea() {
		return fecCrea;
	}

	public void setFecCrea(Date fecCrea) {
		this.fecCrea = fecCrea;
	}

	public String getCodUsumodif() {
		return codUsumodif;
	}

	public void setCodUsumodif(String codUsumodif) {
		this.codUsumodif = codUsumodif;
	}

	public String getDirIpusumodif() {
		return dirIpusumodif;
	}

	public void setDirIpusumodif(String dirIpusumodif) {
		this.dirIpusumodif = dirIpusumodif;
	}

	public Date getFecModif() {
		return fecModif;
	}

	public void setFecModif(Date fecModif) {
		this.fecModif = fecModif;
	}

	public Integer getNumItem() {
		return numItem;
	}

	public void setNumItem(Integer numItem) {
		this.numItem = numItem;
	}
	
	protected boolean equals(String p1, String p2){
		if(p1==null && p2!=null)return false;
		if(p2==null && p1!=null)return false;
		if(p1==null && p2==null)return true;
		if(p1.trim().equalsIgnoreCase(p2.trim()))return true;
		return false;
	}
	
	protected boolean equals(BigDecimal p1, BigDecimal p2){
		if(p1==null && p2!=null)return false;
		if(p2==null && p1!=null)return false;
		if(p1==null && p2==null)return true;
		if(p1.compareTo(p2)==0)return true;
		return false;
	}

	public String getIndDelFiltro() {
		return indDelFiltro;
	}

	public void setIndDelFiltro(String indDelFiltro) {
		this.indDelFiltro = indDelFiltro;
	}

}
