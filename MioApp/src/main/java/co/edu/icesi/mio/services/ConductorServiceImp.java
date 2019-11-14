package co.edu.icesi.mio.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.IConductorDao;
import co.edu.icesi.mio.model.Tmio1Conductore;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.repositories.ConductoresRepository;



@Service
public class ConductorServiceImp implements ConductorService{

	@Autowired
	private ConductoresRepository conductorRepository;
	
	@Autowired
	private IConductorDao conductorDao;
	
	@Override
	@Transactional(readOnly = false)
	public boolean save(Tmio1Conductore conductor) throws Exception{
		if(conductor.getFechaContratacion().isBefore(conductor.getFechaNacimiento()) || conductor.getFechaContratacion().equals(conductor.getFechaNacimiento())) {
			throw new RuntimeException("La fecha de contratacion debe er mayor a la fecha de nacimiento");
		}
		if(conductor.getFechaNacimiento().isAfter(LocalDate.now())) {
			throw new RuntimeException("fecha nacimiento mayor a fecha actual");
		}
//		conductorRepository.save(conductor);
		conductorDao.save(conductor);
		return true;
	}
	
	@Override
	@Transactional(readOnly = false)
	public boolean createConductor(String cedula, String apellidos, LocalDate fechaContratacion, LocalDate fechaNacimiento,
			String nombre, List<Tmio1Servicio> tmio1Servicios) throws Exception{
		
		if(fechaContratacion.isBefore(fechaNacimiento) || fechaContratacion.equals(fechaNacimiento)) {
			throw new Exception("La fecha de contratacion debe er mayor a la fecha de nacimiento");
		}
		if(fechaNacimiento.isAfter(LocalDate.now())) {
			throw new Exception("fecha nacimiento mayor a fecha actual");
		}
		Tmio1Conductore conductor = new Tmio1Conductore();
		conductor.setCedula(cedula);
		conductor.setApellidos(apellidos);
		conductor.setFechaContratacion(fechaContratacion);
		conductor.setFechaNacimiento(fechaNacimiento);
		conductor.setNombre(nombre);
		conductor.setTmio1Servicios(tmio1Servicios);
		conductor.setTmio1Servicios(tmio1Servicios);
//		conductorRepository.save(conductor);
		conductorDao.save(conductor);
		return true;
	}

	@Override
	@Transactional(readOnly = false)
	public Tmio1Conductore updateConductor(Tmio1Conductore conductor) {
		// TODO Auto-generated method stub
//		conductorRepository.deleteById(conductor.getCedula());
//		conductorRepository.save(conductor);
		conductorDao.update(conductor);
		return conductor;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteConductor(String id) {
		// TODO Auto-generated method stub
//		conductorRepository.deleteById(id);
		conductorDao.delete(conductorDao.findByID(id));
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public Tmio1Conductore getConductor(String id) {
		// TODO Auto-generated method stub
//		return conductorRepository.findById(id).get();
		return conductorDao.findByID(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Tmio1Conductore> findAll(){
//		return conductorRepository.findAll();
		return conductorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tmio1Conductore> findByName(String name) {
		return conductorDao.findByName(name);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tmio1Conductore> findByLastName(String lastName) {
		return conductorDao.findByLastName(lastName);
	}

}
