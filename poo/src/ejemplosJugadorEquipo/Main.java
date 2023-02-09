/**
 * 
 */
package ejemplosJugadorEquipo;

/**
 * @author Sandra
 *
 */
public class Main {

	public static void main(String[] args) {
		// Equipo.ejemploEquipos();
		// Jugador.ejemploListaJugadores();
		Equipo equipo = new Equipo();
		Jugador fran = new Jugador("Fran", 45, 20000);
		equipo.getJugadores().add(fran);
		equipo.getEstadio().setNombre("Mi estado");
		System.out.println("Fin del programa");
	}

}
