package com.sandra.ProjectJsonXmlSerializacion.utilidades;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sandra.ProjectJsonXmlSerializacion.entidades.Starships;

public class JsonUtils {
	
	public static <T> T leerObjeto(String url, Class<T> clase) {
		return new Gson().fromJson(InternetUtils.readUrl(url), clase);
	}

	
	public static <T> T leerObjetoConToken(String url,String token, Class<T> clase) {
		return new Gson().fromJson(InternetUtils.readUrl(url,token), clase);
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
	
	public static String getEnlaceAPI(String enlace) {
		return enlace.substring(0, enlace.length()-1)+"?format=json";
	}
	
	// Método para el apartado 3, no se extraen más datos ya que no es necesario
	public static Starships getStarshipFicheroJson(String ruta) {
		try {
			JsonObject jobject = JsonParser.parseReader(new FileReader(ruta)).getAsJsonObject();
			return new Starships(jobject.get("name").getAsString(), jobject.get("passengers").getAsString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
