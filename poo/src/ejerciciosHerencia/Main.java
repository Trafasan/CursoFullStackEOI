package ejerciciosHerencia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void ejercicios01_02() {
		TiendaLicores tiendaDeLicores = new TiendaLicores();
		tiendaDeLicores.bienvenida();
	}
	
	public static void ejercicio03() {
		Persona p1 = new Persona("12345678A", "Alejandro", 24);
		Persona p2 = new Persona("98765432Z", "María", 23);
		Persona p3 = new Persona("13579593G", "Jorge", 26);
		Persona p4 = new Persona("24680482T", "Helena", 22);
		
		List<Persona> personas = new ArrayList<Persona>();
		Collections.addAll(personas, p1, p2, p3, p4);
		Persona pNueva = new Persona (p3);
		pNueva.setNombre("Sandra");
		int posicion = 0;
		for (Persona persona:personas) {
			if (persona.equals(pNueva)) {
				posicion = personas.indexOf(persona);
				System.out.println("Persona encontrada en la posición "+posicion);
			}
		}
		if (posicion != -1) System.out.println(personas.get(posicion));
		System.out.println(pNueva);
	}

	public static void main(String[] args) {
		ejercicios01_02();
		ejercicio03();
	}

}
