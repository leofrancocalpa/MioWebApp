package co.edu.icesi.mio.delegate;

import java.time.LocalDate;

import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServicioPK;

public interface ServiceDelegate {

	public Tmio1Servicio addService(Tmio1Servicio service);
	public Tmio1Servicio updateServicio(Tmio1Servicio servicio);
	public void deleteService(Tmio1ServicioPK id);
	public Tmio1Servicio getService(String id);
	public Tmio1Servicio findByHashCode(int hashCode);
	public Iterable<Tmio1Servicio> findAll();
	public Iterable<Tmio1Servicio> findByDate(LocalDate fechaInicio, LocalDate fechaFin);
}
