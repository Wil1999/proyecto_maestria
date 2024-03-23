package com.app_proyectos.service;

import java.util.List;

import com.app_proyectos.domain.ProyectoInvestigacion;


public interface ProyectoInvestigacionService{
	List<ProyectoInvestigacion> listAll();
	ProyectoInvestigacion findById(Long id);
	ProyectoInvestigacion save(ProyectoInvestigacion investigador);
	ProyectoInvestigacion update(ProyectoInvestigacion investigador, long id);
	void delete(Long id);
}
