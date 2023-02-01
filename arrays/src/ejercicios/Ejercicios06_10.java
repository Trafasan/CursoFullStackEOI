/**
 * 
 */
package ejercicios;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicios06_10 {
	public static void ejercicio06() {
		/*
		 * Crea un array de números enteros con 10 posiciones. Pregunta al usuario por un número y guarda
		 * en el array la tabla de multiplicar de dicho número. A continuación, recorre el array y muestra lo que tienes almacenado.
		 * Por ejemplo, si introducimos 6:
		 * 6 x 1 = 6
		 * 6 x 2 = 12
		 * 6 x 3 = 18 ...
		 */
		Scanner sc = new Scanner(System.in);
		int[] productos = new int [10];
		System.out.print("Introduzca un número: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i=0; i<productos.length; i++) {
			productos[i] = n*(i+1);
		}
		System.out.println("\nTabla de multiplicar del "+n);
		for (int i=0; i<productos.length; i++) {
			System.out.println(n+" x "+(i+1)+" = "+productos[i]);
		}
		sc.close();
	}

	public static void ejercicio07() {
		/*
		 * Crea un programa con 2 arrays que almacenen 10 números cada uno (pon los valores que quieras).
		 * Suma las posiciones de ambos arrays (usa un bucle) en un tercer array, y al final muestra los resultados:
		 * array3[0] = array1[0] + array2[0] ...
		 */
		int[] nums1 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
		int[] nums2 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
		int[] sumas = new int [nums1.length];
		for (int i=0; i<sumas.length; i++) {
			sumas[i] = nums1[i] + nums2[i];
			System.out.println(nums1[i]+" + "+nums2[i]+" = "+sumas[i]);
		}
	}

	public static void ejercicio08() {
		/*
		 * Crea un array de cadenas con 10 posiciones. Pide al usuario que introduzca 10 nombres.
		 * Por cada nombre introducido, debes comprobar que no existe ya en el array.
		 * Si existe, no lo guardes y vuelve a pedirle otro nombre.
		 */
		Scanner sc = new Scanner(System.in);
		String[] nombres = new String [10];
		for (int i=0; i<nombres.length; i++) {
			boolean nombreExistente = false;
			do {
				System.out.print("Introduzca un nombre ("+(i+1)+"/"+nombres.length+"): ");
				String nombre = sc.nextLine();
				for (int j=0; j<i; j++) {
					if (nombres[j].equals(nombre)) nombreExistente = true;
				}
				if (nombreExistente) System.out.println("El nombre ya existe en el array.");
				else nombres[i] = nombre;
			} while (nombreExistente);
		}
		for (String x:nombres) System.out.println(x);
		sc.close();
	}

	public static void ejercicio09() {
		/*
		 * Pide al usuario que escriba un nombre y guárdalo. A continuación, muestra las vocales que contiene ese nombre
		 * (debes recorrer la cadena y comparar sus caracteres).
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Vocales en "+nombre+": ");
		char[] vocales = {'a', 'á', 'e', 'é', 'i', 'í', 'o', 'ó', 'u', 'ú', 'ü'};
		vocales = Arrays.copyOf(vocales, vocales.length*2);
		for (int i=vocales.length/2; i<vocales.length; i++) {
			vocales[i] = Character.toUpperCase(vocales[i-(vocales.length/2)]);
		}
		for (int i=0; i<nombre.length(); i++) {
			char letra = nombre.charAt(i);
			boolean vocalEncontrada = false;
			for (char x:vocales) {
				if (x == letra) vocalEncontrada = true;
			}
			System.out.print((vocalEncontrada) ? letra : "_");
		}
		sc.close();
	}

	public static void ejercicio10(String[] args) { // No funciona si no se pone el String[] args entre paréntesis
		/*
		 * Crea un programa que reciba 2 parámetros de entrada. Esos 2 parámetros serán 2 números que el programa sumará
		 * y mostrará el resultado. Se debe comprobar que se han recibido esos 2 parámetros o mostrar un error.
		 * Recuerda que los parámetros se reciben como cadenas, por lo que hay que convertirlos a número.
		 */
		final int paramEntrada = 2;
		System.out.println(((args.length == paramEntrada) ? "S" : "No s")+"e recibieron "+paramEntrada+" parámetros");
		int[] nums = new int [args.length];
		for (int i=0; i<args.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
			System.out.print(args[i]+((i!=args.length-1)?" + ":" = "));
		}
		int suma=0;
		for (int n:nums) suma+=n;
		System.out.print(suma);
	}

	public static void main(String[] args) {
		// ejercicio06();
		// ejercicio07();
		// ejercicio08();
		// ejercicio09();
		// ejercicio10(args);
	}

}
