package co.edu.icesi.mio.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import co.edu.icesi.mio.model.Tmio1Bus;

@Repository
public class BusDao implements IBusDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Tmio1Bus bus) {
		entityManager.persist(bus);
	}

	@Override
	public void delete(Tmio1Bus bus) {
		entityManager.remove(bus);
	}

	@Override
	public void update(Tmio1Bus bus) {
		entityManager.merge(bus);
	}

	@Override
	public Tmio1Bus findById(Integer id) {
		return entityManager.find(Tmio1Bus.class, id);
	}

	@Override
	public List<Tmio1Bus> buscarPorModelo(BigDecimal modelo) {
		Query query = entityManager.createQuery("SELECT b FROM Tmio1Bus b WHERE b.modelo= '"+modelo+"'");
		return query.getResultList();
	}

	@Override
	public List<Tmio1Bus> buscarPorMarca(String marca) {
		Query query = entityManager.createQuery("SELECT b FROM Tmio1Bus b WHERE b.marca= '"+marca+"'");
		return query.getResultList();
	}

	@Override
	public Tmio1Bus buscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		try {
			Query query = entityManager.createQuery("SELECT b FROM Tmio1Bus b WHERE b.placa = '"+placa+"'");
			return (Tmio1Bus) query.getSingleResult();
		}
		catch(NoResultException e ) {
			return null;
		}
		catch(NonUniqueResultException e) {
			return null;
		}
	}

	@Override
	public List<Tmio1Bus> findAll() {
		Query query = entityManager.createQuery("SELECT b FROM Tmio1Bus b");
		return query.getResultList();
	}
	
	public List<Tmio1Bus> busesConServicios(){
		Query query = entityManager.createQuery("SELECT b FROM Tmio1Bus b WHERE ");
		return query.getResultList();
	}

}
