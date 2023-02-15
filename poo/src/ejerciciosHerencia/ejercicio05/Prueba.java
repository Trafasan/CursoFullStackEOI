/**
 * 
 */
package ejerciciosHerencia.ejercicio05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sandra
 *
 */
public class Prueba {
	
	public static void main(String[] args) {
		List<Figura> figuras = new ArrayList<>(Arrays.asList(
				new Circulo(2), new Cuadrado(2), new Circulo(3),
				new Cuadrado(3), new Circulo(4), new Cuadrado(4)));
		// Sin distinguir el tipo de figura
		figuras.forEach(e->System.out.printf("Área: %.0f.\tPerímetro: %.0f\n", e.getArea(), e.getPerimetro()));
		// Distinguiendo el tipo de figura
		for (Figura figura:figuras) {
			if (figura instanceof Circulo) System.out.printf("*** Círculo - Radio: %.0f ***\nÁrea: %.2f. Perímetro: %.2f\n", ((Circulo)figura).getRadio(), figura.getArea(), figura.getPerimetro());
			else System.out.printf("*** Cuadrado - Radio: %.0f ***\nÁrea: %.0f. Perímetro: %.0f\n", ((Cuadrado)figura).getLado(), figura.getArea(), figura.getPerimetro());
		}
	}

}
