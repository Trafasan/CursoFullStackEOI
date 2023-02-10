package ejercicio01;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipo {
	private List<Jugador> jugadores = new ArrayList<Jugador>();
	
	public Equipo() {
		
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	/**
	 * Añade el jugador a la lista interna
	 * @param jugador Jugador que se va a añadir
	 */
	public void addJugador(Jugador jugador) {
		try {
			jugadores.add(jugador);
		} catch (Exception e) {
			System.err.println("El jugador no se ha podido añadir correctamente");
		}
	}
	/**
	 * Añade el jugador a la lista interna
	 * @param jugador
	 * @return true si se añadió correctamente, false si no se pudo añadir
	 */
	public boolean addJugadorBoolean(Jugador jugador) {
		try {
			jugadores.add(jugador);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * Contador de jugadores que hay en un equipo
	 * @return Cantidad de jugadores que hay
	 */
	public int getNumJugadores() {
		return jugadores.size();
	}
	/**
	 * Selecciona un jugador de una posición determinada
	 * @param posicion Posición en la lista del jugador
	 * @return Jugador de esa posición de la lista
	 */
	public Jugador getJugador(int posicion) {
		try {
			return jugadores.get(posicion);
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * Borra el jugador de esa posición (si existe)
	 * @param posicion
	 */
	public void deleteJugador(int posicion) {
		try {
			jugadores.remove(posicion);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("La posición introducida ("+posicion+") no es correcta");
		}
	}
	/**
	 * Suma de los sueldos de los jugadores del equipo
	 * @return La variable suma
	 */
	public double totalSueldos() {
		double suma = 0;
		for (Jugador j:jugadores) if (j!=null) suma+=j.getSueldo();
		return suma;
	}
	
	public double totalSueldosFuncional() {
		/*
		 * Manera 1:
		 * double[] sueldos = new double[1];
		 * jugadores.forEach(e->sueldos[0]+=e.getSueldo());
		 * return sueldos[0];
		 */
		return jugadores.stream().filter(e->e!=null).mapToDouble(e->e.getSueldo()).sum();
	}

	@Override
	public int hashCode() {
		return Objects.hash(jugadores);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(jugadores, other.jugadores);
	}
	
}
