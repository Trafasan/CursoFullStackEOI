package com.sandra.ejemplo1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class RequestParamController {
	
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Ejemplo Param");
		model.addAttribute("contenidoh1", "Contenido del H1");
		return "params/index";
	}
	
	@GetMapping("/string")
	public String ver(@RequestParam(name="texto",required=false,defaultValue="Texto por defecto") String texto,
			Model model) {
		model.addAttribute("titulo", "Ejemplo Param");
		model.addAttribute("contenidoh1", "El texto por parámetro es: "+texto);
		return "params/ver";
	}
	
	@GetMapping("/dosparam")
	public String dosp(@RequestParam String param1, @RequestParam int param2,
			Model model) {
		model.addAttribute("titulo", "Ejemplo con dos parámetros");
		model.addAttribute("contenidoh1", "El valor del primer parámetro es "+param1+" y el del segundo+1 es "+(param2+1));
		return "params/dosp";
	}
	
}
