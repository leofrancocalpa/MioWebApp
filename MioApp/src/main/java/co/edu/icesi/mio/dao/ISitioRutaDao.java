package co.edu.icesi.mio.dao;

import java.util.List;

import co.edu.icesi.mio.model.Tmio1SitiosRuta;

public interface ISitioRutaDao {
	
	void save(Tmio1SitiosRuta sitioRuta);
	void update(Tmio1SitiosRuta sitioRuta);
	void delete(Tmio1SitiosRuta sitioRuta);
	List<Tmio1SitiosRuta> findAll();

}
