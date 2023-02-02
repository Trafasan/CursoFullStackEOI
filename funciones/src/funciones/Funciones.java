/**
 * 
 */
package funciones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Sandra
 *
 */
public class Funciones {
	public static void cambiarVariables() {
		int v1 = 5;
		int v2 = 10;
		parametrosValor(v1, v2);
		System.out.println("Número 1: "+v1+"\nNúmero 2: "+v2);
		// Imprime 5 y 10 ya que la función utiliza copias de v1 y v2
		int[] v1ref = {v1};
		parametrosReferencia(v1ref);
		System.out.println("Número 1: "+v1ref[0]);
		// Imprime 6, en los arrays sí que se cambian los valores
		
	}
	public static void parametrosValor(int v1, int v2) {
		v1++;
		v2++;
	}
	public static void parametrosReferencia(int[] valores) {
		valores[0]++;
	}
	
	public static void claseMath() {
		double n1 = -23.40;
		double n2 = 2.449532;
		
		System.out.println("Valor absoluto de "+n2+": "+Math.abs(n1)); // Devuelve el valor absoluto
		System.out.println(n2+" redondeado es igual a "+Math.round(n2)); // Redondea a int
		System.out.println(n1+" redondeado es igual a "+Math.round(n1));
		System.out.println("El número superior a "+n2+" es "+Math.ceil(n2));  // Imprime el int superior
		System.out.println("El número superior a "+n1+" es "+Math.ceil(n1));
		System.out.println("El número inferior a "+n2+" es "+Math.floor(n2));  // Trunca a int
		System.out.println("El número inferior a "+n1+" es "+Math.floor(n1));
		System.out.println(Math.max(23, 43));
		System.out.println(Math.min(4, 5));
		System.out.println(Math.sqrt(25));
		System.out.println(Math.pow(5, 2));
	}
	
	public static void formatoFecha() {
		LocalDate fecha = LocalDate.now();
		String formatoFecha = fecha.format(DateTimeFormatter.ofPattern("'Hoy es 'eeee dd/MM/yyyy")); // Hoy es jueves 02/02/2023
		System.out.println(formatoFecha);
		String formatoFecha2 = fecha.format(DateTimeFormatter.ofPattern("'Hoy es 'eee dd/MMMM/yyyy")); // Hoy es jue 02/febrero/2023
		System.out.println(formatoFecha2);
	}
	
	public static void main(String[] args) {
		// cambiarVariables();
		// claseMath();
		formatoFecha();
	}

}
