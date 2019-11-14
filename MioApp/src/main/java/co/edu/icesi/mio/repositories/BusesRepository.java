package co.edu.icesi.mio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.icesi.mio.model.Tmio1Bus;


public interface BusesRepository extends CrudRepository<Tmio1Bus, Integer> {
	
	List<Tmio1Bus> findAll();
	
}
