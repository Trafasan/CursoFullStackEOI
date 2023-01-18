/**
 * 
 */
package ejerciciosTiposDeDatosBásicos;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicio11 {

	public static void main(String[] args) {
		/*
		 * Programa que lea una cantidad de grados centígrados y la pase a grados Fahrenheit.
		 * La fórmula correspondiente para pasar de grados centígrados a fahrenheit es:
		 * F = 32 + ( 9 * C / 5)
		 */
		Scanner entrada = new Scanner (System.in);
		float grados;
		System.out.print("Inserte la temperatura en grados Celsius: ");
		grados = entrada.nextFloat();
		grados = 32+(9*grados/5);
		System.out.println("La temperatura en grados Fahrenheit es "+grados);
		entrada.close();
	}

}
