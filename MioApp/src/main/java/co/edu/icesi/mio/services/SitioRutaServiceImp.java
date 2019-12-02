package co.edu.icesi.mio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.ISitioRutaDao;
import co.edu.icesi.mio.model.Tmio1SitiosRuta;

@Service
public class SitioRutaServiceImp implements SitioRutaService{

	@Autowired
	private ISitioRutaDao sitioRutaDao;
	
	@Override
	@Transactional(readOnly=false)
	public boolean save(Tmio1SitiosRuta sitiosRuta) throws Exception {
		// TODO Auto-generated method stub
		sitioRutaDao.save(sitiosRuta);
		return true;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean update(Tmio1SitiosRuta sitiosRuta) throws Exception {
		// TODO Auto-generated method stub
		sitioRutaDao.update(sitiosRuta);
		return true;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean delete(Tmio1SitiosRuta sitiosRuta) throws Exception {
		// TODO Auto-generated method stub
		sitioRutaDao.delete(sitiosRuta);
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public Tmio1SitiosRuta findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public Tmio1SitiosRuta findByHashCode(int hashcode) {
		List<Tmio1SitiosRuta> sitiosruta = sitioRutaDao.findAll();
		Tmio1SitiosRuta salida = null;
		for(Tmio1SitiosRuta evaluado : sitiosruta) {
			if(evaluado.getId().getHash()==hashcode) {
				return evaluado;
			}
		}
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Tmio1SitiosRuta> findAll() {
		// TODO Auto-generated method stub
		return sitioRutaDao.findAll();
	}

}
