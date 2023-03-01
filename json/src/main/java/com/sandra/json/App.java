package com.sandra.json;

import java.util.ArrayList;
import java.util.List;

import com.sandra.json.utilidades.JsonUtils;
import com.sandra.json.entidades.Films;
import com.sandra.json.entidades.People;
import com.sandra.json.entidades.Posts;
import com.sandra.json.entidades.Team;

public class App {

	final static String TOKEN_FOOTBALL_DATA = "6bff5b66e01940a4a4730dad785bbab3";
	static List<Posts> publicaciones = new ArrayList<>();
    public static void main(String[] args) {
        // JsonUtils.leerJsonDesdeFichero("profesor.json");
        /*publicaciones = JsonUtils.leerPostsInternet("https://jsonplaceholder.typicode.com/posts");
        publicaciones.stream().filter(e->e.getId()%2==0).forEach(e->System.out.println(e));*/
    	/*People luke = JsonUtils.leerPersonaje("https://swapi.dev/api/people/1?format=json");
    	System.out.println(luke);*/
    	/*List<People> personajes1al10 = JsonUtils.leerPersonajes("https://swapi.dev/api/people/", 1, 10, "?format=json");
    	personajes1al10.forEach(e->System.out.println(e));*/
    	/*Films pelicula = JsonUtils.leerFilm("https://swapi.dev/api/films/1?format=json");
    	System.out.println(pelicula);*/
    	/*People luke = JsonUtils.leerObjeto("https://swapi.dev/api/people/1?format=json", People.class);
    	System.out.println(luke);
    	Films pelicula = JsonUtils.leerObjeto("https://swapi.dev/api/films/1?format=json", Films.class);
    	System.out.println(pelicula);*/
    	/*List<Films> peliculas = JsonUtils.leerObjetos("https://swapi.dev/api/films/", 1, 5, "?format=json", Films.class);
    	peliculas.forEach(e->System.out.println(e));
    	List<People> personajes = JsonUtils.leerObjetos("https://swapi.dev/api/people/", 8, 14, "?format=json", People.class);
    	personajes.forEach(e->System.out.println(e));*/
    	// Leer lista de posts utilizando el genérico
    	/*publicaciones = JsonUtils.devolverArrayGsonGenerico("https://jsonplaceholder.typicode.com/posts",Posts[].class);
        publicaciones.stream()
        .filter(e->e.getId()%2==0)  // publicaciones pares        
        .forEach(e->System.out.println(e));*/// Crear un json utilizando el genérico
    	/*
    	Posts publicacion = new Posts(1,2,"Post de prueba","Contenido del post");
    	String json = JsonUtils.crearJson(publicacion);
    	System.out.println(json);
    	json = JsonUtils.crearJsonPretty(publicacion);
    	System.out.println(json);
    	*/
    	
    	// Leer API fútbol sin token
    	//String lecturaUrl = InternetUtils.readUrl("https://api.football-data.org/v4/teams/86/matches?status=SCHEDULED");
    	//System.out.println(lecturaUrl);
    	// Leer API fútbol con token
    	//String lecturaUrl = InternetUtils.readUrl("https://api.football-data.org/v4/teams/86/matches?status=SCHEDULED",TOKEN_FOOTBALL_DATA);
    	// Leer datos de un equipo y pasarlo a String
    	/*
    	String lecturaUrl = InternetUtils.readUrl("https://api.football-data.org/v4/teams/86",TOKEN_FOOTBALL_DATA);
    	System.out.println(lecturaUrl);
    	*/
    	Team realMadrid = JsonUtils.leerObjetoConToken("https://api.football-data.org/v4/teams/86", TOKEN_FOOTBALL_DATA, Team.class);
    	System.out.println(realMadrid);
    	Team equipo87 = JsonUtils.leerObjetoConToken("https://api.football-data.org/v4/teams/87", TOKEN_FOOTBALL_DATA, Team.class);
    	System.out.println(equipo87);
    	
    }
}
