/**
 * 
 */
package ejercicios;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicios01_05 {
	public static void ejercicio01() {
		// Crea una función que te dibuje una fila de 20 asteriscos usando un bucle. Llámala desde el main 3 veces.
		funcion01();
		System.out.println();
		funcion01();
		System.out.println();
		funcion01();
	}
	public static void funcion01() {
		for (int i=0; i<20; i++) System.out.print('*');
	}

	public static void ejercicio02() {
		/*
		 * Crea una función que reciba una cadena y 2 números enteros por parámetro y te imprima si la longitud de la cadena
		 * está entre los 2 números o no. Llámala al menos 2 veces, una en la que sí esté en el rango, y otra en la que no.
		 */
		Scanner sc = new Scanner(System.in);
		sc.close();
	}
	public static void funcion02(String cadena, int n1, int n2) {
		
	}

	public static void ejercicio03() {
		
		Scanner sc = new Scanner(System.in);
		sc.close();
	}

	public static void ejercicio04() {
		
		Scanner sc = new Scanner(System.in);
		sc.close();
	}

	public static void ejercicio05() {
		
		Scanner sc = new Scanner(System.in);
		
		sc.close();
	}

	public static void main(String[] args) {
		ejercicio01();
		// ejercicio02();
		// ejercicio03();
		// ejercicio04();
		// ejercicio05();
	}

}
