/**
 * 
 */
package ejerciciosTiposDeDatosBásicos;

/**
 * @author Sandra
 *
 */
public class Ejercicio07 {

	public static void main(String[] args) {
		/*
		 * Crea un programa donde definimos 2 variables de tipo carácter. Muestra la posición de cada carácter en la tabla unicode y la diferencia entre ambos
		 * caracteres. Si los caracteres son ‘b’ y ‘k’, la salida sería:
		 * 'b' tiene la posición 98
		 * 'k' tiene la posición 107
		 * Diferencia entre 'b' y 'k': 9
		 */
		char letra1 = 'b', letra2 = 'k';
		int pos1 = letra1, pos2 = letra2;
		System.out.println(letra1+" tiene la posición "+pos1);
		System.out.println(letra2+" tiene la posición "+pos2);
		System.out.println("Diferencia entre "+letra1+" y "+letra2+": "+(letra2-letra1));

	}

}
