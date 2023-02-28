package com.sandra.json.utilidades;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sandra.json.entidades.Films;
import com.sandra.json.entidades.People;
import com.sandra.json.entidades.Posts;

public class JsonUtils {
	public static void leerJsonDesdeFichero(String ruta) {
		
		Object obj;
		
		try {
			obj = new JSONParser().parse(new FileReader(ruta));
			// casteando obj a JSONObject
			JSONObject jo = (JSONObject) obj;			
			//JSONObject jo = (JSONObject)new JSONParser().parse(new FileReader(ruta));
			// Leyendo datos básicos del Json
			String nombre = (String)jo.get("nombre");
			String apellido = (String)jo.get("apellido");
			System.out.println(nombre);
			System.out.println(apellido);
			long edad = (long)jo.get("edad");
			System.out.println(edad);
			
			// Leyendo los datos compuestos
			// Forma 1 de acceder a una variable compuesta.
			Map domicilio = (Map)jo.get("domicilio");
			Iterator<Map.Entry> itr1 = domicilio.entrySet().iterator();
			while(itr1.hasNext()) {
				Map.Entry pareja = itr1.next();
				System.out.println(pareja.getKey() + ": " + pareja.getValue());
			}
			// Forma 2 de acceder a una variable compuesta.
			JSONObject domicilio2 = (JSONObject) jo.get("domicilio");
			System.out.println("Dirección: " + (String)domicilio2.get("direccion"));
			
			// Leyendo arrays. Forma 1 tratándolo como una lista
			JSONArray ja = (JSONArray) jo.get("numerosTelefonos");
			System.out.println("Leyendo el array como una lista");
			for(Object elemento : ja) {
				System.out.println(((JSONObject)elemento).get("tipo"));
				System.out.println(((JSONObject)elemento).get("numero"));
			}
			// Forma 2. Tratándolo como un array
			ja =(JSONArray) jo.get("numerosTelefonos");
			Iterator array = ja.iterator();
			System.out.println("Leyendo el array como un array");
			while(array.hasNext()) {
				Iterator<Map.Entry> elementos = ((Map)array.next()).entrySet().iterator();
				while(elementos.hasNext()) {
					Map.Entry pareja = elementos.next();
					System.out.println(pareja.getKey() + ": " + pareja.getValue());
				}				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Posts> leerPostsInternet(String url) {
		Object obj;
		List<Posts> resultado = new ArrayList<>();
		try {
			obj = new JSONParser().parse(InternetUtils.readUrl(url));
			JSONArray ja = (JSONArray) obj;
			Iterator<?> elementos = ja.iterator();
			elementos.forEachRemaining(e->{
				JSONObject elemento = (JSONObject)e;
				resultado.add(new Posts(
						(long)elemento.get("userId"),
						(long)elemento.get("id"),
						(String)elemento.get("title"),
						(String)elemento.get("body")));
			});
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resultado;
		
	}

	public static void escribirJsonSimple() {
		// creando JSONObject
		JSONObject jo = new JSONObject();

		// poniendo los primeros datos en JSONObject
		jo.put("nombre", "Fran");
		jo.put("apellido", "Garcia");
		jo.put("edad", 25);

		// para la dirección primero hay que crear un LinkedHashMap
		Map m = new LinkedHashMap(4);
		m.put("direccion", "Lillo Juan, 128");
		m.put("ciudad", "San Vicente del Raspeig");
		m.put("comunidad", "Valenciana");
		m.put("codigoPostal", "03690");

		// domicilio a JSONObject
		jo.put("domicilio", m);

		// para los números de teléfono primero crear el JSONArray
		JSONArray ja = new JSONArray();

		m = new LinkedHashMap(2);
		m.put("tipo", "casa");
		m.put("numero", "666 666 666");
		// añadiendo a la lista
		ja.add(m);
		m = new LinkedHashMap(2);
		m.put("tipo", "movil");
		m.put("numero", "777 777 777");
		// añadiendo a la lista
		ja.add(m);

		// añadiendo los números de teléfono al JSONObject
		jo.put("numerosTelefonos", ja);

		// Escribiendo el:"profesor.json" in cwd
		PrintWriter pw;
		try {
			pw = new PrintWriter("profesor.json");
			pw.write(jo.toJSONString());
			pw.flush();
			pw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static People leerPersonaje(String url) {
		return new Gson().fromJson(InternetUtils.readUrl(url), People.class);
	}

	public static Films leerFilm(String url) {
		return new Gson().fromJson(InternetUtils.readUrl(url), Films.class);
	}
	
	// Método genérico
	public static <T> T leerObjeto(String url, Class<T> clase) {
		return new Gson().fromJson(InternetUtils.readUrl(url), clase);
	}

	
	public static <T> T leerObjetoConToken(String url,String token, Class<T> clase) {
		return new Gson().fromJson(InternetUtils.readUrl(url,token), clase);
	}
	
	public static List<People> leerPersonajes(String comienzoUrl, int numInicio, int numFin, String finUrl) {
		List<People> resultado = new ArrayList<People>();
		for (int i=numInicio; i<=numFin; i++) resultado.add(leerPersonaje(comienzoUrl+i+finUrl));
		return resultado;
	}
	
	public static <T> List<T> leerObjetos(String comienzoUrl, int numInicio, int numFin, String finUrl, Class<T> clase) {
		List<T> resultado = new ArrayList<T>();
		for (int i=numInicio; i<=numFin; i++) resultado.add(leerObjeto(comienzoUrl+i+finUrl, clase));
		return resultado;
	}
	
	/**
	 * Método genérico que dada una url con un json donde se encuentra un array de objetos
	 * devuelve una lista de este tipo de objetos que contiene todos los objetos del array.
	 * Ejemplo de llamada: JsonUtils.devolverArrayGsonGenerico("https://jsonplaceholder.typicode.com/posts",Posts[].class);
	 * @param <T> Nombre de la clase genérica
	 * @param url Url de la web donde está el array en formato json
	 * @param clase Array de elementos del tipo de la clase
	 * @return Lista de elementos de esa clase
	 */
	public static <T> List<T> devolverArrayGsonGenerico(String url, Class<T[]> clase){
		return Arrays.asList(new Gson().fromJson(InternetUtils.readUrl(url), clase));
	}
	
	/**
	 * Creamos un String con un json a partir de un objeto
	 * @param <T> tipo del objeto
	 * @param object nombre de la variable
	 * @return String con el Json devuelto
	 */
	public static <T> String crearJson(T object) {
		return new Gson().toJson(object);
	}
	
	/**
	 * Creamos un String con un json en formato amigable a partir de un objeto
	 * @param <T> tipo del objeto
	 * @param object nombre de la variable
	 * @return String con el Json devuelto
	 */
	public static <T> String crearJsonPretty(T object) {
		return new GsonBuilder().setPrettyPrinting().create().toJson(object);
	}

}
