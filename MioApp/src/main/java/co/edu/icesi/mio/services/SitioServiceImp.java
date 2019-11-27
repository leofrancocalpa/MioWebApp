package co.edu.icesi.mio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.icesi.mio.dao.ISitioDao;
import co.edu.icesi.mio.model.Tmio1Sitio;

public class SitioServiceImp implements SitioService{

	@Autowired
	private ISitioDao sitioDao;
	
	@Override
	public boolean save(Tmio1Sitio sitio) throws Exception {
		sitioDao.save(sitio);
		return true;
	}

	@Override
	public boolean delete(Tmio1Sitio sitio) throws Exception {
		sitioDao.delete(sitio);
		return true;
	}

	@Override
	public Tmio1Sitio update(Tmio1Sitio sitio) throws Exception {
		// TODO Auto-generated method stub
		sitioDao.update(sitio);
		return sitio;
	}

	@Override
	public Tmio1Sitio findById(Long id) {
		// TODO Auto-generated method stub
		return sitioDao.findById(id);
	}

	@Override
	public List<Tmio1Sitio> findAll() {
		// TODO Auto-generated method stub
		return sitioDao.findAll();
	}

}
