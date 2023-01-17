/**
 * 
 */
package ejerciciosTiposDeDatosBásicos;

/**
 * @author Sandra
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		/*
		 * Crea 2 variables enteras con el mismo valor en la misma línea (declaración y asignación) y muestra la siguiente información:
		 * a. Si la primera variable es menor que la segunda
		 * b. Si son iguales
		 * c. Si la primera variable es mayor o igual que la segunda
		 * Muestra el resultado indicando si la comparación es True o False (valor del booleano). Ejemplo: 6 es menor que 6: False
		 */
		int n1 = 13, n2 = n1;
		boolean a = n1 < n2;
		boolean b = n1 == n2;
		boolean c = n1 >= n2;
		System.out.println("¿La primera variable es menor que la segunda? "+a);
		System.out.println("¿Las dos variables son iguales? "+b);
		System.out.println("¿La primera variable es mayor o igual que la segunda? "+c);
	}

}
