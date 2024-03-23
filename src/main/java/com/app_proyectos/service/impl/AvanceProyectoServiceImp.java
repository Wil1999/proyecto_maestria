package com.app_proyectos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_proyectos.domain.AvanceProyecto;
import com.app_proyectos.repositories.AvanceProyectoRepository;
import com.app_proyectos.service.AvanceProyectoService;

@Service
public class AvanceProyectoServiceImp implements AvanceProyectoService{
	
	@Autowired
	private AvanceProyectoRepository avanceR;

	@Override
	public List<AvanceProyecto> listAll() {
		// TODO Auto-generated method stub
		return avanceR.findAll();
	}

	@Override
	public AvanceProyecto findById(Long id) {
		// TODO Auto-generated method stub
		return avanceR.findById(id).orElse(null);
	}

	@Override
	public AvanceProyecto save(AvanceProyecto avanceProyecto) {
		// TODO Auto-generated method stub
		return avanceR.save(avanceProyecto);
	}

	@Override
	public AvanceProyecto update(AvanceProyecto avanceProyecto, long id) {
		AvanceProyecto oldProyectoInv = avanceR.findById(id).orElse(null);
		if(oldProyectoInv != null) {
			oldProyectoInv.setDescripcionAvance(avanceProyecto.getDescripcionAvance());
			oldProyectoInv.setFechaRegistroAvance(avanceProyecto.getFechaRegistroAvance());
			oldProyectoInv.setEstadoAv(avanceProyecto.getEstadoAv());
			oldProyectoInv.setPresupuestoAsignado(avanceProyecto.getPresupuestoAsignado());
			oldProyectoInv.setPresupuestogastado(avanceProyecto.getPresupuestogastado());
			
		}
		return avanceR.save(oldProyectoInv);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		avanceR.deleteById(id);
	}

}
