package gestionhopital.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "HopitalSpecialisation")
@Table(name = "hopital_specialisation")

public class HopitalSpecialisation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("hopitalId")
	private Hopital hopital;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("specialisationId")
	private Specialisation specialisation;

	@Column(name = "nombre_Lit_Disponible")
	private Long nombreLitDisponible;

	public HopitalSpecialisation() {
		super();

	}

	public HopitalSpecialisation(Hopital hopital, Specialisation specialisation) {
		super();
		this.specialisation = specialisation;
		this.hopital = hopital;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Hopital getHopital() {
		return hopital;
	}

	public void setHopital(Hopital hopital) {
		this.hopital = hopital;
	}

	public Specialisation getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(Specialisation specialisation) {
		this.specialisation = specialisation;
	}

	public Long getNombreLitDisponible() {
		return nombreLitDisponible;
	}

	public void setNombreLitDisponible(Long nombreLitDisponible) {
		this.nombreLitDisponible = nombreLitDisponible;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		HopitalSpecialisation that = (HopitalSpecialisation) o;
		return Objects.equals(hopital, that.hopital) && Objects.equals(specialisation, that.specialisation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(hopital, specialisation);
	}

}
