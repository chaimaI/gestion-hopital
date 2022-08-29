package gestionhopital.TestUnitaire;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import gestionhopital.dto.HopitalResponse;
import gestionhopital.entities.Hopital;
import gestionhopital.entities.HopitalSpecialisation;
import gestionhopital.entities.Specialisation;
import gestionhopital.repositories.HopitalRepository;
import gestionhopital.repositories.HopitalSpecialisationRepository;
import gestionhopital.repositories.SpecialisationRepository;
import gestionhopital.service.HopitalServiceImpl;

@ExtendWith(MockitoExtension.class)
public class HopitalServiceImplTest {
	@InjectMocks
	HopitalServiceImpl hopitalServiceImpl;

	@Mock
	SpecialisationRepository specialisationRepository;

	@Mock
	HopitalRepository hopitalRepository;

	@Mock
	HopitalSpecialisationRepository hopitalSpecialisationRepository;

	Specialisation specialisation;

	Hopital hopital1;

	Hopital hopital2;

	HopitalSpecialisation hopitalSpecialisation;

	HopitalSpecialisation hopitalSpecialisation1;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);

		specialisation = new Specialisation();
		specialisation.setCodeSpecialite(1L);
		specialisation.setLibelleSpecialite("Anesthésie");

		hopital1 = new Hopital();
		hopital1.setCodeHopital(1L);
		hopital1.setNom("CHU Bordeaux");
		hopital1.setAdresse("23 rue andré reinson,33300 Bordeaux");

		hopital2 = new Hopital();
		hopital2.setCodeHopital(2L);
		hopital2.setNom("CHU Lyon");
		hopital2.setAdresse("23 rue pasteur henry,42000 Lyon");

		hopitalSpecialisation = new HopitalSpecialisation();
		hopitalSpecialisation.setHopital(hopital1);
		hopitalSpecialisation.setNombreLitDisponible(10L);
		hopitalSpecialisation.setSpecialisation(specialisation);

		hopitalSpecialisation1 = new HopitalSpecialisation();
		hopitalSpecialisation1.setHopital(hopital2);
		hopitalSpecialisation1.setNombreLitDisponible(10L);
		hopitalSpecialisation1.setSpecialisation(specialisation);

		List<HopitalSpecialisation> hopitalSpecialisations = new ArrayList<>();

		hopitalSpecialisations.add(hopitalSpecialisation);
		hopitalSpecialisations.add(hopitalSpecialisation1);

		specialisation.setHopitaux(hopitalSpecialisations);

	}

	@Test
	public void testRechercherHopital() throws Exception {

		when(specialisationRepository.findById(1L)).thenReturn(Optional.of(specialisation));

		HopitalResponse hopitalResponseResult = hopitalServiceImpl.chercherHopital(1L, "Bordeaux");

		assertEquals(hopitalResponseResult.getNomHopital(), "CHU Bordeaux");
		assertEquals(hopitalResponseResult.getAdresseHopital(), "23 rue andré reinson,33300 Bordeaux");
		assertEquals(hopitalResponseResult.getId(), 1L);
	}

	@Test
	public void testReduireNombreLit() throws Exception {

		when(specialisationRepository.findById(1L)).thenReturn(Optional.of(specialisation));

		when(hopitalRepository.findById(1L)).thenReturn(Optional.of(hopital1));

		when(hopitalSpecialisationRepository.findByHopitalAndSpecialisation(hopital1, specialisation))
				.thenReturn(Optional.of(hopitalSpecialisation));

		boolean reduireNombreLitResulte = hopitalServiceImpl.reduireNombreLit(1L, 1L);

		assertEquals(reduireNombreLitResulte, true);

	}

}
