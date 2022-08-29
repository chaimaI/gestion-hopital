package gestionhopital.dto;

import gestionhopital.entities.HopitalSpecialisation;

public class HopitalResponse {

	private Long id;
	private String nomHopital;
	private String adresseHopital;
	private String specialite;
	private Long nombreLitDisponible;

	public HopitalResponse() {
		super();
	}

	public HopitalResponse(String nomHopital, String adresseHopital, String specialite, Long nombreLitDisponible) {
		super();
		this.nomHopital = nomHopital;
		this.adresseHopital = adresseHopital;
		this.specialite = specialite;
		this.nombreLitDisponible = nombreLitDisponible;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomHopital() {
		return nomHopital;
	}

	public void setNomHopital(String nomHopital) {
		this.nomHopital = nomHopital;
	}

	public String getAdresseHopital() {
		return adresseHopital;
	}

	public void setAdresseHopital(String adresseHopital) {
		this.adresseHopital = adresseHopital;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Long getNombreLitDisponible() {
		return nombreLitDisponible;
	}

	public void setNombreLitDisponible(Long nombreLitDisponible) {
		this.nombreLitDisponible = nombreLitDisponible;
	}

	public static HopitalResponse from(HopitalSpecialisation hopital) {

		HopitalResponse hopitalResponse = new HopitalResponse();
		hopitalResponse.setId(hopital.getHopital().getCodeHopital());
		hopitalResponse.setNomHopital(hopital.getHopital().getNom());
		hopitalResponse.setAdresseHopital(hopital.getHopital().getAdresse());
		hopitalResponse.setSpecialite(hopital.getSpecialisation().getLibelleSpecialite());
		hopitalResponse.setNombreLitDisponible(hopital.getNombreLitDisponible());

		return hopitalResponse;
	}

}
