package com.sandra.colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void ejemplosListas() {
		// Lista que almacena números
		List<Integer> numeros = new ArrayList<>();
		// Podemos establecer una capacidad inicial reservada
		List<Integer> numeros2 = new ArrayList<>(12);
		// Se puede crear una lista a partir de un array
		Integer[] array = {2, 3, 5};
		List<Integer> numeros3 = new ArrayList<>(Arrays.asList(array)); // Lista con valores iniciales
		// Se puede crear una lista a partir de otra colección
		List<Integer> numeros4 = new ArrayList<Integer>(numeros2);
		
		// Arrays y listas multidimensionales
		Integer[][] matriz = new Integer[4][5];
		List<List<Integer>> listaDeListas= new ArrayList<List<Integer>>();
		Integer[][][] show_red = new Integer[1024][728][128];
		List<List<List<Integer>>> lista3Dimensiones= new ArrayList<List<List<Integer>>>();
		
		List<String> cadenas = new ArrayList<>(); // Desde Java 8 no hace falta poner la segunda vez el tipo de lista
		cadenas.add("Hola"); // Añadir en la última posición
		cadenas.add("Adiós");
		cadenas.add("Hola"); // Las listas permiten elementos repetidos
		cadenas.add(1, "Mundo"); // Añadir en una posición determinada ya existente
		System.out.println("Creación de la lista cadenas:");
		cadenas.forEach(e->System.out.println(e));
		
		List<String> otra = Arrays.asList("Hola", "en", "minúscula"); // Otra forma de crear una lista con valores iniciales
		cadenas.addAll(otra);
		System.out.println("Se ha añadido la lista otra a la lista cadenas:");
		cadenas.forEach(e->System.out.println(e));
		
		System.out.println("Tamaño lista numeros3: "+numeros3.size());
		numeros3.clear();
		System.out.println("Tamaño lista numeros3: "+numeros3.size());
	}
	
    public static void main(String[] args) {
        ejemplosListas();
    }
}
