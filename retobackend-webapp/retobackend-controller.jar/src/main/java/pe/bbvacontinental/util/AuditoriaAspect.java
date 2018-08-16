package pe.bbvacontinental.util;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;


@Aspect
public class AuditoriaAspect {

    private static final Log log = LogFactory.getLog(AuditoriaAspect.class);
    private String ipDefault = "0.0.0.0";
    private long milliSecondsOffset = 0;
    
    @Before("execution(* pe.bbvacontinental.model.dao..*insertar*(..)) && args(elemento,..)")
    public void procesarInsercionAuditoria(Elemento elemento) {
    	log.debug("========procesarInsercionAuditoria=========");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        elemento.setIndDel(Constantes.REGISTRO_NO_ELIMINADO);
        try {
            String ip = request.getRemoteAddr();
            if (!StringUtils.hasText(elemento.getDirIpusucrea())) {
                elemento.setDirIpusucrea(ip);                
            }
        } catch (Exception e) {
            elemento.setDirIpusucrea(ipDefault);
            log.warn(e);
        }
        Timestamp fecCrea = new Timestamp(obtenerFechaHoraActual().getTime());
        elemento.setFecCrea(fecCrea);
        try {
        	 UsuarioBean usuarioBean = (UsuarioBean) WebUtils.getSessionAttribute(request, "usuarioBean");
        	 elemento.setCodUsucrea(usuarioBean.getLogin());
		} catch (Exception e) {
			if (!StringUtils.hasText(elemento.getCodUsucrea())) {
				log.error(e);
	            throw new MaestrosException("Nombre de usuario de creación es obligatorio, verifique.");
	        }
		}
        
    }
    
    @Before("(execution(* pe.bbvacontinental.model.dao..*actualizar*(..)) || execution(* pe.bbvacontinental.model.dao..*eliminar*(..))) && args(elemento,..)")
    public void procesarActualizacionAuditoria(Elemento elemento) {
    	log.debug("========procesarActualizacionAuditoria=========");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        try {
            String ip = request.getRemoteAddr();
            if (!StringUtils.hasText(elemento.getDirIpusumodif())) {
                elemento.setDirIpusumodif(ip);                
            }
        } catch (Exception e) {
            elemento.setDirIpusumodif(ipDefault);
            log.warn(e);
        }
        Timestamp fecModif = new Timestamp(obtenerFechaHoraActual().getTime());
        elemento.setFecModif(fecModif);
        try {
            UsuarioBean usuarioBean = (UsuarioBean) WebUtils.getSessionAttribute(request, "usuarioBean");
            elemento.setCodUsumodif(usuarioBean.getLogin());
        }catch (Exception e) {
            if (!StringUtils.hasText(elemento.getCodUsumodif())) {
            	log.error(e);
                throw new MaestrosException("Nombre de usuario de modificacion es obligatorio, verifique.");
            }
        }
        
    }
    
    public Date obtenerFechaHoraActual() {
	    return new Date(System.currentTimeMillis() + milliSecondsOffset);
	}
}

