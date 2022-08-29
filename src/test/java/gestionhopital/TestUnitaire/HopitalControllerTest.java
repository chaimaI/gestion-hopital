package gestionhopital.TestUnitaire;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import gestionhopital.dto.HopitalResponse;
import gestionhopital.dto.SpecialisationResponse;
import gestionhopital.service.HopitalService;
import gestionhopital.service.SpecialisationService;
import gestionhopital.web.GestionHopitalController;

@WebMvcTest(controllers = GestionHopitalController.class)
public class HopitalControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private HopitalService hopitalService;

	@MockBean
	private SpecialisationService specialisationService;

	HopitalResponse hopitalResponse;

	SpecialisationResponse specialisationResponse;

	SpecialisationResponse specialisationResponse1;

	SpecialisationResponse specialisationResponse2;

	List<SpecialisationResponse> specialisationResponses;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testRechercherHopital() throws Exception {

		hopitalResponse = new HopitalResponse();
		hopitalResponse.setId((long) 1);
		hopitalResponse.setNomHopital("CHU Bordeaux");
		hopitalResponse.setAdresseHopital("23 rue andré reinson,33300 Bordeaux");
		hopitalResponse.setSpecialite("Anesthésie");
		hopitalResponse.setNombreLitDisponible((long) 2);

		when(hopitalService.chercherHopital(1L, "Bordeaux")).thenReturn(hopitalResponse);

		mockMvc.perform(get("/urgences/hopitals?specialisation=1&localisation=Bordeaux")).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1))).andExpect(jsonPath("$.nomHopital", is("CHU Bordeaux")))
				.andExpect(jsonPath("$.adresseHopital", is("23 rue andré reinson,33300 Bordeaux")))
				.andExpect(jsonPath("$.specialite", is("Anesthésie")))
				.andExpect(jsonPath("$.nombreLitDisponible", is(2)));
	}

	@Test
	public void testAfficherListSpecialisations() throws Exception {

		specialisationResponse = new SpecialisationResponse();
		specialisationResponse.setId(1L);
		specialisationResponse.setLibelleSpecialisation("Anesthésie");

		specialisationResponse1 = new SpecialisationResponse();
		specialisationResponse1.setId(2L);
		specialisationResponse1.setLibelleSpecialisation("Soins intensifs");

		specialisationResponse2 = new SpecialisationResponse();
		specialisationResponse2.setId(3L);
		specialisationResponse2.setLibelleSpecialisation("Spécialités dentaires supplémentaires");

		specialisationResponses = new ArrayList<>();
		specialisationResponses.add(specialisationResponse);
		specialisationResponses.add(specialisationResponse1);
		specialisationResponses.add(specialisationResponse2);

		when(specialisationService.afficherSpecialisation()).thenReturn(specialisationResponses);

		mockMvc.perform(get("/urgences/specialisations")).andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].id", is(1)))
				.andExpect(jsonPath("$.[0].libelleSpecialisation", is("Anesthésie")))
				.andExpect(jsonPath("$.[1].id", is(2)))
				.andExpect(jsonPath("$.[1].libelleSpecialisation", is("Soins intensifs")))
				.andExpect(jsonPath("$.[2].id", is(3)))
				.andExpect(jsonPath("$.[2].libelleSpecialisation", is("Spécialités dentaires supplémentaires")));
	}

	@Test
	public void testReduireNombreLit() throws Exception {

		when(hopitalService.reduireNombreLit(1L, 1L)).thenReturn(true);

		mockMvc.perform(put("/urgences/nombreLit/1/1")).andExpect(status().isOk());
	}
}
