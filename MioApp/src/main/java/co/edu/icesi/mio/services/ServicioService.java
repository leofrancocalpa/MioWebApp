package co.edu.icesi.mio.services;

import java.time.LocalDate;
import java.util.List;

import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.model.Tmio1Conductore;
import co.edu.icesi.mio.model.Tmio1Ruta;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServicioPK;

public interface ServicioService {
	
	public boolean save(Tmio1Servicio service) throws Exception;
	public boolean save(Tmio1Servicio service, Tmio1Bus bus, Tmio1Conductore conductor, Tmio1Ruta ruta) throws Exception;
	public boolean createServicio(String Id, Tmio1Bus bus, Tmio1Conductore conductor, Tmio1Ruta ruta) throws Exception;
	public Tmio1Servicio updateServicio(Tmio1Servicio servicio);
	public boolean deleteService(Tmio1Servicio id);
	public Tmio1Servicio getService(String id);
	public Tmio1Servicio findByHashCode(int hashCode);
	public List<Tmio1Servicio> findAll();
	public List<Tmio1Servicio> findByDate(LocalDate fechaInicio, LocalDate fechaFin);
}
