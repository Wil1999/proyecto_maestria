package com.app_proyectos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app_proyectos.domain.ProyectoInvestigacion;
import com.app_proyectos.domain.Usuario;
import com.app_proyectos.repositories.UsuarioRepository;
import com.app_proyectos.service.UsuarioService;

public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioR;
	
	@Override
	public List<Usuario> listAll() {
		// TODO Auto-generated method stub
		return usuarioR.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return usuarioR.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioR.save(usuario);
	}

	@Override
	public Usuario update(Usuario usuario, long id) {
		// TODO Auto-generated method stub
		Usuario oldProyectoInv = usuarioR.findById(id).orElse(null);
		if(oldProyectoInv != null) {
			oldProyectoInv.setEmail(usuario.getEmail());
			oldProyectoInv.setPassword(usuario.getPassword());
			oldProyectoInv.setRol(usuario.getRol());
			
		}
		return usuarioR.save(oldProyectoInv);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		usuarioR.deleteById(id);
	}

}
