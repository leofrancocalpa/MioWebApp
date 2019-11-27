package co.edu.icesi.mio.delegate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import co.edu.icesi.mio.model.Tmio1Bus;

public class BusDelegateImp implements BusDelegate{
	
	RestTemplate restTemplate;
	final String SERVER = "http://localhost:8082/";
	
	public BusDelegateImp() {
		restTemplate = new RestTemplate();
	}

	@Override
	public Tmio1Bus addBus(Tmio1Bus bus) {
		Tmio1Bus busAdded = restTemplate.postForEntity(SERVER+"buses", bus, Tmio1Bus.class).getBody();
		
		return busAdded;
	}

	@Override
	public Iterable<Tmio1Bus> findAll() {
		Tmio1Bus[] buses = restTemplate.getForObject(SERVER+"buses", Tmio1Bus[].class);
		List<Tmio1Bus> container;
		try {
			container = Arrays.asList(buses);
			return container;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public void deleteBus(Tmio1Bus bus) {
		restTemplate.delete(SERVER+"buses/"+bus.getId());
	}

	@Override
	public Tmio1Bus findById(Integer id) {
		Tmio1Bus bus = restTemplate.getForObject(SERVER+"buses/"+id, Tmio1Bus.class);
		return bus;
	}

	@Override
	public Tmio1Bus updateBus(Tmio1Bus bus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Bus buscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tmio1Bus> buscarPorModelo(BigDecimal modelo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tmio1Bus> buscarPorMarca(String marca) {
		// TODO Auto-generated method stub
		return null;
	}

}
