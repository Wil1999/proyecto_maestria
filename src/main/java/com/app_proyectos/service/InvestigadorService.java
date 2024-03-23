package com.app_proyectos.service;

import java.util.List;

import com.app_proyectos.domain.Investigador;
import com.app_proyectos.exception.EntityNotFoundException;
import com.app_proyectos.exception.IllegalOperationException;

public interface InvestigadorService {
	List<Investigador> listartodos();
	Investigador buscarPorId(Long id)throws EntityNotFoundException;
	Investigador grabar(Investigador investigador)throws IllegalOperationException;
	Investigador actualizar(Investigador investigador, long id) throws EntityNotFoundException, IllegalOperationException;
	void eliminar(Long id) throws EntityNotFoundException, IllegalOperationException;
	Investigador findByDni(String dni);
	Investigador findByEmail(String email);
}
