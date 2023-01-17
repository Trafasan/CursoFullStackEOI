package holaMundo;

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
		 * System.out.println("Segunda línea"); System.out.println("Tercera línea");
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

	public static void main(String[] args) {
		// ejemplosComentarios();
		ejemploTipos();
	}

}