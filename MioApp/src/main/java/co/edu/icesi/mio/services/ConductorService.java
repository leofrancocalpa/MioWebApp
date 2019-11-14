package co.edu.icesi.mio.services;

import java.time.LocalDate;
import java.util.List;

import co.edu.icesi.mio.model.Tmio1Conductore;
import co.edu.icesi.mio.model.Tmio1Servicio;



public interface ConductorService {
	
	public boolean save(Tmio1Conductore conductor) throws Exception;
	public boolean createConductor(String cedula, String apellidos, LocalDate fechaContratacion, LocalDate fechaNacimiento, String nombre, List<Tmio1Servicio> tmio1Servicios) throws Exception;
	public Tmio1Conductore updateConductor(Tmio1Conductore conductor);
	public boolean deleteConductor(String id);
	public Tmio1Conductore getConductor(String id);
	public List<Tmio1Conductore> findByName(String name);
	public List<Tmio1Conductore> findByLastName(String lastName);
	public List<Tmio1Conductore> findAll();
}
