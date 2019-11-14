package co.edu.icesi.mio.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import co.edu.icesi.mio.model.Tmio1Ruta;

@Repository
public class RutaDao implements IRutaDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Tmio1Ruta ruta) {
		entityManager.persist(ruta);
	}

	@Override
	public void delete(Tmio1Ruta ruta) {
		entityManager.remove(ruta);
	}

	@Override
	public void update(Tmio1Ruta ruta) {
		entityManager.merge(ruta);
	}

	@Override
	public Tmio1Ruta findById(Integer id) {
		return entityManager.find(Tmio1Ruta.class, id);
	}

	@Override
	public List<Tmio1Ruta> inicioDespuesDe(BigDecimal horaInicio) {
		Query query = entityManager.createQuery("SELECT r FROM Tmio1Ruta r WHERE r.horaInicio >= '"+horaInicio+"'");
		return query.getResultList();
	}

	@Override
	public List<Tmio1Ruta> inicioAntesDe(BigDecimal horaInicio) {
		Query query = entityManager.createQuery("SELECT r FROM Tmio1Ruta r WHERE r.horaInicio <= '"+horaInicio+"'");
		return query.getResultList();
	}

	@Override
	public List<Tmio1Ruta> terminanDespuesDe(BigDecimal horaFin) {
		Query query = entityManager.createQuery("SELECT r FROM Tmio1Ruta r WHERE r.horaFin >= '"+horaFin+"'");
		return query.getResultList();
	}

	@Override
	public List<Tmio1Ruta> terminanAntesDe(BigDecimal horaFin) {
		Query query = entityManager.createQuery("SELECT r FROM Tmio1Ruta r WHERE r.horaFin <= '"+horaFin+"'");
		return query.getResultList();
	}

	@Override
	public List<Tmio1Ruta> horarioEntre(BigDecimal horaInicio, BigDecimal horaFin) {
		Query query = entityManager.createQuery("SELECT r FROM Tmio1Ruta r WHERE r.horaFin <= '"+horaFin +"' AND r.horaInicio >= '"+horaInicio+"'");
		return query.getResultList();
	}

	@Override
	public List<Tmio1Ruta> diaInicio(BigDecimal diaInicio) {
		Query query = entityManager.createQuery("SELECT r FROM Tmio1Ruta r WHERE r.horaFin >= '"+diaInicio+"'" );
		return query.getResultList();
	}

	@Override
	public List<Tmio1Ruta> diaFin(BigDecimal diaFin) {
		Query query = entityManager.createQuery("SELECT r FROM Tmio1Ruta r WHERE r.horaFin <= '"+diaFin+"'");
		return query.getResultList();
	}

	@Override
	public List<Tmio1Ruta> diasEntre(BigDecimal diaInicio, BigDecimal diaFin) {
		Query query = entityManager.createQuery("SELECT r FROM Tmio1Ruta r WHERE r.horaFin <= '"+diaFin +"' AND r.horaInicio >= '"+diaInicio+"'");
		return query.getResultList();
	}

	@Override
	public List<Tmio1Ruta> findAll() {
		Query query = entityManager.createQuery("SELECT r FROM Tmio1Ruta r");
		return query.getResultList();
	}

}
