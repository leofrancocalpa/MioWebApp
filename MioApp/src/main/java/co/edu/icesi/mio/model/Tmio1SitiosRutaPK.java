package co.edu.icesi.mio.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tmio1_sitios_rutas database table.
 * 
 */
@Embeddable
public class Tmio1SitiosRutaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int hash;
	
	@Column(name="id_sitio", insertable=false, updatable=false)
	private Long idSitio;

	@Column(name="id_ruta", insertable=false, updatable=false)
	private Integer idRuta;

	public Tmio1SitiosRutaPK() {
	}
	public Long getIdSitio() {
		return this.idSitio;
	}
	public void setIdSitio(Long idSitio) {
		this.idSitio = idSitio;
	}
	public Integer getIdRuta() {
		return this.idRuta;
	}
	public void setIdRuta(Integer idRuta) {
		this.idRuta = idRuta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Tmio1SitiosRutaPK)) {
			return false;
		}
		Tmio1SitiosRutaPK castOther = (Tmio1SitiosRutaPK)other;
		return 
			this.idSitio.equals(castOther.idSitio)
			&& this.idRuta.equals(castOther.idRuta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idSitio.hashCode();
		hash = hash * prime + this.idRuta.hashCode();
		
		return hash;
	}
	public int getHash() {
		return hash;
	}
	public void setHash(int hash) {
		this.hash = hash;
	}
}