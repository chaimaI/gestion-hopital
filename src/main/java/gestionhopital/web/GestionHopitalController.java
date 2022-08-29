package gestionhopital.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import gestionhopital.dto.HopitalResponse;
import gestionhopital.dto.SpecialisationResponse;

import gestionhopital.service.HopitalService;
import gestionhopital.service.SpecialisationService;

@RequestMapping("/urgences")
@RestController
public class GestionHopitalController {

	@Autowired
	SpecialisationService specialisationService;

	@Autowired
	HopitalService hopitalService;

	@GetMapping("/hopitals")
	public HopitalResponse rechercherHopital(@RequestParam(name = "specialisation") Long codeSpecialisation,
			@RequestParam(name = "localisation") String localisation) throws Exception {

		HopitalResponse hopitalResponse = hopitalService.chercherHopital(codeSpecialisation, localisation);

		return hopitalResponse;

	}

	@PutMapping("/nombreLit/{hopital}/{specialisation}")

	public boolean reduireNombreLit(@PathVariable(name = "hopital") Long codeHopital,
			@PathVariable(name = "specialisation") Long codeSpecialisation) throws Exception {

		return hopitalService.reduireNombreLit(codeHopital, codeSpecialisation);

	}

	@GetMapping("/specialisations")

	public List<SpecialisationResponse> afficherSpecialisation() {

		specialisationService.afficherSpecialisation();

		List<SpecialisationResponse> specialisationResponses = specialisationService.afficherSpecialisation();
		return specialisationResponses;

	}

}
