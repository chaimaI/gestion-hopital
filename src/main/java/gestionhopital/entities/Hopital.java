package gestionhopital.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

@Entity(name = "Hopital")
@Table(name = "hopital")
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class Hopital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeHopital;
	private String nom;
	private String adresse;

	@OneToMany(mappedBy = "hopital", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<HopitalSpecialisation> specialisations = new ArrayList<>();

	public Hopital() {
		super();

	}

	public Hopital(String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;

	}

	public Long getCodeHopital() {
		return codeHopital;
	}

	public void setCodeHopital(Long codeHopital) {
		this.codeHopital = codeHopital;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<HopitalSpecialisation> getSpecialisations() {
		return specialisations;
	}

	public void setSpecialisations(List<HopitalSpecialisation> specialisations) {
		this.specialisations = specialisations;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Hopital hopital = (Hopital) o;
		return Objects.equals(nom, hopital.nom);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}

}
