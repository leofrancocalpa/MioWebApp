package co.edu.icesi.mio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.mio.dao.ISitioDao;
import co.edu.icesi.mio.model.Tmio1Sitio;

@Service
public class SitioServiceImp implements SitioService{

	@Autowired
	private ISitioDao sitioDao;
	
	@Override
	@Transactional(readOnly=false)
	public boolean save(Tmio1Sitio sitio) throws Exception {
		sitioDao.save(sitio);
		return true;
	}

	@Override
	@Transactional(readOnly=false)
	public boolean delete(Tmio1Sitio sitio) throws Exception {
		sitioDao.delete(sitio);
		return true;
	}

	@Override
	@Transactional(readOnly=false)
	public Tmio1Sitio update(Tmio1Sitio sitio) throws Exception {
		// TODO Auto-generated method stub
		sitioDao.update(sitio);
		return sitio;
	}

	@Override
	@Transactional(readOnly=true)
	public Tmio1Sitio findById(Long id) {
		// TODO Auto-generated method stub
		return sitioDao.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Tmio1Sitio> findAll() {
		// TODO Auto-generated method stub
		return sitioDao.findAll();
	}

}
