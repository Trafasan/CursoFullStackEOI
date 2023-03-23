package com.sandra.springboot.backend.eventos.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandra.springboot.backend.eventos.models.dto.EventoDto;
import com.sandra.springboot.backend.eventos.models.entity.Evento;
import com.sandra.springboot.backend.eventos.models.services.IeventoService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/eventos")
public class EventoRestController {
	
	@Autowired
	private IeventoService eventoService;
	
	/*@GetMapping("")
	public List<Evento> index() {
		return eventoService.findAll();
	}*/
	
	@GetMapping("")
	public ResponseEntity<?> index() {
		List<Evento> listaEventos = new ArrayList<>();
		Map<String,Object> response = new HashMap<>();
		try {
			listaEventos = eventoService.findAll();
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Evento>>(listaEventos,HttpStatus.OK);
	}
	
	@GetMapping("/dto")
	public List<EventoDto> indexDto() {
		List<EventoDto> listaDto = new ArrayList<>();
		eventoService.findAll().forEach(evento->
			listaDto.add(new EventoDto(evento.getId(), evento.getNombre(), evento.getDescripcion(), evento.getUsuarios())));
		return listaDto;
	}
	
	/*@GetMapping("/{id}")
	public Evento show(@PathVariable int id) {
		return eventoService.findById(id);
	}*/
	
	@GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable int id) {
		Evento evento = null;
		Map<String, Object> response = new HashMap<>();
		try {
			evento = eventoService.findById(id);
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (evento==null) {
			response.put("mensaje", "El evento con ID ".concat(Integer.toString(id)).concat(" no existe"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Evento>(evento, HttpStatus.OK);
	}
	
	/*@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		eventoService.delete(id);
	}*/
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		Map<String,Object> response = new HashMap<>();
		try {
			eventoService.delete(id);
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al eliminar el ID");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El evento se ha borrado correctamente");
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	/*@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Evento create(@RequestBody Evento evento) {
		return eventoService.save(evento);
	}*/
	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody Evento evento, BindingResult result){
		Evento eventoNew = null;
		Map<String,Object> response = new HashMap<>();
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			eventoNew = eventoService.save(evento);
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El evento se ha insertado correctamente");
		response.put("evento", eventoNew);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	/*@PutMapping("/{id}")
	public Evento update(@RequestBody Evento evento, @PathVariable int id) {
		Evento eventoActualizar = eventoService.findById(id);
		eventoActualizar.setNombre(evento.getNombre());
		eventoActualizar.setDescripcion(evento.getDescripcion());
		eventoActualizar.setPrecio(evento.getPrecio());
		eventoActualizar.setFecha(evento.getFecha());
		return eventoService.save(eventoActualizar);
	}*/
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Evento evento, @PathVariable int id, BindingResult result){
		Evento eventoActual = null;
		Evento eventoUpdated = null;
		Map<String,Object> response = new HashMap<>();
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			eventoActual = eventoService.findById(id); // El evento puede existir o no
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(eventoActual==null) { // No existe en la base de datos
			response.put("mensaje", "El evento con ID ".concat(Integer.toString(id)).concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		// Si llegamos aquí es que el evento que queremos modificar SI existe
		try {
			eventoActual.setNombre(evento.getNombre());
			eventoActual.setDescripcion(evento.getDescripcion());
			eventoActual.setPrecio(evento.getPrecio());
			eventoActual.setFecha(evento.getFecha());
			eventoUpdated = eventoService.save(eventoActual);
		} catch (DataAccessException e) {  // Error al acceder a la base de datos
			response.put("mensaje", "Error al conectar con la base de datos");
			response.put("error", e.getMessage().concat(":")
					.concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El evento se ha modificado correctamente");
		response.put("evento", eventoUpdated);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
}
