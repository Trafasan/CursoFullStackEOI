package com.sandra.springboot.backend.mvc.models.services;

import java.util.List;

import com.sandra.springboot.backend.mvc.models.entity.Cliente;

public interface IclienteService {
	
	public List<Cliente> findAll();
	public Cliente findById(Long id);
	public void delete(Long id);
	public Cliente save(Cliente cliente);
	
}
