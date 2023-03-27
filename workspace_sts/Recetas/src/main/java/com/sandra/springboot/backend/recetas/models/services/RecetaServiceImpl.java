package com.sandra.springboot.backend.recetas.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sandra.springboot.backend.recetas.models.dao.IrecetaDao;
import com.sandra.springboot.backend.recetas.models.entity.Receta;

@Service
public class RecetaServiceImpl implements IrecetaService {
	
	@Autowired
	private IrecetaDao recetaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Receta> findAll() {
		return (List<Receta>) recetaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Receta findById(int id) {
		return recetaDao.findById(id).orElse(null);
	}

	@Override
	public void delete(int id) {
		recetaDao.deleteById(id);
	}

	@Override
	public Receta save(Receta receta) {
		return recetaDao.save(receta);
	}

}
