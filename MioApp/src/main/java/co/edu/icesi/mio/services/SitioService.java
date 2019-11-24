package co.edu.icesi.mio.services;

import java.util.List;

import co.edu.icesi.mio.model.Tmio1Sitio;

public interface SitioService {
	
	public boolean save(Tmio1Sitio sitio) throws Exception;
	public boolean delete(Tmio1Sitio sitio) throws Exception;
	public Tmio1Sitio update(Tmio1Sitio sitio) throws Exception;
	public Tmio1Sitio findById(Long id);
	public List<Tmio1Sitio> findAll();

}
