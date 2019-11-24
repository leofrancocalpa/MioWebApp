package co.edu.icesi.mio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.icesi.mio.model.Tmio1Sitio;

public interface SitiosRepository extends CrudRepository<Tmio1Sitio, Long>{
	
	List<Tmio1Sitio> findAll();

}
