package gestionhopital.TestIntegration;

import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
public class HopitalControllerITest {

	@Autowired
	public MockMvc mockMvc;

	@Test
	public void testAfficherListSpecialisations() throws Exception {

		mockMvc.perform(get("/urgences/specialisations")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].libelleSpecialisation", is("Anesthésie")))
				.andExpect(jsonPath("$[1].id", is(2)))
				.andExpect(jsonPath("$[1].libelleSpecialisation", is("Soins intensifs")))
				.andExpect(jsonPath("$[2].id", is(3)))
				.andExpect(jsonPath("$[2].libelleSpecialisation", is("Oncologie clinique")));
	}

	@Test
	public void testRechercherHopital() throws Exception {

		mockMvc.perform(get("/urgences/hopitals?specialisation=1&localisation=Bordeaux")).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1))).andExpect(jsonPath("$.nomHopital", is("CHU Bordeaux")))
				.andExpect(jsonPath("$.adresseHopital", is("23 rue andré reinson,33300 Bordeaux")))
				.andExpect(jsonPath("$.specialite", is("Anesthésie")));

	}

	@Test
	public void testReduireNombreLit() throws Exception {

		mockMvc.perform(put("/urgences/nombreLit/1/1")).andExpect(status().isOk());
	}

}
