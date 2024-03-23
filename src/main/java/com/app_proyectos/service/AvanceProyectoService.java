package com.app_proyectos.service;

import java.util.List;

import com.app_proyectos.domain.AvanceProyecto;

public interface AvanceProyectoService {
	List<AvanceProyecto> listAll();
	AvanceProyecto findById(Long id);
	AvanceProyecto save(AvanceProyecto avanceProyecto);
	AvanceProyecto update(AvanceProyecto avanceProyecto, long id);
	void delete(Long id);
}
