package gestionhopital.entities;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Specialisation")
@Table(name = "specialisation")
public class Specialisation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeSpecialite;
	private String libelleSpecialite;

	@OneToMany(mappedBy = "specialisation", cascade = CascadeType.ALL, orphanRemoval = true)

	private List<HopitalSpecialisation> hopitaux = new ArrayList<>();

	public Specialisation() {
		super();

	}

	public Specialisation(String libelleSpecialite) {
		super();
		this.libelleSpecialite = libelleSpecialite;

	}

	public Long getCodeSpecialite() {
		return codeSpecialite;
	}

	public void setCodeSpecialite(Long codeSpecialite) {
		this.codeSpecialite = codeSpecialite;
	}

	public String getLibelleSpecialite() {
		return libelleSpecialite;
	}

	public void setLibelleSpecialite(String libelleSpecialite) {
		this.libelleSpecialite = libelleSpecialite;
	}

	public List<HopitalSpecialisation> getHopitaux() {
		return hopitaux;
	}

	public void setHopitaux(List<HopitalSpecialisation> hopitaux) {
		this.hopitaux = hopitaux;
	}

	public void addHopital(Hopital hopital) {
		HopitalSpecialisation hopitalSpecialisation = new HopitalSpecialisation(hopital, this);
		hopitaux.add(hopitalSpecialisation);
		hopital.getSpecialisations().add(hopitalSpecialisation);
	}

	public void removeTag(Hopital hopital) {
		for (Iterator<HopitalSpecialisation> iterator = hopitaux.iterator(); iterator.hasNext();) {
			HopitalSpecialisation hopitalSpecialisation = iterator.next();

			if (hopitalSpecialisation.getSpecialisation().equals(this)
					&& hopitalSpecialisation.getHopital().equals(hopital)) {
				iterator.remove();
				hopitalSpecialisation.getHopital().getSpecialisations().remove(hopitalSpecialisation);
				hopitalSpecialisation.setHopital(null);
				hopitalSpecialisation.setSpecialisation(null);
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Specialisation specialisation = (Specialisation) o;
		return Objects.equals(libelleSpecialite, specialisation.libelleSpecialite);
	}
}
