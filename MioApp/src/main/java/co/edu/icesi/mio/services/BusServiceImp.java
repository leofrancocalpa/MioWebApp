package co.edu.icesi.mio.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.IBusDao;
import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.repositories.BusesRepository;



@Service
public class BusServiceImp implements BusService{
	
	@Autowired
	private BusesRepository busRepository;
	@Autowired
	private IBusDao busDao;
	
	@Transactional(readOnly=false)
	public boolean save(Tmio1Bus bus) throws Exception{
		if(!busRepository.findById(bus.getId()).isEmpty()) {
			throw new RuntimeException("Ya existe un bus con ese Id");
		}
		if(bus.getCapacidad().intValue()<=0) {
			throw new RuntimeException("La capacidad debe ser mayor a cero");
		}
		if(!bus.getTipo().equals("T") && !bus.getTipo().equals("P") && !bus.getTipo().equals("A")) {
			throw new RuntimeException("El tipo de bus debe ser: T o P o A");
		}
		else {
//			busRepository.save(bus);
			busDao.save(bus);
			return true;
		}
	}
	

	@Override
	@Transactional(readOnly=false)
	public Tmio1Bus updateBus(Tmio1Bus bus) {
		// TODO Auto-generated method stub
//		busRepository.deleteById(bus.getId());
//		busRepository.save(bus);
		busDao.update(bus);
		return bus;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean deleteBus(Integer id) {
		// TODO Auto-generated method stub
//		busRepository.deleteById(id);
		busDao.delete(busDao.findById(id));
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public Tmio1Bus findById(Integer id) {
		// TODO Auto-generated method stub
//		return busRepository.findById(id).get();
		return busDao.findById(id);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Tmio1Bus> findAll(){
//		return busRepository.findAll();
		return busDao.findAll();
	}


	@Override
	@Transactional(readOnly=true)
	public Tmio1Bus buscarPorPlaca(String placa) {
		return busDao.buscarPorPlaca(placa);
	}


	@Override
	@Transactional(readOnly=true)
	public List<Tmio1Bus> buscarPorModelo(BigDecimal modelo) {
		return busDao.buscarPorModelo(modelo);
	}


	@Override
	@Transactional(readOnly=true)
	public List<Tmio1Bus> buscarPorMarca(String marca) {
		return busDao.buscarPorMarca(marca);
	}
	
	
	
}
