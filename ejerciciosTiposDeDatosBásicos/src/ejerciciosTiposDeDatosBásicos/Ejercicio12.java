/**
 * 
 */
package ejerciciosTiposDeDatosBásicos;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicio12 {

	public static void main(String[] args) {
		/*
		 * Programa que lea un número entero de 3 cifras y muestre por separado las cifras del número.
		 * Nota: Recuerda que la división entre enteros da como resultado la parte entera de la división (sin decimales).
		 * Si por ejemplo N = 123 la operación N/10 da como resultado 12 y no 12.3
		 * Recuerda que el operador % obtiene el resto de la división.
		 */
		Scanner entrada = new Scanner (System.in);
		int n;
		do {
			System.out.print("Inserte un número de tres cifras: ");
			n = entrada.nextInt();
		} while(n<100 || n>999);
		int n1 = n/100;
		int n2 = (n-n1*100)/10;
		int n3 = n-n/10*10;
		System.out.println("Primera cifra: "+n1);
		System.out.println("Segunda cifra: "+n2);
		System.out.println("Tercera cifra: "+n3);
		entrada.close();
		

	}

}
