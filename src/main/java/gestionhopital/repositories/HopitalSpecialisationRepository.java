package gestionhopital.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestionhopital.entities.Hopital;
import gestionhopital.entities.HopitalSpecialisation;
import gestionhopital.entities.Specialisation;

@Repository
public interface HopitalSpecialisationRepository extends JpaRepository<HopitalSpecialisation, Long> {

	public Optional<HopitalSpecialisation> findByHopitalAndSpecialisation(Hopital hopital,
			Specialisation specialisation);
}
