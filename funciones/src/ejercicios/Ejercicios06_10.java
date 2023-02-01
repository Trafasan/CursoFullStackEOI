/**
 * 
 */
package ejercicios;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicios06_10 {
	public static double ejercicio06(double... numeros) {
		// Crea una función que reciba un array de números y devuelva su media.
		double sumaN = 0;
		for (double n:numeros) sumaN += n;
		double media = sumaN/numeros.length;
		return media;
	}
	
	public static double ejercicio06Simple(double... numeros) {
		double media = Arrays.stream(numeros).average().getAsDouble();
		return media;
	}

	public static void ejercicio07() {
		
		Scanner sc = new Scanner(System.in);
		sc.close();
	}

	public static int ejercicio08(int... numeros) {
		/*
		 * Crea una función que reciba un número indeterminado de parámetros enteros y devuelva el máximo.
		 * Ten en cuenta que si recibes cero números, debes devolver cero también.
		 */
		int max = Integer.MIN_VALUE;
		if (numeros.length == 0) max = 0;
		for (int n:numeros) if (n>max) max=n;
		return max;
	}
	public static int ejercicio08S(Integer... numeros) {
		Arrays.sort(numeros, Collections.reverseOrder());
		int max = (numeros.length == 0) ? 0 : numeros[0];
		return max;
	}

	public static void ejercicio09() {
		
		Scanner sc = new Scanner(System.in);
		sc.close();
	}

	public static void ejercicio10() {
		
		Scanner sc = new Scanner(System.in);
		sc.close();
	}

	public static void main(String[] args) {
		/*
		 * double resultado06 = ejercicio06(12.45, 14.18, 25.94);
		 * System.out.println(resultado06); double resultado06S =
		 * ejercicio06Simple(12.45, 14.18, 25.94); System.out.println(resultado06S);
		 */
		// ejercicio07();
		/*
		 * int resultado08 = ejercicio08(2, 8, 99, 4, 1000, 9, 8);
		 * System.out.println(resultado08);
		 * int resultado08S = ejercicio08S(-2,-3,-10);
		 * System.out.println(resultado08S);
		 */
		// ejercicio08();
		// ejercicio09();
		// ejercicio10();
	}

}
