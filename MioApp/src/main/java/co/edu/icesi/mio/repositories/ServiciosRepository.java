package co.edu.icesi.mio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServicioPK;

public interface ServiciosRepository extends CrudRepository<Tmio1Servicio, Tmio1ServicioPK> {
	List<Tmio1Servicio> findAll();
	
}
