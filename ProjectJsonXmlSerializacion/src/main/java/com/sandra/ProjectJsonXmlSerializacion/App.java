package com.sandra.ProjectJsonXmlSerializacion;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.sandra.ProjectJsonXmlSerializacion.entidades.Films;
import com.sandra.ProjectJsonXmlSerializacion.entidades.People;
import com.sandra.ProjectJsonXmlSerializacion.entidades.Starships;
import com.sandra.ProjectJsonXmlSerializacion.utilidades.JsonUtils;
import com.sandra.ProjectJsonXmlSerializacion.utilidades.SerializacionUtils;
import com.sandra.ProjectJsonXmlSerializacion.utilidades.XMLUtils;

public class App {
	/* Este proyecto se ha construido de tal manera que se pueda implementar posteriormente en una base de datos. 
	 * En el caso de que no se quieran trasladar los datos que se obtienen a una base de datos, se pueden retocar
	 * las clases para hacer el código más corto
	 */
	
	/* Datos para ZonedDateTime para bases de datos (si se crea alguna en un futuro...):
	 * En la tabla de bases de datos debe declararse como TimeStamp
	 * Para obtener el dato se debe utilizar la siguiente línea: ZonedDateTime.ofInstant(rs.getTimestamp("NOMBRE_COLUMNA").toInstant(), ZoneOffset.UTC);
	 * Para guardar el dato se debe utilizar la siguiente línea: Timestamp.valueOf(FECHA_ZONED.toLocalDateTime());
	 */
	
	// Los enlaces serán comienzoURL+tipoDato+"/"+id+finalURL
	final static String comienzoURL = "https://swapi.dev/api/";
	public static String tipoDato;
	public static int id;
	final static String finalURL = "?format=json";
	
	public static List<People> personajes = new ArrayList<>();
	
	public static Scanner sc;
	
	public static <T> T obtenerDatoPorId(String texto, int idMax, Class<T> clase) {
		do {
			System.out.print("Introduzca la ID de"+texto+": ");
			try {
				id = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				id = -1;
			}
			if (id<1||id>idMax) System.err.println("La ID no es válida");
		} while (id<1||id>idMax);
		return JsonUtils.leerObjeto(comienzoURL+tipoDato+"/"+id+finalURL, clase);
	}
	
	/* La primera opción del menú es la coincidencia en películas. Lo primero que queremos
	 * saber es en qué películas han coincidido dos identificadores que pediremos al usuario.
	 * Por ejemplo si pasamos 1 y 4 (Luke Skywalker y Darth Vader), nos dirá el title (no el
	 * número ni la url, por lo que tendrás que acceder a la ruta para coger el título) de las
	 * películas donde han actuado ambos al mismo tiempo.
	 * NOTA: utiliza la función llamada readUrl que lee una url y devuelve el json de dicha url. */
	public static void apartado1() {
		tipoDato = "people";
		int idMax = 83;
		
		People personaje1 = obtenerDatoPorId("l primer personaje", idMax, People.class);
    	List<String> pelis1 = People.getTitleFilm(personaje1.getFilms());
    	if (!personajes.contains(personaje1)) personajes.add(personaje1);
    	System.out.println(personaje1);
    	
		People personaje2 = obtenerDatoPorId("l segundo personaje", idMax, People.class);
    	List<String> pelis2 = People.getTitleFilm(personaje2.getFilms());
    	if (!personajes.contains(personaje2)) personajes.add(personaje2);
    	
    	if (!personaje1.equals(personaje2)) {
        	Set<String> pelisComunes = new ArrayList<>(Arrays.asList(pelis1, pelis2)).stream()
        			.flatMap(e->e.stream()).collect(Collectors.toSet());
        	pelisComunes.removeIf(e->!(pelis1.contains(e) && pelis2.contains(e)));
        	System.out.println("Películas comunes de "+personaje1.getName()+" y "+personaje2.getName()+": "
        			+pelisComunes.stream().collect(Collectors.joining(", ")));
    	}
    	else System.err.println("Se ha introducido el mismo personaje.");
	}
	
	/* Añade la opción de serializar y deserializar los personajes que has ido comparando las
	 * películas, para ello, cada vez que vayas comparando personajes (Luke Skywalker y Darth
	 * Vader por ejemplo), si no los tienes sus objetos ya en una lista, guárdalos (no guardes
	 * repetidos). Luego da la opción tanto de serializar esa lista, como otra de deserializar y
	 * mostrar los resultados.*/
	public static void apartado2Serializar() {
		System.out.println("La serialización "+((SerializacionUtils.serializarListaObjetos("personajes.dat", personajes))?"fue satisfactoria":"falló"));
	}
	public static void apartado2Deserializar() {
		personajes = SerializacionUtils.desSerializarListaObjetos("personajes.dat");
		System.out.println("La desearización fue satisfactoria");
	}
	
