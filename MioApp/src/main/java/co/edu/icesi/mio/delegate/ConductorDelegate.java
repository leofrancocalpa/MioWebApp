package co.edu.icesi.mio.delegate;

import co.edu.icesi.mio.model.Tmio1Conductore;

public interface ConductorDelegate {

	public Tmio1Conductore addConductor(Tmio1Conductore conductor);
	public Tmio1Conductore updateConductor(Tmio1Conductore conductor);
	public void deleteConductor(String id);
	public Tmio1Conductore findById(String id);
	public Iterable<Tmio1Conductore> findAll();
	
	public Iterable<Tmio1Conductore> findByName(String name);
	public Iterable<Tmio1Conductore> findByLastName(String lastName);
	
}
