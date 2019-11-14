package co.edu.icesi.mio.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.model.Tmio1Conductore;
import co.edu.icesi.mio.model.Tmio1Ruta;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServicioPK;
import co.edu.icesi.mio.repositories.BusesRepository;
import co.edu.icesi.mio.repositories.ConductoresRepository;
import co.edu.icesi.mio.repositories.RutasRepository;
import co.edu.icesi.mio.repositories.ServiciosRepository;

@Service
public class ServicioServiceImp implements ServicioService {

	@Autowired
	private ServiciosRepository servicioRepository;
	@Autowired
	private ConductoresRepository conductorRepository;
	@Autowired
	private BusesRepository busRepository;
	@Autowired
	private RutasRepository rutaRepository;

	@Override
	public boolean save(Tmio1Servicio service) throws Exception {
		if (service.getTmio1Bus() == null || service.getTmio1Conductore() == null || service.getTmio1Ruta() == null) {
			throw new Exception("El servicio no puede ser creado con datos nulos");
		}
		if (conductorRepository.findById(service.getTmio1Conductore().getCedula()) == null
				&& busRepository.findById(service.getTmio1Bus().getId()) == null
				&& rutaRepository.findById(service.getTmio1Ruta().getId()) == null) {

			throw new Exception("El Bus o el Conductor o la Ruta no existen");
		} else {
			servicioRepository.save(service);
			return true;
		}
	}

	@Override
	public boolean save(Tmio1Servicio servicio, Tmio1Bus bus, Tmio1Conductore conductor, Tmio1Ruta ruta)
			throws Exception {
		if (bus == null || conductor == null || ruta == null) {
			throw new Exception("El servicio no puede ser creado con datos nulos");
		}
		if (conductorRepository.findById(conductor.getCedula()) == null && busRepository.findById(bus.getId()) == null
				&& rutaRepository.findById(ruta.getId()) == null) {

			throw new Exception("El Bus o el Conductor o la Ruta no existen");
		} else {
			servicio.setTmio1Bus(bus);
			servicio.setTmio1Conductore(conductor);
			servicio.setTmio1Ruta(ruta);
			servicioRepository.save(servicio);
			return true;
		}
	}

	@Override
	public boolean createServicio(String Id, Tmio1Bus bus, Tmio1Conductore conductor, Tmio1Ruta ruta) throws Exception {
		if (bus == null || conductor == null || ruta == null) {
			throw new Exception("El servicio no puede ser creado con datos nulos");
		}
		if (conductorRepository.findById(conductor.getCedula()) == null && busRepository.findById(bus.getId()) == null
				&& rutaRepository.findById(ruta.getId()) == null) {

			throw new Exception("El Bus o el Conductor o la Ruta no existen");
		} else {
			Tmio1Servicio servicio = new Tmio1Servicio();
//			servicio.setID(Id);
			servicio.setTmio1Bus(bus);
			servicio.setTmio1Conductore(conductor);
			servicio.setTmio1Ruta(ruta);
			servicioRepository.save(servicio);
			return true;
		}
	}

	@Override
	public Tmio1Servicio updateServicio(Tmio1Servicio servicio) {
//		servicioRepository.deleteById(servicio.getId());
		servicioRepository.save(servicio);
		return servicio;
	}

	@Override
	public boolean deleteService(Tmio1ServicioPK id) {
		servicioRepository.deleteById(id);
		return true;
	}

	@Override
	public Tmio1Servicio getService(String id) {
//		return servicioRepository.findById(id);
		return null;
	}

	@Override
	public List<Tmio1Servicio> findAll() {
		return servicioRepository.findAll();
	}
	
	@Override
	public Tmio1Servicio findByHashCode(int hashCode) {
		List<Tmio1Servicio> services = servicioRepository.findAll();
		Tmio1Servicio service = null;
		for(Tmio1Servicio serv : services) {
			if(serv.getId().hashCode()==hashCode) {
				System.out.println("Encontrado:::");
				service = serv;
			}
		}
		return service;
	}

	@Override
	public List<Tmio1Servicio> findByDate(LocalDate fechaInicio, LocalDate fechaFin) {
		// TODO Auto-generated method stub
		List<Tmio1Servicio> services = servicioRepository.findAll();
		List<Tmio1Servicio> servicesMatch = new ArrayList<Tmio1Servicio>();

		if (fechaInicio != null && fechaFin != null) {

			for (Tmio1Servicio serv : services) {
				if (serv.getId().getFechaInicio().isEqual(fechaInicio)
						&& serv.getId().getFechaFin().isEqual(fechaFin)) {
					servicesMatch.add(serv);
				}
			}
			return servicesMatch;
		}

		if (fechaInicio != null && fechaFin == null) {

			for (Tmio1Servicio serv : services) {
				if (serv.getId().getFechaInicio().isEqual(fechaInicio)) {
					servicesMatch.add(serv);
				}
			}
			return servicesMatch;
		}
		if (fechaInicio == null && fechaFin != null) {

			for (Tmio1Servicio serv : services) {
				if (serv.getId().getFechaFin().isEqual(fechaFin)) {
					servicesMatch.add(serv);
				}
			}
			return servicesMatch;
		}
		return services;
	}

}