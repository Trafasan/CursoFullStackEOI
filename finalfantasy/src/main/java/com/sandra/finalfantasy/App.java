package com.sandra.finalfantasy;

import java.util.ArrayList;
import java.util.List;

import com.sandra.finalfantasy.entidades.Personaje;
import com.sandra.finalfantasy.utilidades.JsonUtils;

public class App {
	static List<Personaje> ff9 = new ArrayList<Personaje>();
	static List<Personaje> ff10 = new ArrayList<Personaje>();
    public static void main(String[] args) {
    	/*Personaje random = JsonUtils.leerObjeto("https://www.moogleapi.com/api/v1/characters/random", Personaje.class);
    	System.out.println(random);*/
    	/*List<Personaje> garnet = JsonUtils.devolverArrayGsonGenerico("https://www.moogleapi.com/api/v1/characters/6c101c8e-1386-4592-1013-08d6afcab3e2", Personaje[].class);
    	garnet.forEach(System.out::println);*/
    	ff9 = JsonUtils.devolverArrayGsonGenerico("https://www.moogleapi.com/api/v1/characters/search?origin=9", Personaje[].class);
    	ff9.forEach(System.out::println);
    	ff10 = JsonUtils.devolverArrayGsonGenerico("https://www.moogleapi.com/api/v1/characters/search?origin=10", Personaje[].class);
    	ff10.forEach(System.out::println);
    }
}