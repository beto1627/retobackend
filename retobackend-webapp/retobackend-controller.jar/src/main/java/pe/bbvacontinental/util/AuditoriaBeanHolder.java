package pe.bbvacontinental.util;

import java.sql.Timestamp;

public class AuditoriaBeanHolder {

	private static ThreadLocal<AuditoriaBean> tLocal = new ThreadLocal<AuditoriaBean>();

	public static void set(AuditoriaBean envioBean) {
		tLocal.set(envioBean);
	}

	public static void set(Timestamp fecCrea, Timestamp fecModif, String codUsucrea, String codUsumodif,
			String dirIpusucrea, String dirIpusumodif) {

		AuditoriaBean auditoriaBean = new AuditoriaBean();
		auditoriaBean.setFecCrea(fecCrea);
		auditoriaBean.setFecModif(fecModif);
		auditoriaBean.setCodUsucrea(codUsucrea);
		auditoriaBean.setCodUsumodif(codUsumodif);
		auditoriaBean.setDirIpusucrea(dirIpusucrea);
		auditoriaBean.setDirIpusumodif(dirIpusumodif);
		tLocal.set(auditoriaBean);
	}

	public static AuditoriaBean get() {
		return (AuditoriaBean) tLocal.get();
	}
}