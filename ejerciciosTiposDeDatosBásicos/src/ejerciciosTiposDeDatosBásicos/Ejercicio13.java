/**
 * 
 */
package ejerciciosTiposDeDatosBásicos;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicio13 {

	public static void main(String[] args) {
		/*
		 * Programa que pida por teclado la fecha de nacimiento de una persona (dia, mes, año) y calcule su número de la suerte.
		 * El número de la suerte se calcula sumando el día, mes y año de la fecha de nacimiento y a continuación sumando las cifras obtenidas en la suma.
		 * Por ejemplo: Si la fecha de nacimiento es 12/07/1980 Calculamos el número de la suerte así:
		 * 12+7+1980 = 1999 1+9+9+9 = 28 Número de la suerte: 28
		 */
		Scanner entrada = new Scanner (System.in);
		int dd, mm, yyyy;
		System.out.println("Inserte su fecha de nacimiento");
		System.out.print("Día: ");
		dd = entrada.nextInt();
		System.out.print("Mes: ");
		mm = entrada.nextInt();
		System.out.print("Año: ");
		yyyy = entrada.nextInt();
		int n = dd+mm+yyyy;
		int n1 = n/1000;
		int n2 = (n-n1*1000)/100;
		int n3 = (n-n/100*100)/10;
		int n4 = n-n/10*10;
		int suerte = n1+n2+n3+n4;
		System.out.println("Su número de la suerte es "+suerte);
		entrada.close();
	}

}
