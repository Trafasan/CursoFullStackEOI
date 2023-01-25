/**
 * 
 */
package ejerciciosEstructurasDeControl;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicios16_20 {
	public static void ejercicio16() {
		// Pide al usuario un número y dibuja una línea con tantos asteriscos como el número introducido.
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un número: ");
		int n = sc.nextInt();
		for (int x = 0; x<n; x++) {
			System.out.print('#');
		}
		sc.close();
	}

	public static void ejercicio17() {
		// Muestra los números del 1 al 30 menos los divisibles entre 3 (resto da cero).
		Scanner sc = new Scanner(System.in);
		for (int x=1; x<=30; x++) {
			if (x%3 != 0) System.out.println(x);
		}
		sc.close();
	}

	public static void ejercicio18() {
		// Muestra de 5 en 5, los números del 0 al 100.
		int n = 0;
		while (n<=100){
			System.out.println(n);
			n+=5;
		}
	}
	
	public static void ejercicio18For() {
		for (int i=0; i<=100; i+=5) {
			System.out.println(i);
		}
	}

	public static void ejercicio19() {
		/*
		 * Pregunta al usuario un número y muestra del 1 hasta ese número, en una misma línea, separados por comas
		 * (debes comprobar cuando es el último y no poner una coma en ese caso).
		 * Dime un número: 7 1,2,3,4,5,6,7
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un número: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i=1; i<=n; i++) {
			System.out.print(i + ((i != n) ? ", " : ""));
		}
		sc.close();
	}

	public static void ejercicio20() {
		/*
		 * Repite el ejercicio 2 pero con un bucle infinito (la condición nunca será falsa). En este caso tendrás que comprobar dentro del bucle cuando el usuario
		 * ha introducido un cero para salir (break). Si el usuario introduce un número negativo no lo sumes (usa continue para saltarte la suma).
		 */
		Scanner sc = new Scanner(System.in);
		// Este ejercicio no se hace
		sc.close();
	}

	public static void main(String[] args) {
		// ejercicio16();
		// ejercicio17();
		// ejercicio18();
		// ejercicio18For();
		ejercicio19();
		// ejercicio20();
	}

}
