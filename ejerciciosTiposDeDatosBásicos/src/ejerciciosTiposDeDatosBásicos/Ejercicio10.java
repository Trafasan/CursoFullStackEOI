/**
 * 
 */
package ejerciciosTiposDeDatosBásicos;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicio10 {

	public static void main(String[] args) {
		// Escribe un programa que lee un número entero por teclado y obtiene y muestra por pantalla el doble y el triple de ese número.
		Scanner entrada = new Scanner (System.in);
		int n;
		System.out.print("Inserte un número: ");
		n = entrada.nextInt();
		int n2 = n*2, n3 = n*3;
		System.out.println("El doble de ese número es "+n2);
		System.out.println("El triple de ese número es "+n3);
		entrada.close();

	}

}
