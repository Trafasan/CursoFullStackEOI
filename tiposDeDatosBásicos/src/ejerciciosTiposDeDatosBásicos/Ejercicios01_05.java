/**
 * 
 */
package ejerciciosTiposDeDatosBásicos;

/**
 * @author Sandra
 *
 */
public class Ejercicios01_05 {
	public static void ejercicio01() {
		//Crea un programa que diga el resultado de sumar 36 y 27.
				int n1 = 36, n2 = 27;
				System.out.println(n1+" + "+n2+" = "+(n1+n2));
	}

	public static void ejercicio02() {
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

	public static void ejercicio03() {
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

	public static void ejercicio04() {
		/*
		 * Crea 4 variables de tipo double con los valores que quieras. A continuación muestra sus valores por consola usando 4 instrucciones para imprimir por
		 * consola y sin generar ningún salto de línea (todos los valores se verán en una sola línea)
		 * A continuación, muestra el resultado de sumar las 2 primeras variables, multiplicar el resultado por la tercera y dividir por la cuarta.
		 * Pista: la suma tiene menos prioridad que la multiplicación, por lo que necesitarás agrupar dicha operación entre paréntesis.
		 */
		double n1 = 7.01, n2 = 5.63, n3 = 2.49, n4 = 1.84;
		System.out.print(n1+" ");
		System.out.print(n2+" ");
		System.out.print(n3+" ");
		System.out.print(n4+"\n");
		double resultado = (n1+n2)*n3/n4;
		System.out.println("("+n1+" + "+n2+") · "+n3+" / "+n4+" = "+resultado);
		System.out.printf("(%.2f + %.2f) · %.2f / %.2f = %.2f", n1, n2, n3, n4, resultado);
	}

	public static void ejercicio05() {
		/*
		 * Escribe un programa que declare una variable entera N y asígnale un valor. A continuación escribe las instrucciones que realicen los siguientes:
		 * a. Incrementar N en 77.
		 * b. Decrementarla en 3.
		 * c. Duplicar su valor.
		 * Si por ejemplo N vale 1, la salida del programa será:
		 * Valor inicial de N = 1
		 * N + 77 = 78
		 * N - 3 = 75
		 * N * 2 = 150
		 */
		
		int N = 1;
		System.out.println("Valor inicial de N = "+N);
		N += 77;
		System.out.println("N + 77 = "+N);
		N -= 3;
		System.out.println("N - 3 = "+N);
		N *= 2;
		System.out.println("N · 2 = "+N);
	}

	public static void main(String[] args) {
		// ejercicio01();
		// ejercicio02();
		// ejercicio03();
		// ejercicio04();
		// ejercicio05();
	}

}
