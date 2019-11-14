package co.edu.icesi.mio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.icesi.mio.model.Tmio1Ruta;

public interface RutasRepository extends CrudRepository<Tmio1Ruta, Integer> {
	List<Tmio1Ruta> findAll();
	
}
