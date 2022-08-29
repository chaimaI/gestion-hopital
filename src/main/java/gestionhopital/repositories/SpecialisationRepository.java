package gestionhopital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestionhopital.entities.Specialisation;

@Repository
public interface SpecialisationRepository extends JpaRepository<Specialisation, Long> {

}
