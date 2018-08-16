package pe.bbvacontinental.util;

import java.util.Map;

import org.springframework.core.NestedRuntimeException;

public class MaestrosException extends NestedRuntimeException {
	
	private Map<String, Object> errors;
    private static final long serialVersionUID = 1L;

    public MaestrosException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    public MaestrosException(String msg) {
        super(msg);
    }
    
    public MaestrosException(String msg, Throwable cause, Map<String, Object> errors) {
        super(msg, cause);
        this.errors = errors;
    }

    
    public Map<String, Object> getErrors() {
		return errors;
	}

}
