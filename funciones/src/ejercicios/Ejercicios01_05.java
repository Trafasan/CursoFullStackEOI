/**
 * 
 */
package ejercicios;

/**
 * @author Sandra
 *
 */
public class Ejercicios01_05 {
	public static void ejercicio01() {
		// Crea una función que te dibuje una fila de 20 asteriscos usando un bucle. Llámala desde el main 3 veces.
		funcion01();
		System.out.println();
		funcion01();
		System.out.println();
		funcion01();
	}
	public static void funcion01() {
		for (int i=0; i<20; i++) System.out.print('*');
	}

	public static void ejercicio02() {
		/*
		 * Crea una función que reciba una cadena y 2 números enteros por parámetro y te imprima si la longitud de la cadena
		 * está entre los 2 números o no. Llámala al menos 2 veces, una en la que sí esté en el rango, y otra en la que no.
		 */
		funcion02("Hola", 1, 5);
		funcion02("Hola", 8, 7);
	}
	public static void funcion02(String cadena, int n1, int n2) {
		if ((n1<cadena.length() && cadena.length()<n2) || (n2<cadena.length() && cadena.length()<n1)) {
			System.out.println("La longitud de la cadena \""+cadena+"\" está entre "+n1+" y "+n2+'.');
		}
		else {
			System.out.println("La longitud de la cadena \""+cadena+"\" no está entre "+n1+" y "+n2+'.');
		}
	}

	public static void ejercicio03() {
		/*
		 * Crea una función que reciba un carácter y un número, dibuja un cuadrado usando ese carácter cuyo
		 * ancho y alto sea igual al número recibido. Prueba la función.
		 */
		funcion03('A', 4);
	}
	public static void funcion03(char caracter, int n) {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) System.out.print(caracter);
			System.out.println();
		}
	}

	public static void ejercicio04() {
		/*
		 * Crea una función con 2 parámetros. El primero será una cadena y representa al nombre de una persona, mientras que el segundo
		 * contendrá al resto de parámetros recibidos (…), que serán cadenas con los trabajos que la persona ha realizado.
		 * Imprime por consola el nombre de la persona seguido de la lista de trabajos realizados por la misma.
		 * Si no hay ningún trabajo, indica que no ha trabajado nunca. Prueba la función varias veces,
		 * al menos una de ellas no le pases ningún trabajo.
		 */
		funcion04("María", "Cocinera", "Camarera");
		System.out.println();
		funcion04("Jorge", "Investigador");
		System.out.println();
		funcion04("Sandra");
	}
	public static void funcion04(String nombre, String... trabajos) {
		System.out.println("Nombre: "+nombre);
		String lista = (trabajos.length == 0) ? "No ha trabajado nunca" : String.join(", ", trabajos);
		System.out.print("Lista de trabajos: "+lista);
	}

	public static void ejercicio05() {
		/*
		 * Crea una función que reciba un número y devuelva un booleano indicando si el número recibido es primo o no.
		 * Llama a la función varias veces y muestra el resultado devuelto.
		 * Recuerda que un número primo es aquel que solo es divisible (resto == 0) entre 1 y él mismo.
		 */
		System.out.println("¿El número 13 es primo? "+funcion05(13));
		System.out.println("¿El número 20 es primo? "+funcion05(20));
	}
	public static boolean funcion05(int n) {
		boolean esPrimo = true;
		for (int i=2; i<(n/2); i++)
			if(n%i == 0) {
				esPrimo = false;
				break;
			}
		return esPrimo;
	}

	public static void main(String[] args) {
		// ejercicio01();
		// ejercicio02();
		// ejercicio03();
		// ejercicio04();
		// ejercicio05();
	}

}
