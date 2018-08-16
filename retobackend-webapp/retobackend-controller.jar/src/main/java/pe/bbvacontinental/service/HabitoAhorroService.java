package pe.bbvacontinental.service;

import pe.bbvacontinental.bean.HabitoAhorroBean;
import pe.bbvacontinental.util.MaestrosException;

public interface HabitoAhorroService {
	public void registrarHabito(HabitoAhorroBean habitoAhorroBean) throws MaestrosException;
}
