/**
 * 
 */
package ejerciciosTiposDeDatosBásicos;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicio14 {

	public static void main(String[] args) {
		// Pregunta al usuario su edad e infórmale de cuantos años tendrá dentro de 15.
		Scanner entrada = new Scanner (System.in);
		int edad;
		System.out.print("Inserte su edad: ");
		edad = entrada.nextInt();
		edad += 15;
		System.out.println("Dentro de 15 años, tendrá "+edad+" años.");
		entrada.close();

	}

}
