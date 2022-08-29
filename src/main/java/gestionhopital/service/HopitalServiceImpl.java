package gestionhopital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import gestionhopital.dto.HopitalResponse;
import gestionhopital.entities.Hopital;
import gestionhopital.entities.HopitalSpecialisation;
import gestionhopital.entities.Specialisation;
import gestionhopital.repositories.HopitalRepository;
import gestionhopital.repositories.HopitalSpecialisationRepository;
import gestionhopital.repositories.SpecialisationRepository;

@Service
public class HopitalServiceImpl implements HopitalService {

	@Autowired
	private SpecialisationRepository specialisationRepository;

	@Autowired
	private HopitalRepository hopitalRepository;

	@Autowired
	private HopitalSpecialisationRepository hopitalSpecialisationRepository;

	@Override
	public HopitalResponse chercherHopital(Long codeSpecialite, String localisation) throws Exception {

		Optional<Specialisation> specialisation = specialisationRepository.findById(codeSpecialite);

		if (specialisation.isEmpty()) {

			throw new Exception("specialisation introuvable");

		}

		List<HopitalSpecialisation> hopitalSpecialisation = specialisation.get().getHopitaux();

		for (HopitalSpecialisation hopitalSpecialisation2 : hopitalSpecialisation) {

			if (hopitalSpecialisation2.getHopital().getAdresse().contains(localisation)
					&& hopitalSpecialisation2.getNombreLitDisponible() > 0) {

				return HopitalResponse.from(hopitalSpecialisation2);
			}

		}

		return null;
	}

	@Override
	public boolean reduireNombreLit(Long codeHopital, Long codeSpecialisation) throws Exception {

		Optional<Specialisation> specialisation = specialisationRepository.findById(codeSpecialisation);

		if (specialisation.isEmpty()) {

			throw new Exception("specialisation introuvable");

		}

		Optional<Hopital> hopital = hopitalRepository.findById(codeHopital);

		if (hopital.isEmpty()) {

			throw new Exception("hopital introuvable");

		}

		Optional<HopitalSpecialisation> hopitalSpecialisation = hopitalSpecialisationRepository
				.findByHopitalAndSpecialisation(hopital.get(), specialisation.get());

		if (hopitalSpecialisation.isEmpty()) {

			throw new Exception("Pas de spécialisation trouvé pour cette hopital");

		}

		if (hopitalSpecialisation.get().getNombreLitDisponible() <= 0) {

			throw new Exception("Pas de lit disponible pour cette spécialisation dans cette hopital");

		}

		Long nombreLitDisponible = hopitalSpecialisation.get().getNombreLitDisponible();
		hopitalSpecialisation.get().setNombreLitDisponible(nombreLitDisponible - 1);

		hopitalSpecialisationRepository.saveAndFlush(hopitalSpecialisation.get());

		return true;

	}

}
