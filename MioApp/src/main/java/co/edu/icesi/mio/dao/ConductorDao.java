package co.edu.icesi.mio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import co.edu.icesi.mio.model.Tmio1Conductore;

@Repository
public class ConductorDao implements IConductorDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Tmio1Conductore conductor) {
		entityManager.persist(conductor);
	}

	@Override
	public void delete(Tmio1Conductore conductor) {
		entityManager.remove(conductor);
	}

	@Override
	public void update(Tmio1Conductore conductor) {
		entityManager.merge(conductor);
	}

	@Override
	public Tmio1Conductore findByID(String cedula) {
		return entityManager.find(Tmio1Conductore.class, cedula);
	}

	@Override
	public List<Tmio1Conductore> findByName(String name) {
		Query query = entityManager.createQuery("SELECT c FROM Tmio1Conductore c WHERE c.nombre= '"+name+"'");
		return query.getResultList();
	}

	@Override
	public List<Tmio1Conductore> findByLastName(String lastName) {
		Query query = entityManager.createQuery("SELECT c FROM Tmio1Conductore c WHERE c.apellidos= '"+lastName+"'");
		return query.getResultList();
	}

	@Override
	public List<Tmio1Conductore> findAll() {
		Query query = entityManager.createQuery("SELECT c FROM Tmio1Conductore c");
		return query.getResultList();
	}

}
