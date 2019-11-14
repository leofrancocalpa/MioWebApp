package co.edu.icesi.mio.dao;

import java.util.List;

import co.edu.icesi.mio.model.Tmio1Conductore;

public interface IConductorDao {
	void save(Tmio1Conductore conductor);
	void delete(Tmio1Conductore conductor);
	void update(Tmio1Conductore conductor);
	Tmio1Conductore findByID(String cedula);
	List<Tmio1Conductore> findByName(String name);
	List<Tmio1Conductore> findByLastName(String lastName);
	List<Tmio1Conductore> findAll();

}
