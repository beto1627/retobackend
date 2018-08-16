package pe.bbvacontinental.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class MensajeBean
  implements Serializable
{
  private static final long serialVersionUID = -3644684404287174653L;
  private String mensajeerror = "";
  private String mensajesol = "";
  private boolean error;
  private List errorDetail;
  private Map data;
  
  public void setMensajeerror(String mensajeerror)
  {
    this.mensajeerror = mensajeerror;
  }
  
  public String getMensajeerror()
  {
    return this.mensajeerror;
  }
  
  public void setMensajesol(String mensajesol)
  {
    this.mensajesol = mensajesol;
  }
  
  public String getMensajesol()
  {
    return this.mensajesol;
  }
  
  public void setError(boolean error)
  {
    this.error = error;
  }
  
  public boolean isError()
  {
    return this.error;
  }
  
  public List getErrorDetail()
  {
    return this.errorDetail;
  }
  
  public void setErrorDetail(List errorDetail)
  {
    this.errorDetail = errorDetail;
  }
  
  public Map getData()
  {
    return this.data;
  }
  
  public void setData(Map data)
  {
    this.data = data;
  }
}
