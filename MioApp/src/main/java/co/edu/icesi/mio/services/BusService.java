package co.edu.icesi.mio.services;

import java.math.BigDecimal;
import java.util.List;

import co.edu.icesi.mio.model.Tmio1Bus;



public interface BusService {
	public boolean save(Tmio1Bus bus) throws Exception;
	public Tmio1Bus updateBus(Tmio1Bus bus);
	public boolean deleteBus(Integer id);
	public Tmio1Bus findById(Integer id);
	public List<Tmio1Bus> findAll();
	public Tmio1Bus buscarPorPlaca(String placa);
	public List<Tmio1Bus> buscarPorModelo(BigDecimal modelo);
	public List<Tmio1Bus> buscarPorMarca(String marca);
}
