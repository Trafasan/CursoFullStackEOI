package com.sandra.anotaciones2;

import java.util.HashSet;

import com.sandra.anotaciones2.entidades.Autores;
import com.sandra.anotaciones2.entidades.Libros;
import com.sandra.anotaciones2.utilidades.HibernateUtils;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static void mostrarLibros() {
		HibernateUtils.getListaObjetosDeprecated("Libros").forEach(System.out::println);
	}
	
	public static void mostrarAutores() {
		HibernateUtils.getListaObjetos(Autores.class).forEach(System.out::println);
	}
	
	public static void addAutor() {
		System.out.println(HibernateUtils.addObjetoDeprecated(new Autores("AAAAA", "Nombre de prueba", new HashSet<Libros>(0)))?
				"Autor insertado correctamente":"No se ha podido insertar el autor");
	}
	
	public static void addLibro() {
		System.out.println(HibernateUtils.addObjeto(new Libros(6, "Nombre de prueba", new HashSet<Autores>(0)))?
				"Libro insertado correctamente":"No se ha podido insertar el libro");
	}
	
	public static void updateAutor() {
		HibernateUtils.updateObjeto(Autores.class, "nombre='Nombre de prueba'", new Autores(null, "Nombre actualizado", null));
	}
	
	public static void deleteAutor() {
		int registrosBorrados = HibernateUtils.deleteObjeto(Autores.class, "cod='AAAAA'");
		System.out.println("Se han borrado "+registrosBorrados+" registros");
	}
	
    public static void main( String[] args )
    {
    	java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);
    	if (HibernateUtils.openSession()) {
        	mostrarLibros();
    		// addAutor();
    		// updateAutor();
    		// deleteAutor();
        	mostrarAutores();
    		HibernateUtils.closeSession();
    	}
    }
}
