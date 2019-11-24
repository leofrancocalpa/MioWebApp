package co.edu.icesi.mio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import co.edu.icesi.mio.model.Tmio1SitiosRuta;

@Repository
public class SitioRutaDao implements ISitioRutaDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Tmio1SitiosRuta sitioRuta) {
		entityManager.persist(sitioRuta);
	}

	@Override
	public void update(Tmio1SitiosRuta sitioRuta) {
		entityManager.merge(sitioRuta);
	}

	@Override
	public void delete(Tmio1SitiosRuta sitioRuta) {
		entityManager.remove(sitioRuta);
	}

	@Override
	public List<Tmio1SitiosRuta> findAll() {
		Query query = entityManager.createQuery("SELECT s FROM Tmio1SitiosRuta s");
		return query.getResultList();
	}

}
