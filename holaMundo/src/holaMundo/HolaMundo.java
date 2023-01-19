package holaMundo;

import java.util.Scanner;

/**
 * Esta es la clase inicial del curso
 * 
 * @author Sandra
 * @since 1.0
 */
public class HolaMundo {

	public static void ejemplosComentarios() {
		// System.out.println("Hola Sandra");
		System.out.println("Hola mundo");
		System.out.println("Otra línea");
		/*
		 * System.out.println("Segunda línea");
		 * System.out.println("Tercera línea");
		 */
		System.out.println("Cuarta línea");

		// Ctrl+Alt+Arriba para duplicar arriba la línea seleccionada
		// Ctrl+Alt+Abajo para duplicar abajo la línea seleccionada
	}

	private static void ejemploTipos() {
		// Números enteros
		int numero = 5;
		int numero2 = 7;
		int suma = numero + numero2;
		int resta = numero2 - numero;
		double division = (double) numero2/numero;
		System.out.println("La suma es " + suma);
		System.out.println("La resta es " + resta);
		System.out.println("La división es " + division);
		System.out.println("La división sobre la marcha es " + (double) numero2/numero);
		// Números con decimales
		double decimales1 = 3.14;
		double decimales2 = 2.22;
		System.out.println("La multiplicación es " + decimales1 * decimales2);
		System.out.println("La suma es " + (decimales1+decimales2));
		double sumadecimales = numero + decimales1;
		System.out.println("La suma con decimales es "+sumadecimales);
		// Números enteros largos
		int maxInt = Integer.MAX_VALUE;
		int minInt = Integer.MIN_VALUE;
		System.out.println("Valor máximo de las variables int: "+maxInt);
		System.out.println("Valor mínimo de las variables int: "+minInt);
		System.out.println("La suma de los extremos es "+(maxInt+minInt));
		long largo1 = 2000000000;
		long largo2 = 1000000000;
		System.out.println("La suma de dos largos es "+(largo1+largo2));
		// Caracteres
		char letraA = 'a';
		char letraB = 'b';
		System.out.println("La suma de las letras es "+(letraA+letraB));
		System.out.println("La suma de la letra a más 3 es "+(letraA+3));
		System.out.println("La conversión de esa suma es "+(char)(letraA+3));
	}
	
	public static void ejemplosString() {
		String cadena1;
		cadena1 = "Fran";
		String cadena2 = "Hola", cadena3 = "Adiós";
		String cadena4 = cadena2+" "+cadena1;
		String prefijo = "34";
		String telefono = "666666666";
		int n = 40;
		System.out.println(prefijo+"-"+telefono);
		System.out.printf("%s tiene %d años\n", cadena1, n);
		System.out.println("Otra cosa");
	}
	public static void ejemplosBoolean() {
		boolean verdad = true;
		boolean falso = false;
		boolean comparacion1 = 10<20;
		System.out.println(10<20); // true
		System.out.println(comparacion1); // true
		String cadena1 = "Hola";
		String cadena2 = "Adiós";
		String cadena3 = "Hola";
		String cadena4 = "hola";
		System.out.println(cadena1.equals(cadena2)); // false
		System.out.println(cadena1.equals(cadena3)); // true
		System.out.println(cadena1.equals(cadena4)); // false
		int n1 = 5;
		double n3 = 5.0;
		double n4 = 5.1;
		System.out.println(n1==n3); // true
		System.out.println(n1==n4); // false
		System.out.println((float)(11/2)==n1); // true, la división de dos números enteros da un número entero
		System.out.println((11.0/2)==n1); // false
	}
	
	public static void tablasVerdad() {
		int edad = 25;
		int anyosCarnet = 6;
		String sexo = "Masculino";
		String nombre = "Pepe";
		boolean esPepeMayor = edad >=18 && nombre.equals("Pepe");
		System.out.println(esPepeMayor);
		
		boolean tieneDescuento = (sexo.equals("Masculino") && anyosCarnet > 10) || (sexo.equals("Femenino") && anyosCarnet > 5);
				System.out.println(tieneDescuento);
				boolean estoQueDa = sexo.equals("Masculino") || anyosCarnet>5 && nombre.equals("Fran");
				System.out.println(estoQueDa);
				int numero = 7+4*5;
				System.out.println(numero);
	}
	
	public static void entradaDatos() {
		Scanner sc = new Scanner (System.in);
		System.out.print("Introduzca su salario: ");
		double salario = Double.parseDouble(sc.nextLine().replace(',', '.'));
		System.out.print("Introduzca su salario deseado: ");
		double salarioD = Double.parseDouble(sc.nextLine().replace(',', '.'));
		System.out.println("Salario actual: "+salario);
		System.out.println("Salario deseado: "+salarioD);
		sc.close();
	}

	public static void main(String[] args) {
		// ejemplosComentarios();
		// ejemploTipos();
		// ejemplosString();
		// ejemplosBoolean();
		// tablasVerdad();
		entradaDatos();
	}

}