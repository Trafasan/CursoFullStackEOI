package com.sandra.ejemplo1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class PathVariableController {
	
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Ejemplo Variables");
		model.addAttribute("contenidoh1", "Contenido del H1");
		return "variables/index";
	}
	
	@GetMapping("/string/{texto}")
	public String ver(@PathVariable String texto, Model model) {
		model.addAttribute("titulo", "Ejemplo Variables");
		model.addAttribute("contenidoh1", "Contenido del Path Variable: "+texto);
		return "variables/ver";
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String ver(@PathVariable String texto, @PathVariable int numero, Model model) {
		model.addAttribute("titulo", "Ejemplo Variables");
		model.addAttribute("contenidoh1", "Contenido del Path Variable: "+texto+" y tiene el valor: "+numero);
		return "variables/ver";
	}

}
