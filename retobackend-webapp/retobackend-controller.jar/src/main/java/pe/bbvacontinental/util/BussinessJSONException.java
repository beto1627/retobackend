package pe.bbvacontinental.util;

import org.springframework.core.NestedRuntimeException;

public class BussinessJSONException  extends NestedRuntimeException {
	 private static final long serialVersionUID = 1L;

	    public BussinessJSONException(String msg, Throwable cause) {
	        super(msg, cause);
	    }
	    
	    public BussinessJSONException(String msg) {
	        super(msg);
	    }
}
