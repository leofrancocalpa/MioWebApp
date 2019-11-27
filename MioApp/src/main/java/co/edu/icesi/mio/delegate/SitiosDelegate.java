package co.edu.icesi.mio.delegate;

import co.edu.icesi.mio.model.Tmio1Sitio;

public interface SitiosDelegate {
	
	public Tmio1Sitio addSitio(Tmio1Sitio sitio);
	public void delete(Tmio1Sitio sitio);;
	public Tmio1Sitio update(Tmio1Sitio sitio);
	public Tmio1Sitio findById(Long id);
	public Iterable<Tmio1Sitio> findAll();

}
