package co.edu.icesi.mio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.icesi.mio.repositories.UserRepository;


@Controller
public class IndexController {
	
	@Autowired
	UserRepository repo;
	
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    


}
