package gestionhopital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestionhopital.entities.Hopital;

@Repository
public interface HopitalRepository extends JpaRepository<Hopital, Long> {

}
