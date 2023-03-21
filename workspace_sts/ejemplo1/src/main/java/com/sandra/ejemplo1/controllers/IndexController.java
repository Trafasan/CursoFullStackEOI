package com.sandra.ejemplo1.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sandra.ejemplo1.entidades.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping({"/index","/","","/home"})
	public String index(Map<String, Object> map) {
		map.put("titulo", "Programa de prueba");
		map.put("contenidoh1", "Esto es un H1 de prueba");
		return "index";
	}

	@GetMapping("/perfil")
	public String perfil(Map<String, Object> map) {
		map.put("titulo", "Perfil del usuario");
		map.put("usuario", new Usuario("Fran", "García"));
		return "perfil";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Collections.addAll(usuarios, new Usuario("Fran", "García", "fran@iessanvicente.com"),
				new Usuario("Sandra", "Requena", "sandrarequena1999@gmail.com"), new Usuario("Jorge", "Ortuño"));
		return usuarios;
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Lista de usuarios");
		return "listar";
	}
}
