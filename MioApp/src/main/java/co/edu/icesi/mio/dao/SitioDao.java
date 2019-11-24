package co.edu.icesi.mio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import co.edu.icesi.mio.model.Tmio1Sitio;

@Repository
public class SitioDao implements ISitioDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Tmio1Sitio sitio) {
		entityManager.persist(sitio);
	}

	@Override
	public void delete(Tmio1Sitio sitio) {
		entityManager.remove(sitio);
	}

	@Override
	public void update(Tmio1Sitio sitio) {
		entityManager.merge(sitio);
	}

	@Override
	public Tmio1Sitio findById(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Tmio1Sitio.class, id);
	}

	@Override
	public List<Tmio1Sitio> findAll() {
		Query query = entityManager.createQuery("SELECT s FROM Tmio1Sitio s");
		return query.getResultList();
	}

}
