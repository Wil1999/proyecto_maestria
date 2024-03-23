package com.app_proyectos.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_proyectos.domain.AvanceProyecto;
import com.app_proyectos.domain.Investigador;
import com.app_proyectos.domain.ProyectoInvestigacion;
import com.app_proyectos.repositories.ProyectoInvestigacionRepository;
import com.app_proyectos.service.ProyectoInvestigacionService;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Service
public class ProyectoInvestigacionImp implements ProyectoInvestigacionService{
	
	@Autowired
	private ProyectoInvestigacionRepository proyectoInv;

	@Override
	public List<ProyectoInvestigacion> listAll() {
		return proyectoInv.findAll();
	}

	@Override
	public ProyectoInvestigacion findById(Long id) {
		return proyectoInv.findById(id).orElse(null);
	}

	@Override
	public ProyectoInvestigacion save(ProyectoInvestigacion proyecto) {
		return proyectoInv.save(proyecto);
	}

	@Override
	public ProyectoInvestigacion update(ProyectoInvestigacion proyecto, long id) {
		ProyectoInvestigacion oldProyectoInv = proyectoInv.findById(id).orElse(null);
		if(oldProyectoInv != null) {
			oldProyectoInv.setTitulo(proyecto.getTitulo());
			oldProyectoInv.setFechaInicioPry(proyecto.getFechaInicioPry());
			oldProyectoInv.setFechaCierrePry(proyecto.getFechaCierrePry());
			oldProyectoInv.setEstadoPry(proyecto.getEstadoPry());
			oldProyectoInv.setPresupuestoPry(proyecto.getPresupuestoPry());
			
		}
		return proyectoInv.save(oldProyectoInv);
		/**
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long idProyInv;
		private String titulo;
		@Temporal(TemporalType.DATE)
		private Date fechaInicioPry;
		@Temporal(TemporalType.DATE)
		private Date fechaCierrePry;
		private String estadoPry;
		private float presupuestoPry;

		private Investigador responsable;
		@ManyToMany(mappedBy = "proyectos")
		private List<Investigador> investigadores = new ArrayList<>();
		@OneToMany(mappedBy = "proyecto")
		private List<AvanceProyecto> avance = new ArrayList<>(); **/
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		proyectoInv.deleteById(id);
	}

}
