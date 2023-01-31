package reto_java.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reto_java.domain.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
