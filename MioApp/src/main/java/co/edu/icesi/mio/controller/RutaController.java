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

import co.edu.icesi.mio.model.Tmio1Ruta;
import co.edu.icesi.mio.services.RutaService;

@Controller
public class RutaController {
	
	@Autowired
	private RutaService rutaService;
	
	@GetMapping("/admin/add/route")
	public String addBus(Model model) {
		Tmio1Ruta newRuta = new Tmio1Ruta();
		System.out.println(">>>new Ruta to added "+newRuta.getId());
		model.addAttribute("ruta", newRuta);
		
		return "add/addruta";
	}
	
	@PostMapping("/admin/add/route")
	public String saveBus(@Valid Tmio1Ruta ruta, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		
		System.out.println(ruta);
		if (!action.equals("Cancel")) {
			if(bindingResult.hasErrors()) {
				model.addAttribute("ruta", ruta);

				return "add/addruta";
			}
		}
		if (action.equals("Cancel")) {
			return "redirect:/";
		}
		try {
			System.out.println("Id "+ruta.getId());
			System.out.println("Guardo RUTA:: Id "+ruta.getId()+rutaService.save(ruta));
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage()+" Error <<<<");
			return "redirect:/admin/add/route";
		}
		return "redirect:/";
	}
	
	@GetMapping("/app/routes")
	public String indexBuses(Model model) {
		model.addAttribute("rutas", rutaService.findAll());
		return "search/rutas";
	}
	
	@GetMapping("/app/search/route/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Tmio1Ruta ruta = rutaService.getRuta(id);
		if (ruta == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);
		model.addAttribute("ruta", ruta);
		return "search/ruta";
	}
	
	@PostMapping("/admin/update/route")
	public String updateRuta(@Valid Tmio1Ruta bus, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {

		if (!action.equals("Cancel")) {
			if(bindingResult.hasErrors()) {
				return "add/addbus";
			}
		}
		if (action.equals("Cancel")) {
			return "redirect:/app/routes";
		}
		return "redirect:/";
	}

}
