package co.edu.icesi.mio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.mio.model.Tmio1Sitio;
import co.edu.icesi.mio.services.SitioService;

@Controller
public class SitiosController {
	
	@Autowired
	private SitioService sitioService;
	
	@GetMapping("/admin/add/sitio")
	public String addSitio(Model model) {
		
		Tmio1Sitio sitio = new Tmio1Sitio();
		model.addAttribute("sitio", sitio);
		
		return "add/addsitio";
	}
	
	@PostMapping("/admin/add/sitio")
	public String saveSitio(@Valid Tmio1Sitio sitio, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel")) {
			if(bindingResult.hasErrors()) {
				return "add/addsitio";
			}
		}
		if (action.equals("Cancel")) {
			return "redirect:/";
		}
		try {
			sitioService.save(sitio);
			System.out.println("Sitio save >> "+sitio.getNombre());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@GetMapping("/app/sitios")
	public String indexSitios(Model model) {
		model.addAttribute("sitios", sitioService.findAll());
		return "search/sitios";
	}
	
	@GetMapping("/app/search/sitio/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Tmio1Sitio sitio = sitioService.findById(id);
		model.addAttribute("sitio", sitio);
		
		return "search/sitio";
	}
	
	@PostMapping("/admin/update/sitio")
	public String updateSitio(@Valid Tmio1Sitio sitio , BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel")) {
			if(bindingResult.hasErrors()) {
				return "add/addsitio";
			}
		}
		if (action.equals("Cancel")) {
			return "redirect:/app/sitios";
		}
		return "redirect:/app/sitios";
	}

}
