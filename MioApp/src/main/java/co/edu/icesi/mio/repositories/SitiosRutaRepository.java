package co.edu.icesi.mio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.icesi.mio.model.Tmio1SitiosRuta;
import co.edu.icesi.mio.model.Tmio1SitiosRutaPK;

public interface SitiosRutaRepository extends CrudRepository<Tmio1SitiosRuta, Tmio1SitiosRutaPK>{

	List<Tmio1SitiosRuta> findAll();
}
