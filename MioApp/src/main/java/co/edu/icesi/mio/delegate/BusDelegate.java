package co.edu.icesi.mio.delegate;

import java.math.BigDecimal;
import java.util.List;

import co.edu.icesi.mio.model.Tmio1Bus;

public interface BusDelegate {
	
	public Tmio1Bus addBus(Tmio1Bus bus);
	public Iterable<Tmio1Bus> findAll();
	public void deleteBus(Tmio1Bus bus);
	public Tmio1Bus findById(Integer id);
	public Tmio1Bus updateBus(Tmio1Bus bus);
	
	public Tmio1Bus buscarPorPlaca(String placa);
	public List<Tmio1Bus> buscarPorModelo(BigDecimal modelo);
	public List<Tmio1Bus> buscarPorMarca(String marca);

}
