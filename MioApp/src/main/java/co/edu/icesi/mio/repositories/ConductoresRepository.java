package co.edu.icesi.mio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.icesi.mio.model.Tmio1Conductore;

public interface ConductoresRepository extends CrudRepository<Tmio1Conductore, String> {
	List<Tmio1Conductore> findAll();
	
}
