package com.app_proyectos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_proyectos.domain.Investigador;
import com.app_proyectos.exception.EntityNotFoundException;
import com.app_proyectos.exception.EntityNotFoundExceptionMessages;
import com.app_proyectos.exception.IllegalOperationException;
import com.app_proyectos.repositories.InvestigadorRepository;
import com.app_proyectos.service.InvestigadorService;

import jakarta.transaction.Transactional;

@Service
public class InvestigadorServiceImp implements InvestigadorService {
	
	@Autowired
	private InvestigadorRepository invRep;

	@Override
	@Transactional
	public List<Investigador> listartodos() {
		return invRep.findAll();
	}

	@Override
	@Transactional
	public Investigador buscarPorId(Long id) throws EntityNotFoundException {
		Optional<Investigador> investigador=invRep.findById(id);
		if(investigador.isEmpty()) throw new EntityNotFoundException(EntityNotFoundExceptionMessages.INVESTIGADOR_NOT_FOUND);
		return investigador.get();
	}

	@Override
	@Transactional
	public Investigador grabar(Investigador investigador) throws IllegalOperationException{
		if(!invRep.findByEmail(investigador.getEmail()).isEmpty()) {
			throw new IllegalOperationException("Ya existe un Investigador con ese EMAIL");
		}
		if(!invRep.findByDni(investigador.getDni()).isEmpty()) {
			throw new IllegalOperationException("Ya existe un Investigador con ese DNI");
		}
		return invRep.save(investigador);
	}

	@Override
	public Investigador actualizar(Investigador investigador, long id) throws EntityNotFoundException, IllegalOperationException{
		Optional<Investigador> invEntity = invRep.findById(id);
		if(invEntity.isEmpty()) {
			throw new EntityNotFoundException("El investigador no existe");
		}
		if(!invRep.findByEmail(investigador.getEmail()).isEmpty()) {
			throw new EntityNotFoundException("Ya existe un investigador con ese EMAIL");
		}
		if(!invRep.findByDni(investigador.getDni()).isEmpty()) {
			throw new IllegalOperationException("Ya existe un investigador con ese DNI");
		}
		investigador.setIdInvestigador(id);
		return invRep.save(investigador);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		Investigador inv = invRep.findById(id).orElseThrow(
				() -> new EntityNotFoundException(EntityNotFoundExceptionMessages.INVESTIGADOR_NOT_FOUND)
				);
		invRep.deleteById(id);
	}

	@Override
	public Investigador findByDni(String dni) {
		Optional<Investigador> inv=invRep.findByDni(dni);
		return inv.get();
	}

	@Override
	public Investigador findByEmail(String email) {
		Optional<Investigador> inv=invRep.findByEmail(email);
		return inv.get();
	}

}
