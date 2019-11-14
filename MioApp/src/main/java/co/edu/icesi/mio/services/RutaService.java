package co.edu.icesi.mio.services;

import java.math.BigDecimal;
import java.util.List;

import co.edu.icesi.mio.model.Tmio1Ruta;
import co.edu.icesi.mio.model.Tmio1Servicio;



public interface RutaService {
	
	public boolean save(Tmio1Ruta ruta) throws Exception;
	public boolean createRuta(Integer id, String activa, String descripcion, BigDecimal diaFin, BigDecimal diaInicio, BigDecimal horaFin, BigDecimal horaInicio, String numero, List<Tmio1Servicio> tmio1Servicios) throws Exception;
	public Tmio1Ruta updateRuta(Tmio1Ruta ruta);
	public boolean deleteRuta(Integer id);
	public Tmio1Ruta getRuta(Integer id);
	public List<Tmio1Ruta> findAll();
	List<Tmio1Ruta> inicioDespuesDe(BigDecimal horaInicio);
	List<Tmio1Ruta> inicioAntesDe(BigDecimal horaInicio);
	List<Tmio1Ruta> terminanDespuesDe(BigDecimal horaFin);
	List<Tmio1Ruta> terminanAntesDe(BigDecimal horaFin);
	List<Tmio1Ruta> horarioEntre(BigDecimal horaInicio,BigDecimal horaFin);
	List<Tmio1Ruta> diaInicio(BigDecimal diaInicio);
	List<Tmio1Ruta> diaFin(BigDecimal diaFin);
	List<Tmio1Ruta> diasEntre(BigDecimal diaInicio,BigDecimal diaFin);

}
