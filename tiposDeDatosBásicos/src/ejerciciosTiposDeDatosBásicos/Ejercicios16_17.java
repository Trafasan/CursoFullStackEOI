/**
 * 
 */
package ejerciciosTiposDeDatosBásicos;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicios16_17 {
	public static void ejercicio16() {
		/*
		 * Dile al usuario que escriba 3 dígitos numéricos (no los muestres por la consola).
		 * A continuación suma los números e informa al usuario de su resultado: Has escrito: 2 + 5 + 8 = 15
		 */
		int n1, n2, n3;
		n1 = 2;
		n2 = 5;
		n3 = 8;
		int suma = n1+n2+n3;
		System.out.println(n1+" + "+n2+ " + "+n3+" = "+suma);
	}

	public static void ejercicio17() {
		/*
		 * Pregúntale al usuario su nombre y edad. A continuación muestra la salida con este formato usando una única instrucción System.out.println.
		 * El espacio de la izquierda del nombre y edad es un tabulado.
		 * Estos son tus datos
		 * 	nombre: Pepe
		 * 	edad: 16
		 */
		Scanner sc = new Scanner (System.in);
		String nombre;
		System.out.print("Inserte su nombre: ");
		nombre = sc.nextLine();
		int edad;
		System.out.print("Inserte su edad: ");
		edad = sc.nextInt();
		sc.nextLine();
		System.out.println("Estos son sus datos\n	Nombre: "+nombre+"\n	Edad: "+edad);
		sc.close();
	}

	public static void main(String[] args) {
		// ejercicio16();
		// ejercicio17();
	}

}
