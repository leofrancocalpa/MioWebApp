package co.edu.icesi.mio.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.IRutaDao;
import co.edu.icesi.mio.model.Tmio1Ruta;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.repositories.RutasRepository;



@Service
public class RutaServiceImp implements RutaService{

	@Autowired
	private RutasRepository rutasRepository;
	@Autowired
	private IRutaDao rutaDao;
	
	@Transactional(readOnly = false)
	public boolean save(Tmio1Ruta ruta) throws Exception{
		if(ruta==null) {
			throw new Exception("Intentas guardar una ruta con valor null");
		}
		if(ruta.getHoraFin().doubleValue()==ruta.getHoraInicio().doubleValue() || ruta.getHoraFin().doubleValue()<ruta.getHoraInicio().doubleValue() ) {
			throw new Exception("La hora de inicio no puede ser igual o menor a la hora final");
		}
		if(ruta.getDiaFin().doubleValue()<ruta.getDiaInicio().doubleValue()) {
			throw new Exception("El dia de fin no puede ser inferior al dia de inicio");
		}
		else {			
//			rutasRepository.save(ruta);
			rutaDao.save(ruta);
			return true;
		}
	}
	
	@Override
	@Transactional(readOnly = false)
	public boolean createRuta(Integer id, String activa, String descripcion, BigDecimal diaFin, BigDecimal diaInicio,
			BigDecimal horaFin, BigDecimal horaInicio, String numero, List<Tmio1Servicio> tmio1Servicios) throws Exception{
		// TODO Auto-generated method stub
		if(horaFin.doubleValue()==horaInicio.doubleValue() || horaFin.doubleValue()<horaInicio.doubleValue()) {
			throw new Exception("La hora de inicio no puede ser igual o menor a la hora final");
		}
		if(diaFin.doubleValue()<diaInicio.doubleValue()) {
			throw new Exception("El dia de fin no puede ser inferior al dia de inicio");
		}
		Tmio1Ruta ruta = new Tmio1Ruta();
		ruta.setId(id);
		ruta.setActiva(activa);
		ruta.setDescripcion(descripcion);
		ruta.setDiaFin(diaFin);
		ruta.setDiaInicio(diaInicio);
		ruta.setHoraFin(horaFin);
		ruta.setHoraInicio(horaInicio);
		ruta.setTmio1Servicios(tmio1Servicios);
//		rutasRepository.save(ruta);
		rutaDao.save(ruta);
		return true;
	}

	@Override
	@Transactional(readOnly = false)
	public Tmio1Ruta updateRuta(Tmio1Ruta ruta) {
		// TODO Auto-generated method stub
//		rutasRepository.deleteById(ruta.getId());
//		rutasRepository.save(ruta);
		rutaDao.update(ruta);
		return ruta;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean deleteRuta(Integer id) {
		// TODO Auto-generated method stub
//		rutasRepository.deleteById(id);
		rutaDao.delete(rutaDao.findById(id));
		return true;
	}

	@Override
	@Transactional(readOnly = true)
	public Tmio1Ruta getRuta(Integer id) {
		// TODO Auto-generated method stub
//		return rutasRepository.findById(id).get();
		return rutaDao.findById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Tmio1Ruta> findAll(){
//		return rutasRepository.findAll();
		return rutaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tmio1Ruta> inicioDespuesDe(BigDecimal horaInicio) {
		// TODO Auto-generated method stub
		return rutaDao.inicioDespuesDe(horaInicio);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tmio1Ruta> inicioAntesDe(BigDecimal horaInicio) {
		// TODO Auto-generated method stub
		return rutaDao.inicioAntesDe(horaInicio);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tmio1Ruta> terminanDespuesDe(BigDecimal horaFin) {
		// TODO Auto-generated method stub
		return rutaDao.terminanDespuesDe(horaFin);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tmio1Ruta> terminanAntesDe(BigDecimal horaFin) {
		// TODO Auto-generated method stub
		return rutaDao.terminanAntesDe(horaFin);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tmio1Ruta> horarioEntre(BigDecimal horaInicio, BigDecimal horaFin) {
		// TODO Auto-generated method stub
		return rutaDao.horarioEntre(horaInicio, horaFin);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tmio1Ruta> diaInicio(BigDecimal diaInicio) {
		// TODO Auto-generated method stub
		return rutaDao.diaInicio(diaInicio);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tmio1Ruta> diaFin(BigDecimal diaFin) {
		// TODO Auto-generated method stub
		return rutaDao.diaFin(diaFin);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tmio1Ruta> diasEntre(BigDecimal diaInicio, BigDecimal diaFin) {
		// TODO Auto-generated method stub
		return rutaDao.diasEntre(diaInicio, diaFin);
	}

}
