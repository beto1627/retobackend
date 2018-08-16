package pe.bbvacontinental.dao;

import java.util.List;

import pe.bbvacontinental.model.Catalogo;

public interface CatalogoDAO {
	public List<Catalogo> findByParameter(Catalogo catalogo);
}
