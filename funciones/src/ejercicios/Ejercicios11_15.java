/**
 * 
 */
package ejercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Sandra
 *
 */
public class Ejercicios11_15 {
	public static void ejercicio11() {
		// Crea una función que reciba una cadena con una serie de números separados por punto y coma “;”, y devuelva la media de dichos números.
		double resultado = funcion11("12.54;5.98;20.49;16.06");
		System.out.println(resultado);
	}
	public static double funcion11(String numeros) {
		String[] arrayCad = numeros.split(";");
		double[] arrayNums = new double [arrayCad.length];
		for (int i=0; i<arrayCad.length; i++) arrayNums[i] = Double.parseDouble(arrayCad[i].replace(',', '.'));
		double media = Arrays.stream(arrayNums).average().getAsDouble();
		return media;
	}

	public static void ejercicio12() {
		// Crea una función que reciba un array de cadenas y te lo devuelva ordenado alfabéticamente de la ‘z’ a la ‘a’.
		funcion12("Jorge", "Sandra", "Alejandro", "Yaiza"); 
	}
	public static void funcion12(String... cadenas) {
		Arrays.sort(cadenas, Collections.reverseOrder());
		for (String cadena:cadenas) System.out.println(cadena);
	}

	public static void ejercicio13() {
		// Crea una función que reciba un array de números y un número. y te devuelva cuantas veces aparece ese número en el array.
		String respuesta = funcion13(13, 11, 45, 60, 13, 28, 37, 13);
		System.out.println(respuesta);
	}
	public static String funcion13(int n, int... nums) {
		String [] numsCadenas = new String [nums.length];
		for (int i=0; i<nums.length; i++) numsCadenas[i] = Integer.toString(nums[i]);
		int contador = 0;
		for (String cadena:numsCadenas) {
			boolean coincidencia = cadena.equals(Integer.toString(n));
			if (coincidencia) contador++;
		}
		String respuesta = "El número "+n+" aparece "+contador+" veces en el array.";
		return respuesta;
	}
	
	public static void ejercicio14() {
		/*
		 * Crea una función que a partir de una fecha (LocalDateTime) que reciba por parámetro, te devuelva una cadena con la fecha en el siguiente formato:
		 * Si recibimos la siguiente fecha “04/07/2019”, devolvería “Jueves, 4 de julio de 2019”.
		 */
		LocalDate fecha = LocalDate.parse("04/07/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String fechaEscrita = funcion14(fecha);
		System.out.println(fechaEscrita);
	}
	public static String funcion14(LocalDate fecha) {
		String[] dias = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
		String stringDia = dias[fecha.getDayOfWeek().getValue()];
		int numberDia = fecha.getDayOfMonth();
		String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
		String mes = meses[fecha.getMonthValue()-1];
		int year = fecha.getYear();
		String fechaEscrita = stringDia+", "+numberDia+" de "+mes+" de "+year;
		return fechaEscrita;
	}
	
	public static void ejercicio15() {
		/*
		 * Crea una función que reciba una fecha en formato dd-mm-yyyy, conviértela a fecha (LocalDate) utilizando la función subString
		 * o split para extraer el día, mes y año, o usa el DateTimeFormatter, súmale 2 años, 3 meses y 5 días, y muestra la fecha resultante.
		 */
		String resultado = funcion15("24-11-2021");
		System.out.println(resultado);
	}
	public static String funcion15(String stringFecha) {
		DateTimeFormatter formateo = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fecha = LocalDate.parse(stringFecha, formateo);
		LocalDate fechaNueva = fecha.plusYears(2).plusMonths(3).plusDays(5);
		String resultado = fechaNueva.format(formateo);
		return resultado;
	}

	public static void main(String[] args) {
		// ejercicio11();
		// ejercicio12();
		// ejercicio13();
		// ejercicio14();
		// ejercicio15();
	}

}
