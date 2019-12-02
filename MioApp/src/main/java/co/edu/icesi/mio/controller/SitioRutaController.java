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

import co.edu.icesi.mio.model.Tmio1SitiosRuta;
import co.edu.icesi.mio.model.Tmio1SitiosRutaPK;
import co.edu.icesi.mio.services.RutaService;
import co.edu.icesi.mio.services.SitioRutaService;
import co.edu.icesi.mio.services.SitioService;

@Controller
public class SitioRutaController {
	
	@Autowired
	private RutaService rutaService;
	@Autowired
	private SitioService sitioService;

	@Autowired
	private SitioRutaService sitioRutaService;
	
	@GetMapping("/admin/add/sitio-ruta")
	public String addSitio(Model model) {
		Tmio1SitiosRutaPK sitioRutaPK = new Tmio1SitiosRutaPK();
		model.addAttribute("sitiorutaPK", sitioRutaPK);
		model.addAttribute("rutas", rutaService.findAll());
		model.addAttribute("sitios", sitioService.findAll());
		
		return "add/addsitioruta";
	}
	
	@PostMapping("/admin/add/sitio-ruta")
	public String saveSitioRuta(@Valid Tmio1SitiosRutaPK sitioRutaPK, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {
		Tmio1SitiosRuta sitioRuta = new Tmio1SitiosRuta();
		sitioRuta.setId(sitioRutaPK);
		sitioRuta.setTmio1Ruta1(rutaService.getRuta(sitioRutaPK.getIdRuta()));
		sitioRuta.setTmio1Sitio1(sitioService.findById(sitioRutaPK.getIdSitio()));
		sitioRutaPK.setHash(sitioRuta.hashCode());
		
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("sitiorutaPK", sitioRutaPK);
				model.addAttribute("rutas", rutaService.findAll());
				model.addAttribute("sitios", sitioService.findAll());
				return "add/addsitioruta";
			}
			
		}
		if (action.equals("Cancel")) {
			return "redirect:/";
		}
		try {
			sitioRutaService.save(sitioRuta);
			System.out.println("Sitio-ruta added >> "+sitioRuta.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/app/sitios-ruta";
	}
	
	@GetMapping("/app/sitios-ruta")
	public String indexSitiosRuta(Model model) {
		model.addAttribute("sitiosrutas", sitioRutaService.findAll());
		return "search/sitiosrutas";
	}
	
	@GetMapping("/app/search/sitio-ruta/{id}")
	public String showInfoForm(@PathVariable("id") int id, Model model) {
		Tmio1SitiosRuta sitioruta = sitioRutaService.findByHashCode(id);
		if (sitioruta == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);
		model.addAttribute("sitiorutaPK", sitioruta.getId());
		model.addAttribute("rutas", rutaService.findAll());
		model.addAttribute("sitios", sitioService.findAll());
		model.addAttribute("sitioruta", sitioruta);
		return "search/sitioruta";
	}
	
	@GetMapping("/admin/update/sitio-ruta/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Tmio1SitiosRuta sitioruta = sitioRutaService.findByHashCode(id);
		System.out.println(sitioruta+">>>>");
		if (sitioruta == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);
		model.addAttribute("sitiorutaPK", sitioruta.getId());
		model.addAttribute("rutas", rutaService.findAll());
		model.addAttribute("sitios", sitioService.findAll());
		model.addAttribute("sitioruta", sitioruta);
		return "search/updatesitioruta";
	}
	
	@PostMapping("/admin/update/sitio-ruta")
	public String update(Model model, Tmio1SitiosRutaPK sitioRutaPK, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action) {
		
		if (action.equals("Cancel")) {
			
			return "redirect:/app/sitios-ruta";
		}
		Tmio1SitiosRuta sitioRuta = sitioRutaService.findByHashCode(sitioRutaPK.getHash());
		try {
			sitioRutaService.delete(sitioRuta);
			sitioRutaPK.setHash(sitioRutaPK.hashCode());
			sitioRuta.setTmio1Ruta1(rutaService.getRuta(sitioRutaPK.getIdRuta()));
			sitioRuta.setTmio1Sitio1(sitioService.findById(sitioRutaPK.getIdSitio()));
			sitioRuta.setId(sitioRutaPK);
			sitioRutaService.save(sitioRuta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "redirect:/app/sitios-ruta";
	}
	
	@GetMapping("admin/del/sitio-ruta/{id}")
	public String delete(@PathVariable("id") int id) {
		
		try {
			sitioRutaService.delete(sitioRutaService.findByHashCode(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/app/sitios-ruta";
	}
	
	
}
