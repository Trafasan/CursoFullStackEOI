/**
 * 
 */
package ejerciciosTiposDeDatosBásicos;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicio17 {

	public static void main(String[] args) {
		/*
		 * Pregúntale al usuario su nombre y edad. A continuación muestra la salida con este formato usando una única instrucción System.out.println.
		 * El espacio de la izquierda del nombre y edad es un tabulado.
		 * Estos son tus datos
		 * 	nombre: Pepe
		 * 	edad: 16
		 */
		Scanner entrada = new Scanner (System.in);
		String nombre;
		System.out.print("Inserte su nombre: ");
		nombre = entrada.next();
		int edad;
		System.out.print("Inserte su edad: ");
		edad = entrada.nextInt();
		System.out.println("Estos son sus datos\n	Nombre: "+nombre+"\n	Edad: "+edad);
		entrada.close();
	}

}
