package gestionhopital.TestUnitaire;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import gestionhopital.dto.SpecialisationResponse;
import gestionhopital.entities.Specialisation;
import gestionhopital.repositories.SpecialisationRepository;
import gestionhopital.service.SpecialisationServiceImpl;

@ExtendWith(MockitoExtension.class)

public class SpecialisationServiceImplTest {

	@InjectMocks
	SpecialisationServiceImpl specialisationServiceImpl;

	@Mock
	SpecialisationRepository specialisationRepository;

	Specialisation specialisation;

	Specialisation specialisation2;

	Specialisation specialisation3;

	List<Specialisation> specialisations;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);

		specialisations = new ArrayList<>();

		specialisation = new Specialisation();
		specialisation.setCodeSpecialite(1L);
		specialisation.setLibelleSpecialite("Anesthésie");

		specialisation2 = new Specialisation();
		specialisation2.setCodeSpecialite(2L);
		specialisation2.setLibelleSpecialite("Soins intensifs");

		specialisation3 = new Specialisation();
		specialisation3.setCodeSpecialite(3L);
		specialisation3.setLibelleSpecialite("Spécialités dentaires supplémentaires");

		specialisations.add(specialisation);
		specialisations.add(specialisation2);
		specialisations.add(specialisation3);

	}

	@Test
	public void testAfficherListSpecialisation() throws Exception {

		when(specialisationRepository.findAll()).thenReturn(specialisations);

		List<SpecialisationResponse> specialisationResponses = specialisationServiceImpl.afficherSpecialisation();

		assertEquals(specialisationResponses.get(0).getId(), 1L);
		assertEquals(specialisationResponses.get(0).getLibelleSpecialisation(), "Anesthésie");
		assertEquals(specialisationResponses.get(1).getId(), 2L);
		assertEquals(specialisationResponses.get(1).getLibelleSpecialisation(), "Soins intensifs");
		assertEquals(specialisationResponses.get(2).getId(), 3L);
		assertEquals(specialisationResponses.get(2).getLibelleSpecialisation(),
				"Spécialités dentaires supplémentaires");
	}

}
