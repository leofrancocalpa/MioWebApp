package co.edu.icesi.mio.delegate;

import co.edu.icesi.mio.model.Tmio1Ruta;

public interface RutaDelegate {
	public Tmio1Ruta addRuta(Tmio1Ruta ruta);
	public Tmio1Ruta updateRuta(Tmio1Ruta ruta);
	public void deleteRuta(Integer id);
	public Tmio1Ruta findById(Integer id);
	public Iterable<Tmio1Ruta> findAll();
}
