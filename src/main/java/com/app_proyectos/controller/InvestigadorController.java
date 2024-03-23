package com.app_proyectos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app_proyectos.domain.Investigador;
import com.app_proyectos.exception.EntityNotFoundException;
import com.app_proyectos.exception.IllegalOperationException;
import com.app_proyectos.service.InvestigadorService;

@RestController
@RequestMapping("/api/v1/investigadores")
public class InvestigadorController {
	
	@Autowired
	private InvestigadorService invService;
	
	@GetMapping
	public List<Investigador> listarInvestigador(){
		return invService.listartodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable Long id) throws EntityNotFoundException{
		return ResponseEntity.status(HttpStatus.CREATED).body(invService.buscarPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<?> crearInvestigador(@RequestBody Investigador investigador)throws IllegalOperationException {
		return ResponseEntity.status(HttpStatus.CREATED).body(invService.grabar(investigador));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarInvestigador(@PathVariable Long id, @RequestBody Investigador inv) throws IllegalOperationException, EntityNotFoundException{
		Optional<Investigador> o = Optional.of(invService.buscarPorId(id));
		if(o.isPresent()) {
			Investigador invDB = o.get();
			invDB.setApeMat(inv.getApeMat());
			invDB.setApePat(inv.getApePat());
			invDB.setDni(inv.getDni());
			invDB.setEmail(inv.getEmail());
			invDB.setFechaReg(inv.getFechaReg());
			invDB.setNombres(inv.getNombres());
			return ResponseEntity.status(HttpStatus.CREATED).body(invService.grabar(invDB));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarInvestigador(@PathVariable Long id)throws IllegalOperationException, EntityNotFoundException {
		Optional<Investigador> o = Optional.of(invService.buscarPorId(id));
		if(o.isPresent()) {			
			invService.eliminar(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.noContent().build();
	}
}
