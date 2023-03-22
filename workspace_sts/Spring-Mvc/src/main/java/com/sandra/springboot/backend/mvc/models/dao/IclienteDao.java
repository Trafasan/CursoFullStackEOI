package com.sandra.springboot.backend.mvc.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sandra.springboot.backend.mvc.models.entity.Cliente;

public interface IclienteDao extends CrudRepository<Cliente, Long>{

}
