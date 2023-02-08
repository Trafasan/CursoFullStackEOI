package ejercicio01;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	private List<Jugador> jugadores = new ArrayList<Jugador>();
	
	public Equipo() {
		
	}

	public void addJugador(Jugador jugador) { // Añade el jugador a la lista interna
		jugadores.add(jugador);
	}
	
	public int getNumJugadores() { // Devuelve la cantidad de jugadores que hay
		return jugadores.size();
	}
	
	public Jugador getJugador(int posicion) { // Devuelve el jugador de esa posición de la lista. Si no existe, devuelve null
		if (jugadores.get(posicion) != null) return jugadores.get(posicion);
		else return null;
	}
	
	public void deleteJugador(int posicion) { // Borra el jugador de esa posición (si existe)
		if (jugadores.get(posicion) != null) jugadores.remove(posicion);
	}
	
	public double totalSueldos() { // Devuelve la suma de los sueldos de los jugadores del equipo
		double suma = 0;
		for (Jugador j:jugadores) if (j!=null) suma+=j.getSueldo();
		return suma;
	}
	
}
