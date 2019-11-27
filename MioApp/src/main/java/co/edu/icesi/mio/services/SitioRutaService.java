package co.edu.icesi.mio.services;

import java.util.List;

import co.edu.icesi.mio.model.Tmio1SitiosRuta;

public interface SitioRutaService {
	
	public boolean save(Tmio1SitiosRuta sitiosRuta) throws Exception;
	public boolean update(Tmio1SitiosRuta sitiosRuta) throws Exception;
	public boolean delete(Tmio1SitiosRuta sitiosRuta) throws Exception;
	public Tmio1SitiosRuta findById();
	public Tmio1SitiosRuta findByHashCode(int hashcode);
	public List<Tmio1SitiosRuta> findAll();

}
