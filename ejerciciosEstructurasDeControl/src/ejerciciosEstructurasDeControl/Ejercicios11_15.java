/**
 * 
 */
package ejerciciosEstructurasDeControl;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		System.out.print("Inserte el segundo número: ");
		double n2 = Double.parseDouble(sc.next());
		System.out.println("1. Sumar\n2. Restar\n3. Multiplicar\n4. Dividir");
		System.out.print("Seleccione el número de la opereación que quiera realizar: ");
		int op = sc.nextInt();
		sc.nextLine();
		switch(op) {
		case 1 -> {
			double suma = n1+n2;
			System.out.println(n1+" + "+n2+" = "+suma);
		}
		case 2 -> {
			double resta = n1-n2;
			System.out.println(n1+" - "+n2+" = "+resta);
		}
		case 3 -> {
			double mult = n1*n2;
			System.out.println(n1+" · "+n2+" = "+mult);
		}
		case 4 -> {
			if (n2 == 0) System.out.println("El divisor no puede ser 0.");
			else {
				double div = n1+n2;
				System.out.println(n1+" / "+n2+" = "+div);
			}
		}
			default -> System.out.println("No se reconoció la opción seleccionada");
		}
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
		final double MENOR_EDAD = 0.25;
		final double DESCUENTO_SOCIO = 0.4;
		final double DESCUENTO_JUBILADO = 0.75;
		
		System.out.print("Introduzca su edad: ");
		int edad = sc.nextInt();
		sc.nextLine();
		if (edad>=0 && edad<18) precio *= (1-MENOR_EDAD);
		else if (edad<65) {
			System.out.println("¿Es usted socio? Responda con Sí o No");
			String respuesta = sc.next();
			
			Pattern regex = Pattern.compile("^s[iíÍ]?$", Pattern.CASE_INSENSITIVE);
			Matcher m = regex.matcher(respuesta);
			if(m.matches()) precio = precio * (1 - DESCUENTO_SOCIO);
			//precio = respuesta.equals("Sí")?precio*(1-DESCUENTO_SOCIO):precio;
		}
		else if (edad>=65) precio*=(1-DESCUENTO_JUBILADO);
		else System.out.println("La edad introducida es incorrecta.");
		System.out.printf("El precio de su entrada es de %.2f€.\n",precio);
		sc.close();
	}
	public static void ejercicio12Grupo() {
		Scanner sc = new Scanner(System.in);
		final double precioEntrada = 50;
		final double MENOR_EDAD = 0.25;
		final double DESCUENTO_SOCIO = 0.4;
		final double DESCUENTO_JUBILADO = 0.75;
		final int MAYORIA_EDAD = 18;
		final int EDAD_JUBILACION = 65;
		double total = 0;
		System.out.print("Número de personas en el grupo: ");
		int personas = sc.nextInt();
		
		for (int x=0; x<personas; x++) {
			double precio = precioEntrada;
			System.out.print("Introduzca su edad ("+(x+1)+"/"+personas+"): ");
			int edad = sc.nextInt();
			sc.nextLine();
			
			if (edad<MAYORIA_EDAD) precio *= (1-MENOR_EDAD);
			else if (edad<EDAD_JUBILACION) {
				System.out.println("¿Es usted socio? Responda con Sí o No");
				String respuesta = sc.next();
				
				Pattern regex = Pattern.compile("^s[iíÍ]?$", Pattern.CASE_INSENSITIVE);
				Matcher m = regex.matcher(respuesta);
				if(m.matches()) precio = precio * (1 - DESCUENTO_SOCIO);
				//precio = respuesta.equals("Sí")?precio*(1-DESCUENTO_SOCIO):precio;
			}
			else precio*=(1-DESCUENTO_JUBILADO);
			System.out.printf("El precio de su entrada es de %.2f€.\n",precio);
			total += precio;
		}
		
		System.out.printf("El precio total es %.2f€.", total);
		sc.close();
	}

	public static void ejercicio13() {
		//Muestra por pantalla los números de 20 al 1 usando un bucle while, y después hazlo otra vez usando un bucle for.
		int n = 20;
		while (n !=0) {
			System.out.println(n);
			n--;
		}
		for (int x=20; x!=0; x--) {
			System.out.println(x);
		}
	}

	public static void ejercicio14() {
		/*
		 * Inicializa una variable entera a 0. Después, pregunta al usuario por un número y súmaselo a la variable inicial.
		 * Repite esto hasta que el usuario introduzca el número cero. Utiliza el bucle do..while.
		 */
		Scanner sc = new Scanner(System.in);
		int n=0, x;
		do {
			System.out.println("La variable vale "+n);
			System.out.print("Introduzca un número: ");
			x = sc.nextInt();
			n += x;
		}while(x != 0);
		sc.close();
	}

	public static void ejercicio15() {
		// Pide al usuario un número y calcula cuantas cifras tiene dicho número. Para ello puedes dividir el número entre 10 hasta que el resultado sea cero.
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un número: ");
		int n = sc.nextInt();
		int cifras = 0;
		do {
			n /= 10;
			cifras++;
		}while (n != 0);
		if (cifras == 1) System.out.println("El número introducido tiene "+cifras+" cifra.");
		else System.out.println("El número introducido tiene "+cifras+" cifras.");
		sc.close();
	}

	public static void main(String[] args) {
		// ejercicio11();
		// ejercicio12();
		ejercicio12Grupo();
		// ejercicio13();
		// ejercicio14();
		// ejercicio15();
	}

}
