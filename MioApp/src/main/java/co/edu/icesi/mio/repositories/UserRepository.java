package co.edu.icesi.mio.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.icesi.mio.model.UserApp;


public interface UserRepository extends CrudRepository<UserApp, String>{
	
	Optional<UserApp> findByUsername(String username);
	
	
}
