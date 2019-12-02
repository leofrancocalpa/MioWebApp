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

import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.services.BusService;

@Controller
public class BusController {
	
	@Autowired
	private BusService busService;
	
	@GetMapping("/admin/add/bus")
	public String addBus(Model model) {
		Tmio1Bus newBus = new Tmio1Bus();
		System.out.println(newBus.getId());
		model.addAttribute("bus", newBus);
		return "add/addbus";
	}
	
	@PostMapping("/admin/add/bus")
	public String saveBus(@Valid Tmio1Bus bus, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {

		if (!action.equals("Cancel")) {
			if(bindingResult.hasErrors()) {
				return "add/addbus";
			}
		}
		if (action.equals("Cancel")) {
			return "redirect:/apps/buses";
		}
		try {
			System.out.println("Id "+bus.getId());
			System.out.println("Guardo bus:: Id "+bus.getId());
			busService.save(bus);
		} catch (Exception e) {
			System.out.println(e.getMessage()+" Error <<<< ");
			return "redirect:/admin/add/bus";
		}
		return "redirect:/app/buses";
	}
	
	@GetMapping("/app/buses")
	public String indexBuses(Model model) {
		model.addAttribute("buses", busService.findAll());
		return "search/buses";
	}
	
	@GetMapping("/app/search/bus/{id}")
	public String showInfoForm(@PathVariable("id") int id, Model model) {
		Tmio1Bus bus = busService.findById(id);
		if (bus == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);
		model.addAttribute("bus", bus);
		return "search/bus";
	}
	
	@GetMapping("/admin/update/bus/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model ) {
		Tmio1Bus bus = busService.findById(id);
		if (bus == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);
		model.addAttribute("bus", bus);
		return "update/updatebus";
	}
	
	@PostMapping("/admin/update/bus")
	public String showUpdateForm1(Model model, @Valid Tmio1Bus bus,
			@RequestParam(value = "action", required = true) String action) {
		if (bus == null)
			throw new IllegalArgumentException("Invalid user Id:");
		System.out.println(bus.getMarca()+" ::: "+bus.getPlaca());
		if(action.equals("Cancel")) {
			return "redirect:/app/buses";
		}
		model.addAttribute("bus", bus);
		return "update/updatebus";
	}
	
	@PostMapping("/admin/update/bus1")
	public String updateBus(@Valid Tmio1Bus bus, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {

		if (!action.equals("Cancel")) {
			if(bindingResult.hasErrors()) {
				return "update/updatebus";
			}
		}
		if (action.equals("Cancel")) {
			return "redirect:/app/buses";
		}
		busService.updateBus(bus);
		return "redirect:/app/buses";
	}
	
	@GetMapping("/admin/del/bus/{id}")
	public String delete(@PathVariable("id") int id) {
		busService.deleteBus(id);
		return "redirect:/app/buses";
	}
	

}
