package co.edu.icesi.mio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServicioPK;
import co.edu.icesi.mio.services.BusService;
import co.edu.icesi.mio.services.ConductorService;
import co.edu.icesi.mio.services.RutaService;
import co.edu.icesi.mio.services.ServicioService;

@Controller
public class ServicioController {

	@Autowired
	private ServicioService servService;
	@Autowired
	private BusService busService;
	@Autowired
	private RutaService rutaService;
	@Autowired
	private ConductorService conductorService;

	@GetMapping("/operator/add/service")
	public String addService(Model model) {
		Tmio1ServicioPK serPk = new Tmio1ServicioPK();
		model.addAttribute("buses", busService.findAll());
		model.addAttribute("rutas", rutaService.findAll());
		model.addAttribute("conductores", conductorService.findAll());
		model.addAttribute("servicioPK", serPk);

		return "add/addservice";
	}

	@PostMapping("/operator/add/service")
	public String saveService(@Valid Tmio1ServicioPK servPK, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model model) {

		Tmio1Servicio serv = new Tmio1Servicio();
		serv.setId(servPK);
		serv.setTmio1Bus(busService.findById(servPK.getIdBus()));
		serv.setTmio1Conductore(conductorService.getConductor(servPK.getCedulaConductor()));
		servPK.setHash(servPK.hashCode());
		serv.setTmio1Ruta(rutaService.getRuta(servPK.getIdRuta()));
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				System.out.println(">>> Error binding::" + bindingResult.getErrorCount());
				for (ObjectError e : bindingResult.getAllErrors()) {
					System.out.println(e.getCode());
				}
				model.addAttribute("buses", busService.findAll());
				model.addAttribute("rutas", rutaService.findAll());
				model.addAttribute("conductores", conductorService.findAll());
				model.addAttribute("servicioPK", servPK);
				return "add/addservice";
			}
		}
		if (action.equals("Cancel")) {
			return "redirect:/";
		}
		try {
			servService.save(serv);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage()+" Error <<<< ");
			return "redirect:/operator/add/service";
		}

		return "redirect:/app/services";
	}

	@GetMapping("/app/services")
	public String indexServices(Model model) {
		model.addAttribute("servicioPK", new Tmio1ServicioPK());
		model.addAttribute("servicios", servService.findAll());
		return "search/servicios";
	}

	@GetMapping("/app/services/filtr")
	public String searchServices(Tmio1ServicioPK servPK, Model model) {
		model.addAttribute("servicioPK", new Tmio1ServicioPK());
		model.addAttribute("servicios", servService.findByDate(servPK.getFechaInicio(), servPK.getFechaFin()));
		return "search/servicios";
	}

	@GetMapping("/app/search/service/{id}")
	public String showServiceInfo(@PathVariable("id") int id, Model model) {
		Tmio1Servicio serv = servService.findByHashCode(id);
		if (serv == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);
		
		model.addAttribute("servicioPK", serv.getId());
		model.addAttribute("buses", busService.findAll());
		model.addAttribute("rutas", rutaService.findAll());
		model.addAttribute("conductores", conductorService.findAll());
		model.addAttribute("servicio", serv);

		return "search/servicio";
	}

	@GetMapping("/operator/update/service/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Tmio1Servicio serv = servService.findByHashCode(id);
		if (serv == null)
			throw new IllegalArgumentException("Invalid user Id:" + id);
		
		model.addAttribute("servicioPK", serv.getId());
		model.addAttribute("buses", busService.findAll());
		model.addAttribute("rutas", rutaService.findAll());
		model.addAttribute("conductores", conductorService.findAll());
		model.addAttribute("servicio", serv);
		return "search/updateservicio";
	}
	
	@PostMapping("/operator/update/save/service")
	public String updateService(Model model, Tmio1ServicioPK servPK, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action) {
		
		System.out.println(servPK.getHash());
		System.out.println(servPK.hashCode());
		if (action.equals("Cancel")) {
			model.addAttribute("servicioPK", servPK);
			model.addAttribute("buses", busService.findAll());
			model.addAttribute("rutas", rutaService.findAll());
			model.addAttribute("conductores", conductorService.findAll());
			return "redirect:/app/services";
		}
		Tmio1Servicio serv = servService.findByHashCode(servPK.getHash());
		servService.deleteService(serv.getId());
		servPK.setHash(servPK.hashCode());
		serv.setTmio1Bus(busService.findById(servPK.getIdBus()));
		serv.setTmio1Conductore(conductorService.getConductor(servPK.getCedulaConductor()));
		serv.setTmio1Ruta(rutaService.getRuta(servPK.getIdRuta()));
		serv.setId(servPK);
		try {
			servService.save(serv);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage()+" Error <<<< ");
		}
		return "redirect:/app/services";
	}

}
