/**
 * 
 */
package ejercicios;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sandra
 *
 */
public class Ejercicios06_10 {
	public static void ejercicio06() {
		// Crea una función que reciba un array de números y devuelva su media.
		double resultado06 = funcion06(12.45, 14.18, 25.94);
		System.out.println(resultado06);
		double resultado06S = funcion06Simple(12.45, 14.18, 25.94);
		System.out.println(resultado06S);
	}
	public static double funcion06(double... numeros) {
		double sumaN = 0;
		for (double n:numeros) sumaN += n;
		double media = sumaN/numeros.length;
		return media;
	}
	public static double funcion06Simple(double... numeros) {
		double media = Arrays.stream(numeros).average().getAsDouble();
		return media;
	}

	public static void ejercicio07() {
		/*
		 * Crea una función que reciba un array de cadenas por parámetro y devuelva una de las cadenas al azar.
		 * Pista: puedes generar un número aleatorio entre 0 y la última posición del array usando new Random().nextInt(array.length).
		 * A continuación pide al usuario que adivine la palabra seleccionada (tiene 3 intentos, usa un bucle).
		 * Si la acierta felicítale, y si no, dile cual era la correcta.
		 */
		String respuesta = funcion07("Sandra", "Jorge", "Helena", "Alejandro");
		System.out.println(respuesta);
	}
	public static String funcion07(String... cadenas) {
		Scanner sc = new Scanner (System.in);
		final int maxIntentos = 3;
		mostrarElementos(cadenas);
		String cadenaElegida = devolverAzar(cadenas);
		boolean acierto = false;
		int intento = 0;
		do {
			intento++;
			System.out.println("Intento nº"+intento+" de "+maxIntentos);
			System.out.print("Introduzca una cadena: ");
			String respuesta = sc.nextLine();
			if (respuesta.equals(cadenaElegida)) {
				acierto = true;
				break;
			}
		} while (intento<maxIntentos);
		String contestacion = ((acierto) ? "Felicidades, acertaste en tu intento nº"+intento : "Se quedó sin intentos. La cadena correcta era "+cadenaElegida)+'.';
		sc.close();
		return contestacion;
	}
	public static String devolverAzar(String... cadenas) {
		int n = new Random().nextInt(cadenas.length);
		String cadenaElegida = cadenas[n];
		return cadenaElegida;
	}
	public static void mostrarElementos(String... cadenas) {
		System.out.print("Posibles respuestas:");
		Arrays.stream(cadenas).forEach(e->System.out.print(" "+e)); // Programación funcional de un bucle for each
		System.out.println();
		// System.out.println("Posibles respuestas: "+String.join(", ", cadenas)); también serviría
	}

	public static void ejercicio08() {
		/*
		 * Crea una función que reciba un número indeterminado de parámetros enteros y devuelva el máximo.
		 * Ten en cuenta que si recibes cero números, debes devolver cero también.
		 */
		int resultado08 = funcion08(2, 8, 99, 4, 1000, 9, 8);
		System.out.println(resultado08);
		int resultado08S = funcion08S(-2,-3,-10);
		System.out.println(resultado08S);
	}
	public static int funcion08(int... numeros) {
		int max = Integer.MIN_VALUE;
		if (numeros.length == 0) max = 0;
		for (int n:numeros) if (n>max) max=n;
		return max;
	}
	public static int funcion08S(Integer... numeros) {
		Arrays.sort(numeros, Collections.reverseOrder());
		int max = (numeros.length == 0) ? 0 : numeros[0];
		return max;
	}

	public static void ejercicio09() {
		/*
		 * Crea una función que reciba una cadena y una subcadena por parámetro y devuelva cuantas veces aparece la
		 * subcadena dentro de la cadena. Para ello debes saber que como segundo parámetro a indexOf le puedes pasar
		 * la posición a partir de la cual buscar (empezaríamos en cero). Cuando te devuelva -1 es que ya no la ha
		 * encontrado (utiliza un bucle).
		 * Por ejemplo, si recibimos “cocinando cocos con chocolate” y “co” devolveremos el número 4.
		 */
		int respuesta = funcion09("cocinando cocos con chocolate", "co");
		int respuestaS = funcion09S("cocinando cocos con chocolate", "co");
		int respuesta2 = funcion09("cocinando cococos con chococolate", "coco");
		int respuesta2S = funcion09S("cocinando cococos con chococolate", "coco");
		System.out.println(respuesta);
		System.out.println(respuestaS);
		System.out.println(respuesta2);
		System.out.println(respuesta2S);
	}
	public static int funcion09(String cadena, String subcadena) {
		int comienzo = 0;
		int contador = 0;
		while (comienzo<cadena.length()) {
			int coincidencia = cadena.indexOf(subcadena, comienzo);
			 if (coincidencia == -1) break;
			 comienzo = coincidencia+subcadena.length();
			 contador++;
		}
		return contador;
	}
	public static int funcion09S(String cadena, String subcadena) {
		int contador = 0;
		Pattern patron = Pattern.compile(subcadena);
		Matcher coincidencia = patron.matcher(cadena);
		while (coincidencia.find()) contador++;
		return contador;
	}
	
	public static void ejercicio10() {
		/*
		 * Crea una función que reciba una cadena, un separador (char) y un número n. La función insertará el separador dentro
		 * de la cadena cada n caracteres (ten en cuenta que al insertar el separador, la siguiente posición se incrementa en 1.
		 * Por ejemplo, si recibimos “Hay una mosca en mi sopa”, ‘*’ y 3, devolveremos “Hay* un*a m*osc*a e*n m*i s*opa*”
		 */
		String respuesta = funcion10("Hay una mosca en mi sopa", '*', 3);
		System.out.println(respuesta);
	}
	public static String funcion10(String cadena, char separador, int n) {
		String cadenaSeparada = "";
		for (int i=0; i<cadena.length(); i+=n) {
			cadenaSeparada+=cadena.substring(i, i+n) + separador;
		}
		return cadenaSeparada;
	}

	public static void main(String[] args) {
		// ejercicio06();
		// ejercicio07();
		// ejercicio08();
		// ejercicio08();
		ejercicio09();
		// ejercicio10();
	}

}
