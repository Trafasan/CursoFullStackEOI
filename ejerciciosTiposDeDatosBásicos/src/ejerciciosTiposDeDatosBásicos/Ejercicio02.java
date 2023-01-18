/**
 * 
 */
package ejerciciosTiposDeDatosBásicos;

/**
 * @author Sandra
 *
 */
public class Ejercicio02 {

	public static void main(String[] args) {
		/*
		 * Crea un programa con 2 variables de tipo entero con los valores 15 y 4. Para estos valores calcula la suma, la resta, la multiplicación, la división y el
		 * resto. Ten en cuenta que al ser 2 números enteros, el resultado de la división también será entero. Muestra por pantalla los resultados de esta manera:
		 * 15 + 4 = 19
		 * 15 – 4 = 11
		 * 15 / 4 = 3
		 * 15 * 4 = 60
		 * 15 % 4 = 3
		 */
		
		int n1 = 15, n2 = 4;
		
		System.out.println(n1+" + "+n2+" = "+(n1+n2));
		System.out.println(n1+" - "+n2+" = "+(n1-n2));
		System.out.println(n1+" / "+n2+" = "+(n1/n2));
		System.out.println(n1+" · "+n2+" = "+(n1*n2));
		System.out.println(n1+" % "+n2+" = "+(n1%n2));
	}

}
