package co.edu.icesi.mio.dao;

import java.math.BigDecimal;
import java.util.List;

import co.edu.icesi.mio.model.Tmio1Ruta;

public interface IRutaDao {
	
	void save(Tmio1Ruta ruta);
	void delete(Tmio1Ruta ruta);
	void update(Tmio1Ruta ruta);
	Tmio1Ruta findById(Integer id);
	List<Tmio1Ruta> inicioDespuesDe(BigDecimal horaInicio);
	List<Tmio1Ruta> inicioAntesDe(BigDecimal horaInicio);
	List<Tmio1Ruta> terminanDespuesDe(BigDecimal horaFin);
	List<Tmio1Ruta> terminanAntesDe(BigDecimal horaFin);
	List<Tmio1Ruta> horarioEntre(BigDecimal horaInicio,BigDecimal horaFin);
	List<Tmio1Ruta> diaInicio(BigDecimal diaInicio);
	List<Tmio1Ruta> diaFin(BigDecimal diaFin);
	List<Tmio1Ruta> diasEntre(BigDecimal diaInicio,BigDecimal diaFin);
	public List<Tmio1Ruta> findAll();

}
