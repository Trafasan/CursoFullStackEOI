package com.sandra.anotaciones1;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sandra.anotaciones1.entidades.Autores;
import com.sandra.anotaciones1.entidades.Libros;

public class App 
{
	static SessionFactory sessionFactory;
	static Session session;
	
	public static void openSession(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		if (session!=null) System.out.println("Sesión abierta");
		else System.out.println("Fallo en la sesión");
	}
	
	public static void closeSession(){
		sessionFactory.close();
		session.close();
	}
	
	public static void mostrarLibros() {
		// List<Libros> libros = session.createQuery("from Libros").list(); // Deprecated
		List<Libros> libros = session.createSelectionQuery("from Libros", Libros.class).list();
		libros.forEach(e->System.out.println("Nombre del libro: "+e.getTitulo()
		+"\nNombre del autor: "+e.getAutores().getNombre()));
	}
	
	public static void mostrarAutores() {
		List<Autores> autores = session.createSelectionQuery("from Autores", Autores.class).list();
		autores.forEach(System.out::println);
	}
	
	public static void addAutor(String cod, String nombre, Set<Libros> libros) {
		Transaction trans = session.beginTransaction();
		Autores autor = new Autores(cod, nombre, libros);
		// session.save(autor); // Deprecated
		session.persist(autor);
		trans.commit();
		session.clear();
	}
	
	public static void addLibro(int id, Autores autor, String nombre) {
		Transaction trans = session.beginTransaction();
		session.persist(new Libros(id, autor, nombre));
		trans.commit();
		session.clear();
	}
	
	public static void updateAutor(String oldName, String newName) {
		List<Autores> autores = session.createSelectionQuery("from Autores where nombre='"+oldName+"'", Autores.class).list();
		Transaction trans = session.beginTransaction();
		autores.forEach(e->{
			e.setNombre(newName);
			// session.update(e); // Deprecated
			session.merge(e);
		});
		trans.commit();
		session.clear();
	}
	
	public static void deleteLibro(int id) {
		List<Libros> libros = session.createSelectionQuery("from Libros where id="+id, Libros.class).list();
		if (libros.size()>0) {
			Transaction trans = session.beginTransaction();
			// session.delete(libros.get(0)); // Deprecated
			session.remove(libros.get(0));
			trans.commit();
		}
		else System.err.println("No existe ningún libro con ese ID");
		session.clear();
	}
	
    public static void main( String[] args )
    {
    	java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);
        openSession();
        // addAutor("AAAAA", "Nombre de prueba", new HashSet<Libros>(0));
    	// updateAutor("Nombre de prueba", "Nombre actualizado");
    	mostrarAutores();
    	// addLibro(6, new Autores("WSHAK"), "Libro de prueba");
    	// deleteLibro(6);
    	// mostrarLibros();
        closeSession();
    }
}
