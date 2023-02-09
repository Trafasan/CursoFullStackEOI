package ejemplosJugadorEquipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipo {
	private String nombre;
	private Estadio estadio;
	private List<Jugador> jugadores;
	private double presupuesto;
	
	public Equipo() {
		estadio = new Estadio();
		jugadores = new ArrayList<Jugador>();
	}

	public Equipo(String nombre, Estadio estadio, List<Jugador> jugadores, double presupuesto) {
		super();
		this.nombre = nombre;
		this.estadio = estadio;
		this.jugadores = jugadores;
		this.presupuesto = presupuesto;
	}
	
	public Equipo(Equipo e) {
		super();
		this.nombre = e.nombre;
		this.presupuesto = e.presupuesto;
		this.estadio = new Estadio(e.estadio);  // Forma correcta de copiar un objeto
		this.jugadores = new ArrayList<Jugador>();  // Creo la lista vacia
		e.getJugadores().forEach(j->this.jugadores.add(new Jugador(j))); // Voy rellenando la lista con copias jugador a jugador
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	public static void ejemploEquipos() {
		Equipo barsa = new Equipo();
		barsa.setNombre("F.C. Barcelona");
		barsa.setPresupuesto(400000000);
		Estadio campNou = new Estadio();  // Creo el estadio y le doy datos
		campNou.setNombre("Spotify Camp Nou");
		campNou.setCapacidad(100000);
		barsa.setEstadio(campNou);	// asigno el estadio al equipo
		List<Jugador> jugadoresBarsa = new ArrayList<Jugador>();  // Creo la lista y le meto jugadores
		jugadoresBarsa.add(new Jugador("Fran",45,100000));
		jugadoresBarsa.add(new Jugador("Paco",70,200000));
		jugadoresBarsa.add(new Jugador("Dani",42,300000));
		jugadoresBarsa.add(new Jugador("Consu",39,400000));
		barsa.setJugadores(jugadoresBarsa);
		System.out.println("Fin de la creación del equipo");
		// Imprimpo el equipo
		//System.out.println(barsa);
		
		// Probamos el constructor de copia
		Equipo madrid = new Equipo(barsa);
		madrid.setNombre("Real Madrid");
		madrid.setPresupuesto(100000);
		barsa.getEstadio().setNombre("Nuevo Campo");  // Le cambio el nombre del estadio del barsa
		madrid.getEstadio().setNombre("Santiago Bernabeu");
		madrid.getEstadio().setCapacidad(80000);
		// Accede al equipo, luego a su lista de jugadores, luego a su primer elemento de la lista y luego le cambia el nombre
		barsa.getJugadores().get(0).setNombre("Francisco");  
		madrid.getJugadores().get(1).setNombre("Ate");
		
		// Impresión de los equipos
		System.out.println(barsa);  // Imprimo el Barsa
		System.out.println(madrid);	// Imprimo el Madrid	
	}

	@Override
	public String toString() {
		return  nombre + "\nPresupuesto=" + presupuesto + "\n" + estadio + "\n" + jugadores; 				 
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
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
		return Objects.equals(nombre, other.nombre);
	}
	
}
