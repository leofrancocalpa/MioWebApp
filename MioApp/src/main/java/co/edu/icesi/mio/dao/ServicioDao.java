package co.edu.icesi.mio.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.model.Tmio1Conductore;
import co.edu.icesi.mio.model.Tmio1Ruta;
import co.edu.icesi.mio.model.Tmio1Servicio;

@Repository
public class ServicioDao implements IServicioDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Tmio1Servicio servicio) {
		entityManager.persist(servicio);
	}

	@Override
	public void delete(Tmio1Servicio servicio) {
		entityManager.remove(servicio);
	}

	@Override
	public void update(Tmio1Servicio servicio) {
		entityManager.merge(servicio);
	}

	@Override
	public List<Tmio1Conductore> conductoresConServiciosVigentes(LocalDate fecha) {
		Query query = entityManager.createQuery("SELECT c "
				+ "FROM Tmio1Conductore c "
				+ "WHERE c.id.fechaFin < '"+ fecha +"'");
		return query.getResultList();
	}

	@Override
	public List<Tmio1Ruta> rutasConServiciosVigentes(LocalDate fecha) {
		Query query = entityManager.createQuery("SELECT DISTINCT r FROM Tmio1Ruta r "
				+ "WHERE (SELECT COUNT(s) FROM Tmio1Servicio s "
						+ "WHERE s.id.idRuta = r.id AND s.id.fechaFin >= '"+fecha+"' ) BETWEEN 1 AND 10");
		return query.getResultList();
	}
	
	public List<Tmio1Bus> busesConServicios(){
		Query query = entityManager.createQuery("SELECT DISTINCT b FROM Tmio1Bus b INNER JOIN r.tmio1Servicios "
				+ "WHERE (SELECT COUNT(s) FROM r.tmio1Servicios s "
						+ "WHERE s.id.fechaFi");
		return query.getResultList();
	}
	
	

}
