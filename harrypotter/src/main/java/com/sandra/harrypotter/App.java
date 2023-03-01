package com.sandra.harrypotter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.sandra.harrypotter.entidades.Personaje;
import com.sandra.harrypotter.utilidades.JsonUtils;
import com.sandra.harrypotter.utilidades.SerializacionUtils;

public class App {
	static List<Personaje> personajes = new ArrayList<Personaje>();
	
    public static List<Personaje> recogerDatosApi() {
        return JsonUtils.devolverArrayGsonGenerico("https://hp-api.onrender.com/api/characters", Personaje[].class);
    }
	
    public static void mostrarDatosApi() {
        personajes = recogerDatosApi();
        personajes.stream().filter(e->e.getName().equals("Harry Potter")).forEach(System.out::println);
    }
	
    public static void rellenarLocalDate() {
        personajes = recogerDatosApi();
        personajes.stream().forEach(e->{
        	if (e.getDateOfBirth()!=null) 
        		e.setDateOfBirthLD(LocalDate.parse(e.getDateOfBirth(), DateTimeFormatter.ofPattern("dd-MM-yyy")));
        });
    }
	
    public static void ejemploSerializar() {
        System.out.println("La serialización "+((SerializacionUtils.serializarListaObjetos("personajes.dat", personajes))?"fue satisfactoria":"falló"));
    }
    
    public static void ejemploDesSerializar() {
    	personajes = SerializacionUtils.desSerializarListaObjetos("personajes.dat");
    }
    
    public static void mostrarPersonajes() {
    	personajes.forEach(System.out::println);
    }
    
    public static void mostrarPersonaje(String nombre) {
    	personajes.stream().filter(e->e.getName().equals(nombre)).forEach(System.out::println);
    }
	
	
    public static void main(String[] args) {
       ejemploDesSerializar();
       // mostrarPersonajes();
       mostrarPersonaje("Harry Potter");
    }
}
