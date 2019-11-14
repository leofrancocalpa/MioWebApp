package co.edu.icesi.mio.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * The primary key class for the tmio1_servicios database table.
 * 
 */
@Embeddable
public class Tmio1ServicioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	private int hash;

	@Column(name="id_ruta", insertable=false, updatable=false)
	private Integer idRuta;

	@Column(name="cedula_conductor", insertable=false, updatable=false)
	private String cedulaConductor;

	@Column(name="id_bus", insertable=false, updatable=false)
	private Integer idBus;

//	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaInicio;

//	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaFin;

	public Tmio1ServicioPK() {
	}
	public Integer getIdRuta() {
		return this.idRuta;
	}
	public void setIdRuta(Integer idRuta) {
		this.idRuta = idRuta;
	}
	public String getCedulaConductor() {
		return this.cedulaConductor;
	}
	public void setCedulaConductor(String cedulaConductor) {
		this.cedulaConductor = cedulaConductor;
	}
	public Integer getIdBus() {
		return this.idBus;
	}
	public void setIdBus(Integer idBus) {
		this.idBus = idBus;
	}
	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return this.fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Tmio1ServicioPK)) {
			return false;
		}
		Tmio1ServicioPK castOther = (Tmio1ServicioPK)other;
		return 
			this.idRuta.equals(castOther.idRuta)
			&& this.cedulaConductor.equals(castOther.cedulaConductor)
			&& this.idBus.equals(castOther.idBus)
			&& this.fechaInicio.equals(castOther.fechaInicio)
			&& this.fechaFin.equals(castOther.fechaFin);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRuta.hashCode();
		hash = hash * prime + this.cedulaConductor.hashCode();
		hash = hash * prime + this.idBus.hashCode();
		hash = hash * prime + this.fechaInicio.hashCode();
		hash = hash * prime + this.fechaFin.hashCode();
		
		return hash;
	}
	public int getHash() {
		return hash;
	}
	public void setHash(int hash) {
		this.hash = hash;
	}
}