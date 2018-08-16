package pe.bbvacontinental.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UsuarioBean
  implements Serializable
{
  private String id = "";
  private String ticket = "";
  private String login = "";
  private String correo = "";
  private String nombres = "";
  private String apePaterno = "";
  private String apeMaterno = "";
  private String nombreCompleto = "";
  private String nroRegistro = "";
  private String codUO = "";
  private String desUO = "";
  private String codCate = "";
  private String desCate = "";
  private short nivelUO = 0;
  private String numRUC = "";
  private String usuarioSOL = "";
  private String codDepend = "";
  private String idCelular;
  private String codTOpeComer = "";
  private Map map;
  private static final long serialVersionUID = -6214534626139219912L;
  
  public UsuarioBean()
  {
    this.map = new HashMap();
  }
  
  /**
   * @deprecated
   */
  public String getId()
  {
    return this.id;
  }
  
  /**
   * @deprecated
   */
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getTicket()
  {
    return this.ticket;
  }
  
  public void setTicket(String ticket)
  {
    this.ticket = ticket;
  }
  
  public String getApeMaterno()
  {
    return this.apeMaterno;
  }
  
  public void setApeMaterno(String apeMaterno)
  {
    this.apeMaterno = apeMaterno;
  }
  
  public String getApePaterno()
  {
    return this.apePaterno;
  }
  
  public void setApePaterno(String apePaterno)
  {
    this.apePaterno = apePaterno;
  }
  
  public String getCodCate()
  {
    return this.codCate;
  }
  
  public void setCodCate(String codCate)
  {
    this.codCate = codCate;
  }
  
  public String getCodUO()
  {
    return this.codUO;
  }
  
  public void setCodUO(String codUO)
  {
    this.codUO = codUO;
  }
  
  public String getCorreo()
  {
    return this.correo;
  }
  
  public void setCorreo(String correo)
  {
    this.correo = correo;
  }
  
  public String getDesCate()
  {
    return this.desCate;
  }
  
  public void setDesCate(String desCate)
  {
    this.desCate = desCate;
  }
  
  public String getDesUO()
  {
    return this.desUO;
  }
  
  public void setDesUO(String desUO)
  {
    this.desUO = desUO;
  }
  
  public String getLogin()
  {
    return this.login;
  }
  
  public void setLogin(String login)
  {
    this.login = login;
  }
  
  public short getNivelUO()
  {
    return this.nivelUO;
  }
  
  public void setNivelUO(short nivelUO)
  {
    this.nivelUO = nivelUO;
  }
  
  public String getNombreCompleto()
  {
    return this.nombreCompleto;
  }
  
  public void setNombreCompleto(String nombreCompleto)
  {
    this.nombreCompleto = nombreCompleto;
  }
  
  public String getNombres()
  {
    return this.nombres;
  }
  
  public void setNombres(String nombres)
  {
    this.nombres = nombres;
  }
  
  public String getNroRegistro()
  {
    return this.nroRegistro;
  }
  
  public void setNroRegistro(String nroRegistro)
  {
    this.nroRegistro = nroRegistro;
  }
  
  public String getVisibilidad()
  {
    return this.nivelUO > 0 ? getCodUO().substring(0, this.nivelUO + 1).concat("%") : "%";
  }
  
  public String getCodDepend()
  {
    return this.codDepend;
  }
  
  public void setCodDepend(String codDepend)
  {
    this.codDepend = codDepend;
  }
  
  public String getNumRUC()
  {
    return this.numRUC;
  }
  
  public void setNumRUC(String numRUC)
  {
    this.numRUC = numRUC;
  }
  
  public String getUsuarioSOL()
  {
    return this.usuarioSOL;
  }
  
  public void setUsuarioSOL(String usuarioSOL)
  {
    this.usuarioSOL = usuarioSOL;
  }
  
  public String getIdCelular()
  {
    return this.idCelular;
  }
  
  public void setIdCelular(String idCelular)
  {
    this.idCelular = idCelular;
  }
  
  public Map getMap()
  {
    return this.map;
  }
  
  public void setMap(Map map)
  {
    this.map = map;
  }
  
  public String getCodTOpeComer()
  {
    return this.codTOpeComer;
  }
  
  public void setCodTOpeComer(String codTOpeComer)
  {
    this.codTOpeComer = codTOpeComer;
  }
}
