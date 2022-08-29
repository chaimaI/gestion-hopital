package gestionhopital.dto;

import gestionhopital.entities.Specialisation;

public class SpecialisationResponse {

	private Long id;
	private String libelleSpecialisation;

	public SpecialisationResponse() {
		super();

	}

	public SpecialisationResponse(String libelleSpecialisation) {
		super();
		this.libelleSpecialisation = libelleSpecialisation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelleSpecialisation() {
		return libelleSpecialisation;
	}

	public void setLibelleSpecialisation(String libelleSpecialisation) {
		this.libelleSpecialisation = libelleSpecialisation;
	}

	public static SpecialisationResponse from(Specialisation specialisation) {

		SpecialisationResponse specialisationResponse = new SpecialisationResponse();
		specialisationResponse.setId(specialisation.getCodeSpecialite());
		specialisationResponse.setLibelleSpecialisation(specialisation.getLibelleSpecialite());

		return specialisationResponse;
	}
}
