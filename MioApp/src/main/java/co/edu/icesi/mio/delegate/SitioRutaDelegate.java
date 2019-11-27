package co.edu.icesi.mio.delegate;

import co.edu.icesi.mio.model.Tmio1SitiosRuta;

public interface SitioRutaDelegate {
	
	public Tmio1SitiosRuta addSitioRuta(Tmio1SitiosRuta sitiosRuta);
	public void update(Tmio1SitiosRuta sitiosRuta);
	public void delete(Tmio1SitiosRuta sitiosRuta);
	public Tmio1SitiosRuta findById();
	public Tmio1SitiosRuta findByHashCode(int hashcode);
	public Iterable<Tmio1SitiosRuta> findAll();

}
