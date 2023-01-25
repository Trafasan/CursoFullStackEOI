/**
 * 
 */
package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class ArraysClase {
	
	public static void busquedaFuncional() {
		Scanner sc = new Scanner (System.in);
		String[] nombres = {"Juan", "Ana", "Pedro", "Eva", "Paco"};
		System.out.print("Introduzca un nombre: ");
		String buscar = sc.nextLine();
		if (Arrays.stream(nombres).anyMatch(n -> n.equals(buscar))) System.out.println("El nombre "+buscar+" está en el array");
		else System.out.println(buscar+" no encontrado...");
		sc.close();
	}
	
	public static void redireccion() {
		String[] nombres = {"Juan", "Ana", "Pedro", "Eva", "Paco"};
		nombres = Arrays.copyOf(nombres, 10);
		for (int i=0; i<nombres.length; i++) {
			System.out.println(nombres[i]);
		}
	}
	
	public static void contarLetras() {
		String[] nombres = {"Juan", "Ana", "Pedro", "Eva", "Paco"};
		nombres = Arrays.copyOf(nombres, 10);
		for (int i=0; i<nombres.length; i++) {
			if (nombres[i]!=null) System.out.println(nombres[i]+" tiene "+nombres[i].length()+" letras.");
		}
	}
	
	public static void bucleForEach() {
		String[] nombres = {"Juan", "Ana", "Pedro", "Eva", "Paco"};
		nombres = Arrays.copyOf(nombres, 10);
		for (String nombre:nombres) {
			if (nombre!=null) System.out.println(nombre+" tiene "+nombre.length()+" letras.");
		}
	}
	
	public static void redireccionInsercion() {
		Scanner sc = new Scanner (System.in);
		String[] alumnos = {"Juan", "Ana", "Pedro", "Eva", "Paco"};
		System.out.print("Introduzca el nombre del nuevo alumno: ");
		String nuevoAlumno = sc.nextLine();
		alumnos = Arrays.copyOf(alumnos, alumnos.length+1);
		alumnos[alumnos.length-1] = nuevoAlumno;
		for (String nombre:alumnos) System.out.println(nombre);
		sc.close();
	}
	
	public static void redireccionInsercionFuncional() {
		Scanner sc = new Scanner (System.in);
		String[] alumnos = {"Juan", "Ana", "Pedro", "Eva", "Paco"};
		System.out.print("Introduzca el nombre del nuevo alumno: ");
		String nuevoAlumno = sc.nextLine();
		alumnos = Arrays.copyOf(alumnos, alumnos.length+1);
		alumnos[alumnos.length-1] = nuevoAlumno;
		Arrays.stream(alumnos).forEach(e->System.out.println(e));
		sc.close();
	}
	
	public static void unirArraysEnCadena() {
		String[] alumnos = {"Juan", "Ana", "Pedro", "Eva", "Paco"};
		String cadenaAlumnos = String.join(", ", alumnos);
		System.out.println(cadenaAlumnos);
		
		// int[] nums = {11, 2, 4, 5, 3, 21, 80};
		// String cadenaNums = String.join(", ", nums);
		// System.out.println(cadenaNums);
	}
	
	public static void redireccionEliminacion() {
		String[] alumnos = {"Juan", "Ana", "Pedro", "Eva", "Paco"};
		alumnos = Arrays.copyOf(alumnos, alumnos.length-1);
		for (String nombre:alumnos) System.out.println(nombre);
	}
	
	public static void ordenarArrays() {
		String[] alumnos = {"Juan", "Ana", "Pedro", "Eva", "Paco"};
		System.out.println("Array sin ordenar: "+Arrays.toString(alumnos));
		Arrays.sort(alumnos);
		for (String nombre:alumnos) System.out.println(nombre);
		
		int[] nums = {11, 2, 4, 5, 3, 21, 80};
		System.out.println("Array sin ordenar: "+Arrays.toString(nums));
		Arrays.sort(nums);
		for (int n:nums) System.out.println(n);
	}
	
	public static void ordenarArraysInverso() {
		String[] alumnos = {"Juan", "Ana", "Pedro", "Eva", "Paco"};
		Arrays.sort(alumnos);
		System.out.print("Array ordenado de A a Z:");
		for (String nombre:alumnos) System.out.print(" "+nombre);
		Arrays.sort(alumnos, Collections.reverseOrder());
		System.out.print("\nArray ordenado de Z a A:");
		for (String nombre:alumnos) System.out.print(" "+nombre);
		
		Integer[] nums = {11, 2, 4, 5, 3, 21, 80};
		Arrays.sort(nums);
		System.out.print("\nArray ordenado de menor a mayor:");
		for (int n:nums) System.out.print(" "+n);
		Arrays.sort(nums, Collections.reverseOrder());
		System.out.print("\nArray ordenado de mayor a menor:");
		for (int n:nums) System.out.print(" "+n);
	}
	
	public static void main(String[] args) {
		// busquedaFuncional();
		// redireccion();
		// contarLetras();
		// bucleForEach();
		// redireccionInsercion();
		// redireccionInsercionFuncional();
		// unirArraysEnCadena();
		// redireccionEliminacion();
		// ordenarArrays();
		ordenarArraysInverso();
	}

}
