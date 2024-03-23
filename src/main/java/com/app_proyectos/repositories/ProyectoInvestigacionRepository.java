package com.app_proyectos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app_proyectos.domain.ProyectoInvestigacion;

public interface ProyectoInvestigacionRepository extends JpaRepository<ProyectoInvestigacion, Long> {
	
}
