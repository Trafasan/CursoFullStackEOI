/**
 * 
 */
package ejerciciosTiposDeDatosBásicos;

/**
 * @author Sandra
 *
 */
public class Ejercicio8 {
	
	public static void main(String[] args) {
		/*
		 * ¿Cuál sería el resultado de las siguientes operaciones? a=5; b=++a; c=a++; b=b*5; a=a*2;
		 * Calcúlalo a mano y luego crea un programa que lo resuelva, para ver si habías hallado la solución correcta.
		 */
		int a = 5;
		System.out.println("Valor inicial de a: "+a);
		int b = ++a; // Primero aumenta el valor de a y luego se igualan los valores
		System.out.println("Valor de b: "+b);
		int c = a++; // Primero se igualan los valores y luego aumenta el valor de a
		System.out.println("Valor de c: "+c);
		b = b*5;
		System.out.println("Valor de b: "+b);
		a=a*2;
		System.out.println("Valor de a: "+a);
	}

}
