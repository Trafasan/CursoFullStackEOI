package com.sandra.programacionFuncional.ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Ejercicios {
	
	public static void ejericicio01() {
		// A partir de una lista de números, devuelve la media de aquellos que sean mayores que 10.
		List<Integer> numeros = new ArrayList<>(Arrays.asList(10, 28 ,9, 37, 5, 46));
		OptionalDouble mediaOpcional = numeros.stream().mapToDouble(e->e).filter(e->e>10).average();
		System.out.println("La media de los números mayores de 10 es "+mediaOpcional.getAsDouble());
	}
	
	private static List<Persona> listaPersonas() {
		return new ArrayList<>(Arrays.asList(
				new Persona("Sandra", 23), new Persona("Ana", 16),
				new Persona("Jorge", 30), new Persona("Alejandro", 25)));
	}
	
	public static void ejericicio02() {
		/*
		 * A partir de una lista de personas (clase Persona con nombre y edad).
		 * Obtén los 2 primeros que sean mayores de 18 años y muéstralos por consola.
		 */
		listaPersonas().stream().filter(e->e.getEdad()>18).limit(2).forEach(System.out::println);
	}
	
	public static void ejericicio03() {
		// A partir de una lista de personas, devuelve sus nombres ordenados alfabéticamente.
		String nombres = listaPersonas().stream().map(e->e.getNombre()).sorted().collect(Collectors.joining(", "));
		System.out.println("Nombres ordenados alfabéticamente: "+nombres);
	}
	
	public static void ejericicio04() {
		// A partir de una lista de personas, devuelve los 3 nombres más largos separados por un guion.
		String nombres = listaPersonas().stream().map(e->e.getNombre())
				.sorted(Comparator.comparingInt(e->((String) e).length()).reversed())
				.limit(3).collect(Collectors.joining("-"));
		System.out.println("Los tres nombres más largos son "+nombres);
	}
	
	public static void ejericicio05() {
		// A partir de una lista de personas, devuelve la persona más joven y después muestra sus datos por consola.
		Optional<Persona> personaMasJoven = listaPersonas().stream().min(Comparator.comparingInt(Persona::getEdad));
		System.out.println("Persona más joven:\n"+personaMasJoven.get());
	}
	public static List<IFigura> listaFiguras() {
		return new ArrayList<>(Arrays.asList(
				new Circulo(2), new Cuadrado(2), new Circulo(3),
				new Cuadrado(3), new Circulo(4), new Cuadrado(4)));
	}
	
	public static void ejericicio06() {
		/*
		 * A partir de una lista de figuras geométricas (Interfaz IFigura y clases Cuadrado y
		 * Circulo creados en ejercicios anteriores). Obtén la figura con la mayor área y muéstrala.
		 */
		Optional<IFigura> figuraMaxArea = listaFiguras().stream().max(Comparator.comparingDouble(IFigura::getArea));
		System.out.println("Figura con la mayor área:\n"+figuraMaxArea.get());
	}
	
	public static void ejericicio07() {
		// Haz lo mismo que antes pero introduce un filtro. La figura debe ser de tipo Cuadrado obligatoriamente.
		Optional<IFigura> figuraMaxArea = listaFiguras().stream().filter(e->e instanceof Cuadrado).max(Comparator.comparingDouble(IFigura::getArea));
		System.out.println("Cuadrado con la mayor área:\n"+figuraMaxArea.get());
	}
}
