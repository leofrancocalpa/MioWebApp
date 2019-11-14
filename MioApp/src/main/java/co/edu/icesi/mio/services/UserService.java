package co.edu.icesi.mio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.mio.model.UserApp;
import co.edu.icesi.mio.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<UserApp> findByUsername(String username){
		System.out.println("<<>>> "+userRepository.findByUsername(username));
		return userRepository.findByUsername(username);
	}

}
