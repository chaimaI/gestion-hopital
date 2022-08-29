package gestionhopital.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import gestionhopital.dto.SpecialisationResponse;
import gestionhopital.entities.Specialisation;
import gestionhopital.repositories.SpecialisationRepository;

@Service
public class SpecialisationServiceImpl implements SpecialisationService {

	@Autowired
	private SpecialisationRepository specialisationRepository;

	@Override
	public List<SpecialisationResponse> afficherSpecialisation() {

		List<Specialisation> specialisation = specialisationRepository.findAll();

		List<SpecialisationResponse> specialisationResponses = new ArrayList<>();

		for (Specialisation specialisation2 : specialisation) {

			SpecialisationResponse specialisationResp = SpecialisationResponse.from(specialisation2);

			specialisationResponses.add(specialisationResp);

		}
		return specialisationResponses;
	}
}
