package co.edu.icesi.mio.dao;

import java.time.LocalDate;
import java.util.List;

import co.edu.icesi.mio.model.Tmio1Conductore;
import co.edu.icesi.mio.model.Tmio1Ruta;
import co.edu.icesi.mio.model.Tmio1Servicio;

public interface IServicioDao {
	
	void save(Tmio1Servicio servicio);
	void delete(Tmio1Servicio servicio);
	void update(Tmio1Servicio servicio);
	List<Tmio1Conductore> conductoresConServiciosVigentes( LocalDate fecha);
	List<Tmio1Ruta> rutasConServiciosVigentes(LocalDate fecha);

}
