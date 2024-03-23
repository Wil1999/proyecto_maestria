package com.app_proyectos.service;

import java.util.List;

import com.app_proyectos.domain.Usuario;

public interface UsuarioService {
	List<Usuario> listAll();
	Usuario findById(Long id);
	Usuario save(Usuario usuario);
	Usuario update(Usuario usuario, long id);
	void delete(Long id);
}
