/**
 * 
 */
package ejerciciosTiposDeDatosBásicos;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicio09 {

	public static void main(String[] args) {
		// Pregúntale al usuario su nombre y muestra un mensaje saludándole con su nombre.
		Scanner entrada = new Scanner (System.in);
		String nombre;
		System.out.print("¿Cuál es su nombre? ");
		nombre = entrada.next();
		System.out.println("Hola "+nombre);
		entrada.close();

	}

}