	/* Tenemos un problema con el almacenamiento de los pasajeros que son capaces de
	 * transportar las naves (starships). Queremos saber que naves (starships) de una
	 * película, cuyo código pediremos por teclado pueden llevar más pasajeros que la del
	 * fichero Json que nos han pasado. Para ello, preguntaremos por consola el código de la
	 * película (no debemos leer todas las películas solamente la del código pasado) y
	 * sacaremos un listado indicando el nombre (name) y la capacidad (passengers) de las
	 * naves que aparecen en esa película (film) con mayor capacidad que el Json que
	 * tenemos (cr90.json). Crea una nueva opción del menú para obtener los resultados. */
	public static void apartado3() {
		tipoDato = "films";
		int idMax = 6;
		
		 // Nota: este JSON se encuentra en https://swapi.dev/api/starships/2?format=json
		Starships cr90 = JsonUtils.getStarshipFicheroJson("cr90.json");
		if (cr90 != null) {
			int capacidadCr90 = Integer.parseInt(cr90.getPassengers());
			
			List <Starships> naves = new ArrayList<>();
			obtenerDatoPorId(" la película", idMax, Films.class).getStarships().forEach(e->
				naves.add(JsonUtils.leerObjeto(JsonUtils.getEnlaceAPI(e), Starships.class)));
			
			System.out.println("La capacidad de la nave espacial "+cr90.getName()+" es de "+capacidadCr90+" pasajeros");
			System.out.println("Las naves espaciales que superan esta capacidad son las siguientes:");
	    	naves.stream().filter(e->!e.getPassengers().equals("n/a")).peek(e->e.setPassengers(e.getPassengers().replace(",", "")))
	    		.filter(e->Integer.parseInt(e.getPassengers())>capacidadCr90).forEach(e->
	    			System.out.println("· "+e.getName()+" (Capacidad: "+e.getPassengers()+" pasajeros)"));
		}
		else System.out.println(cr90);
		
	}
	
	// A partir del fichero Json (cr90.json) busca una utilidad por Internet que transforme el Json pasado a un Xml
	public static void apartado4() {
		String xml = XMLUtils.archivoJsonAXml(XMLUtils.leerArchivo("cr90.json"));
		System.out.println(XMLUtils.escribirLineasJava8(Paths.get("cr90.xml"), xml) ?
				"El archivo se creó correctamente" : "Algo ha fallado");
	}
	
	/* Crea otra opción para leer el XML creado en el apartado anterior guardándolo en una
	 * clase de Java, mostrando por pantalla toda la información usando el método toString de dicha clase. */
	public static void apartado5() {
		Starships cr90 = XMLUtils.getStarshipFromXML("cr90.xml");
    	System.out.println(cr90!=null ? cr90 :"No se ha podido leer el archivo");
	}
	
	public static void tiempoEsperaMenu() {
		long milisegundos = 5000;
		System.err.println("\nEn "+milisegundos/1000+" segundos aparecerá el menú de nuevo. Le agradecemos su paciencia\n");
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void menu() {
		int opcion;
		do {
			System.out.println("MENÚ PROGRAMA");
			System.out.println("1. Películas comunes de dos personajes"
					+"\n2. Serializar personajes"
					+"\n3. Desearizar personajes"
					+"\n4. Naves de una película con una capacidad mayor a la del CR90 corvette"
					+"\n5. Obtener archivo XML del CR90 corvette"
					+"\n6. Leer archivo XML del CR90 corvette"
					+"\n7. Salir");
			System.out.print("Introduzca una opción: ");
			try {
				opcion = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				opcion = 0;
			}
			switch (opcion) {
			case 1 -> apartado1();
			case 2 -> apartado2Serializar();
			case 3 -> apartado2Deserializar();
			case 4 -> apartado3();
			case 5 -> apartado4();
			case 6 -> apartado5();
			case 7 -> System.out.println("Hasta pronto :)");
			default -> System.err.println("El dato introducido no es válido");
			}
			if(opcion>0 && opcion<7) tiempoEsperaMenu();
		} while (opcion != 7);
	}
	
    public static void main(String[] args){
    	sc = new Scanner(System.in);
    	menu();
    	sc.close();
    }
}
