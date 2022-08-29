package gestionhopital.service;

import gestionhopital.dto.HopitalResponse;

public interface HopitalService {

	public HopitalResponse chercherHopital(Long codeSpecialite, String localisation) throws Exception;

	public boolean reduireNombreLit(Long codeHopital, Long codeSpecialisation) throws Exception;

}
