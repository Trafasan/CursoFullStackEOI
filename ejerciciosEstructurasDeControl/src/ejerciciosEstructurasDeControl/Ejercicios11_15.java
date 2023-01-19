/**
 * 
 */
package ejerciciosEstructurasDeControl;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicios11_15 {
	public static void ejercicio11() {
		/*
		 * Pide al usuario 2 números. Después muestra al usuario un menú con las siguientes opciones: 1. Sumar, 2. Restar, 3. Multiplicar, 4. Dividir.
		 * Comprueba la opción elegida, haz la operación y muestra el resultado de la misma. Si la operación elegida es la división, comprueba que el segundo
		 * número (divisor) no sea cero antes de hacer la operación.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserte el primer número: ");
		double n1 = Double.parseDouble(sc.next());
		sc.nextLine();
		System.out.print("Inserte el primer número: ");
		double n2 = Double.parseDouble(sc.next());
		System.out.println("1. Sumar\n2. Restar\n3. Multiplicar\n4. Dividir");
		System.out.print("Inserte el número de la opereación que quiera realizar: ");
		int op = sc.nextInt();
		switch(op) {
		case 1:
			double suma = n1+n2;
			System.out.println(n1+" + "+n2+" = "+suma);
			break;
		case 2:
			double resta = n1-n2;
			System.out.println(n1+" - "+n2+" = "+resta);
			break;
		case 3:
			double mult = n1*n2;
			System.out.println(n1+" · "+n2+" = "+mult);
			break;
		case 4:
			if (n2 == 0) System.out.println("El divisor no puede ser 0.");
			else {
				double div = n1+n2;
				System.out.println(n1+" / "+n2+" = "+div);
			}
			break;
			default:
				System.out.println("No se reconoció la opción seleccionada");
		}
		sc.nextLine();
		sc.close();
	}

	public static void ejercicio12() {
		/*
		 * Crea una variable con el precio de una entrada que inicialmente valga 50. Pregunta al usuario su edad.
		 * a. Si es menor de edad se le hará un descuento del 25% en la entrada.
		 * b. Si es mayor de edad pero no está jubilado (65 años), pregúntale si es socio. Si el usuario responde “sí” hazle un descuento del 40%.
		 * c. Si está jubilado se le hará un descuento del 75%.
		 * d. Finalmente muéstrale el precio que tiene que pagar por la entrada
		 */
		Scanner sc = new Scanner(System.in);
		double precio = 50;
		System.out.print("Introduzca su edad: ");
		int edad = sc.nextInt();
		if (edad>=0 && edad<18) precio *= (1-0.25);
		else if (edad<65) {
			System.out.println("¿Es usted socio? Responda con Sí o No");
			String respuesta = sc.next();
			precio = respuesta.equals("Sí")?precio*(1-0.4):precio;
		}
		else if (edad>=65) precio*=(1-0.75);
		else System.out.println("La edad introducida es incorrecta.");
		System.out.println("El precio de su entrada es de "+precio+"€");
		sc.close();
	}

	public static void ejercicio13() {
		
		Scanner sc = new Scanner(System.in);
		sc.close();
	}

	public static void ejercicio14() {
		
		Scanner sc = new Scanner(System.in);
		sc.close();
	}

	public static void ejercicio15() {
		
		Scanner sc = new Scanner(System.in);
		sc.close();
	}

	public static void main(String[] args) {
		// ejercicio11();
		ejercicio12();
		// ejercicio13();
		// ejercicio14();
		// ejercicio15();
	}

}
