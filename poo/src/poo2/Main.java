/**
 * 
 */
package poo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sandra
 *
 */
public class Main {
	public static void probarHerencia() {
		// Animal animal = new Animal("Mi animal", 10);
		Ave pajaro = new Ave(true);
		Ave gallina = new Ave("Animal desconocido", 1, false);
		
		// pajaro.comer();
		pajaro.ponerHuevos();
		System.out.println("El pájaro se llama : " + pajaro.getNombre());
		Mamifero leon = new Mamifero("León", 210, true);
		leon.comer();
		System.out.println(gallina.toString());
		System.out.println(leon);
		// Mamifero gato = new Mamifero("Animal desconocido", 1, true);
		
		if (pajaro.equals(gallina)) System.out.println("El pájaro es igual a la gallina");
		else System.out.println("El pájaro y la gallina no son iguales");
		
		/*if (pajaro.equals(gato)) System.out.println("El pájaro es igual a la gallina");
		else System.out.println("El pájaro y la gallina no son iguales");*/

		List<Animal> animales = new ArrayList<Animal>();
		animales.add(pajaro);
		animales.add(gallina);
		animales.add(leon);
		animales.forEach(e->System.out.println(e.toString()));
		
		for (Animal animal:animales) {
			if (animal instanceof Ave) System.out.println("El número de pollitos es "+((Ave)animal).pollitos(animal.getNombre()));
			else if (animal instanceof Mamifero) System.out.println(animal.rugido());
		}
	}
	
	public static void main(String[] args) {
		probarHerencia();
	}

}
