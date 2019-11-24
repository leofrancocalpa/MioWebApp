package co.edu.icesi.mio.dao;

import java.util.List;

import co.edu.icesi.mio.model.Tmio1Sitio;

public interface ISitioDao {
	
	void save(Tmio1Sitio sitio);
	void delete(Tmio1Sitio sitio);
	void update(Tmio1Sitio sitio);
	Tmio1Sitio findById(Long id);
	List<Tmio1Sitio> findAll();

}
