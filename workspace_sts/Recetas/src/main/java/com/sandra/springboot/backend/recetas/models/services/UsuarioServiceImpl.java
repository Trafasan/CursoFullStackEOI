package com.sandra.springboot.backend.recetas.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sandra.springboot.backend.recetas.models.dao.IusuarioDao;
import com.sandra.springboot.backend.recetas.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IusuarioService {
	
	@Autowired
	private IusuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(int id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	public void delete(int id) {
		usuarioDao.deleteById(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

}
