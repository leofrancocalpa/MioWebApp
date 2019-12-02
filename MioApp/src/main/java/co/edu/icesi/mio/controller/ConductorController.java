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

import co.edu.icesi.mio.model.Tmio1Conductore;
import co.edu.icesi.mio.services.ConductorService;

@Controller
public class ConductorController {
	
	@Autowired
	private ConductorService conductorService;
	
	@GetMapping("/admin/add/driver")
	public String addConductor(Model model) {
		Tmio1Conductore cond = new Tmio1Conductore();
		System.out.println(cond.getCedula());
		model.addAttribute("conductor", cond);
		return "add/addconductor";
	}
	
	@PostMapping("/admin/add/driver")
	public String saveConductor(Tmio1Conductore cond, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		if (!action.equals("Cancel")) {
			if(bindingResult.hasErrors()) {
				System.out.println("Binding Errors::: "+bindingResult.getErrorCount());
				
				model.addAttribute("conductor", cond);
				return "add/addconductor";
			}
		}
		if (action.equals("Cancel")) {
			return "redirect:/app/drivers";
		}
		try {
			System.out.println("Id "+cond.getCedula());
			System.out.println("Guardo bus:: Id "+cond.getCedula()+conductorService.save(cond));
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage()+" Error <<<<");
			return "redirect:/admin/add/bus";
		}
//		System.out.println(busService.findAll().get(0));
		return "redirect:/app/drivers";
	}
	
	@GetMapping("/app/drivers")
	public String indexConductores(Model model) {
		model.addAttribute("conductores", conductorService.findAll());
		return "search/conductores";
	}
	
	@GetMapping("/app/search/driver/{id}")
	public String showInfoForm(@PathVariable("id") String id, Model model) {
		Tmio1Conductore conductor = conductorService.getConductor(id);
		if (conductor == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);
		model.addAttribute("conductor", conductor);
		return "search/conductor";
	}
	
	@GetMapping("/admin/update/driver/{id}")
	public String showUpdateForm(@PathVariable("id") String id, Model model) {
		Tmio1Conductore conductor = conductorService.getConductor(id);
		if (conductor == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);
		model.addAttribute("conductor", conductor);
		return "update/updateconductor";
	}
	
	@PostMapping("/admin/update/driver")
	public String showUpdateForm1(@Valid Tmio1Conductore conductor, Model model,
			@RequestParam(value = "action", required = true) String action) {
		if (conductor == null)
			throw new IllegalArgumentException("Invalid user Id:");
		
		if(action.equals("Cancel")) {
			return "redirect:/app/drivers";
		}
		model.addAttribute("conductor", conductor);
		return "update/updateconductor";
	}
	
	@PostMapping("/admin/update/driver1")
	public String updateRuta(@Valid Tmio1Conductore conductor, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {

		if (!action.equals("Cancel")) {
			if(bindingResult.hasErrors()) {
				return "update/updateconductor";
			}
		}
		if (action.equals("Cancel")) {
			return "redirect:/app/drivers";
		}
		conductorService.updateConductor(conductor);
		return "redirect:/app/drivers";
	}
	
	@GetMapping("/admin/del/driver/{id}")
	public String delete(@PathVariable("id") String id) {
		conductorService.deleteConductor(id);
		
		return "redirect:/app/drivers";
	}

}
