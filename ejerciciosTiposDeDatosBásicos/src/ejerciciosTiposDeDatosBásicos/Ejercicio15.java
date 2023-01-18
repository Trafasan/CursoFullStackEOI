/**
 * 
 */
package ejerciciosTiposDeDatosBásicos;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicio15 {

	public static void main(String[] args) {
		/*
		 * Pregunta al usuario el nombre de 3 productos con sus respectivos precios. Debes mostrar dichos datos formateados por la consola.
		 * El nombre tendrá 15 caracteres, el precio 12 (con 2 decimales) y finalmente, muestra el precio con IVA (21%), también con 12 caracteres y 2 decimales.
		 * El nombre debe estar alineado a la izquierda (espacios a la derecha) y los precios a la derecha.
		 * Ejemplo de salida:
		 * NOMBRE		PRECIO		CON IVA
		 * Consola 		279,95€		338,74€
		 * Coche azul	24300,00€	29403,00€
		 * Lámpara		45,50€		55,06€
		 */
		Scanner entrada = new Scanner (System.in);
		String[] nombre = new String[3];
		double[] precio = new double[3];
		for (int i=0; i<3; i++) {
			System.out.print("Inserte el nombre del producto ("+(i+1)+"/3): ");
			nombre[i] = entrada.next(); // Si se pone solo next(), solo devuelve el string hasta el espacio, por lo que da error
			entrada.nextLine(); // Esta línea soluciona el error anterior
			System.out.print("Inserte su precio: ");
			precio[i] = entrada.nextDouble();
		}
		double[] iva = new double[3];
		for (int i=0; i<3; i++) {
			iva[i] = precio[i]*1.21;
		}
		System.out.printf("%-15s%-15s%-15s\n", "NOMBRE", "PRECIO", "CON IVA");
		System.out.printf("%-15s%12.2f€%12.2f€\n", nombre[0], precio[0], iva[0]);
		System.out.printf("%-15s%12.2f€%12.2f€\n", nombre[1], precio[1], iva[1]);
		System.out.printf("%-15s%12.2f€%12.2f€\n", nombre[2], precio[2], iva[2]);
		entrada.close();

	}

}
