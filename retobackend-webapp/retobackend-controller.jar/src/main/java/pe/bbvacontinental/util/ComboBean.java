package pe.bbvacontinental.util;

public class ComboBean {
	public static final ComboBean TODOS = new ComboBean("", "--- TODOS ---");
    
    public static final ComboBean NINGUNO = new ComboBean("", "--- NINGUNO ---");
    
    public static final ComboBean SELECCIONE = new ComboBean("", "--- SELECCIONE ---");
    
    public static final ComboBean ELEGIR = new ComboBean("", "--- ELEGIR ---");
    
	private String codigo;
	private String descripcion;
	
	public ComboBean(){}
	public ComboBean(String codigo, String descripcion){
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
