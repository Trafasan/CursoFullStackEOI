/**
 * 
 */
package ejercicio01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sandra
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("EJERCICIO 1");
		Jugador j1 = new Jugador("Helena", 25, -1500);
		Jugador j2 = new Jugador("Alejandro", -22, 1300);
		System.out.println(j1);
		System.out.println(j2);

		System.out.println("EJERCICIO 2");
		List<Jugador> jugadores = new ArrayList<Jugador>();
		Collections.addAll(jugadores, j1, null, new Jugador("María", 24, 1200), new Jugador("Daniel", 23, 1400), null, j2);
		/* La línea anterior es lo mismo que escribir el siguiente código:
		 * jugadores.add(j1);
		 * jugadores.add(null);
		 * jugadores.add(new Jugador("María", 24, 1200));
		 * jugadores.add(new Jugador("Daniel", 23, 1400));
		 * jugadores.add(null);
		 * jugadores.add(j2);
		 */
		// for (Jugador j : jugadores) if (j != null) System.out.println(j);
		// En programación funcional, se haría de la siguiente manera
		jugadores.stream().filter(e->e!=null).forEach(e-> System.out.println(e));
		// Para filtrar con varios requisitos, se puede hacer lo siguiente. Es IMPORTANTE el orden de los requisitos
		System.out.println("Jugadores con un sueldo mayor a 1300");
		jugadores.stream().filter(e->e!=null && e.getSueldo()>1300).forEach(e-> System.out.println(e));

		System.out.println("EJERCICIO 3");
		/* Este código cambiaría también el nombre del jugador en la lista original
		 * List<Jugador> copiaJugadores = new ArrayList<Jugador>(jugadores);
		 * copiaJugadores.get(2).setNombre("Sandra");
		 * System.out.println(jugadores.get(2));
		 */
		List<Jugador> copiaJugadores = new ArrayList<Jugador>();
		for (Jugador j : jugadores) {
			if (j!=null) copiaJugadores.add(new Jugador(j));
			else copiaJugadores.add(null);
		}
		copiaJugadores.get(2).setNombre("Sandra");
		System.out.println(jugadores.get(2));
		System.out.println(copiaJugadores.get(2)); // Comprobación del cambio de nombre
		
		System.out.println("EJERCICIO 4");
		Equipo e1 = new Equipo();
		e1.addJugador(j1);
		e1.addJugador(new Jugador("María", 24, 1200));
		e1.addJugador(new Jugador("Daniel", 23, 1400));
		e1.addJugador(null);
		e1.deleteJugador(0);
		for (int i=0; i<e1.getNumJugadores(); i++) /*if(e1.getJugador(i)!=null)*/ System.out.println(e1.getJugador(i)); //El if es para que no imprima los null
		System.out.printf("Suma total de los sueldos: %.2f€", e1.totalSueldos());
		
	}

}
