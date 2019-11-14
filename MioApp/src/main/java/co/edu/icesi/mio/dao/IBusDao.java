package co.edu.icesi.mio.dao;

import java.math.BigDecimal;
import java.util.List;

import co.edu.icesi.mio.model.Tmio1Bus;

public interface IBusDao {
	
	void save(Tmio1Bus bus);
	void delete(Tmio1Bus bus);
	void update(Tmio1Bus bus);
	Tmio1Bus findById(Integer id);
	Tmio1Bus buscarPorPlaca(String placa);
	List<Tmio1Bus> buscarPorModelo(BigDecimal modelo);
	List<Tmio1Bus> buscarPorMarca(String marca);
	List<Tmio1Bus> findAll();

}
