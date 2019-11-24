package co.edu.icesi.mio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.icesi.mio.dao.ISitioRutaDao;
import co.edu.icesi.mio.model.Tmio1SitiosRuta;

public class SitioRutaServiceImp implements SitioRutaService{

	@Autowired
	private ISitioRutaDao sitioRutaDao;
	
	@Override
	public boolean save(Tmio1SitiosRuta sitiosRuta) throws Exception {
		// TODO Auto-generated method stub
		sitioRutaDao.save(sitiosRuta);
		return true;
	}

	@Override
	public boolean update(Tmio1SitiosRuta sitiosRuta) throws Exception {
		// TODO Auto-generated method stub
		sitioRutaDao.update(sitiosRuta);
		return true;
	}

	@Override
	public boolean delete(Tmio1SitiosRuta sitiosRuta) throws Exception {
		// TODO Auto-generated method stub
		sitioRutaDao.delete(sitiosRuta);
		return true;
	}

	@Override
	public Tmio1SitiosRuta findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1SitiosRuta findByHashCode(int hashcode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tmio1SitiosRuta> findAll() {
		// TODO Auto-generated method stub
		return sitioRutaDao.findAll();
	}

}
