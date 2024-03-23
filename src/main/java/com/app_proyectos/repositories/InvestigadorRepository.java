package com.app_proyectos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app_proyectos.domain.Investigador;

public interface InvestigadorRepository extends JpaRepository<Investigador, Long> {
	Optional<Investigador> findByDni(String dni);
	Optional<Investigador> findByEmail(String email);


}
