package com.sandra.harrypotter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.sandra.harrypotter.entidades.Personaje;
import com.sandra.harrypotter.utilidades.JsonUtils;
import com.sandra.harrypotter.utilidades.SerializacionUtils;

public class App {
	static List<Personaje> personajes = new ArrayList<Personaje>();
	final static String URI = "jdbc:mysql://localhost:3306/harry_potter";
	final static String USER = "root";
	final static String PASSWORD = "trafasan";
	public static Connection con;
	
    public static List<Personaje> recogerDatosApi() {
        return JsonUtils.devolverArrayGsonGenerico("https://hp-api.onrender.com/api/characters", Personaje[].class);
    }
	
    public static void mostrarDatosApi() {
        personajes = recogerDatosApi();
        personajes.stream().filter(e->e.getName().equals("Harry Potter")).forEach(System.out::println);
    }
	
    public static void rellenarLocalDate() {
        personajes = recogerDatosApi();
        personajes.stream().forEach(e->{
        	if (e.getDateOfBirth()!=null) 
        		e.setDateOfBirthLD(LocalDate.parse(e.getDateOfBirth(), DateTimeFormatter.ofPattern("dd-MM-yyy")));
        });
    }
	
    public static void ejemploSerializar() {
        System.out.println("La serialización "+((SerializacionUtils.serializarListaObjetos("personajes.dat", personajes))?"fue satisfactoria":"falló"));
    }
    
    public static void ejemploDesSerializar() {
    	personajes = SerializacionUtils.desSerializarListaObjetos("personajes.dat");
    }
    
    public static void mostrarPersonajes() {
    	personajes.forEach(System.out::println);
    }
    
    public static void mostrarPersonaje(String nombre) {
    	personajes.stream().filter(e->e.getName().equals(nombre)).forEach(System.out::println);
    }
    
    public static void probarConexion() {
    	con = null;
    	try {
    		con = DriverManager.getConnection(URI, USER, PASSWORD);
    		System.out.println("La conexión se realizó correctamente");
    	} catch (SQLException e) {
    		e.printStackTrace();
    		System.out.println("Fallo en la conexión");
		}
    }
    
    public static void poblarDB() {
    	Statement st;
    	String sql = "";
    	con = null;
    	try {
    		con = DriverManager.getConnection(URI, USER, PASSWORD);
    		st = con.createStatement();
    		for(Personaje personaje:personajes) {
    			sql = "INSERT INTO personaje(id,name) VALUES('"+personaje.getId()+"','"+personaje.getName()+"');";
    			System.out.println(sql);
    		    st.executeUpdate(sql);
    		}
    		st.close();
    		con.close();
    	} catch (SQLException e) {
    		e.printStackTrace();
		}
    }
    
    public static void poblarDBCompleta() {
    	Statement st;
    	String sql = "";
    	con = null;
    	try {
    		con = DriverManager.getConnection(URI, USER, PASSWORD);
    		st = con.createStatement();
		    st.executeUpdate("DELETE FROM personaje"); // Solo se utiliza cuando se hacen pruebas para no borrar accidentalmente
    		for(Personaje personaje:personajes) {
    			personaje.setActor(personaje.getActor().replace("'", "''")); // Esto evita el error al intentar introducir O'Farrell
    			sql = "INSERT INTO personaje("
    					+ "id, name, species, gender, house, dateOfBirth, yearOfBirth, wizard, ancestry,"
    					+ "eyeColour, hairColour, patronus, hogwartsStudent, hogwartsStaff, actor, alive, image"
    					+ ") VALUES('"
    					+personaje.getId()+"','"
    					+personaje.getName()+"','"
    					+personaje.getSpecies()+"','"
    					+personaje.getGender()+"','"
    					+personaje.getHouse()+"',"
    					+((personaje.getDateOfBirthLD()!=null)?"'"+personaje.getDateOfBirthLD()+"'":"NULL")+","
    					+((personaje.getYearOfBirth()!=null)?"'"+personaje.getYearOfBirth()+"'":"NULL")+",'"
    					+((personaje.getWizard())?1:0)+"','"
    					+personaje.getAncestry()+"','"
    					+personaje.getEyeColour()+"','"
    					+personaje.getHairColour()+"','"
    					+personaje.getPatronus()+"','"
    					+((personaje.getHogwartsStudent())?1:0)+"','"
    					+((personaje.getHogwartsStaff())?1:0)+"','"
    					+personaje.getActor()+"','"
    					+((personaje.getAlive())?1:0)+"','"
    					+personaje.getImage()+"');";
    			System.out.println(sql); // Solo se utiliza cuando se hacen pruebas para comprobar que funciona correctamente
    		    st.executeUpdate(sql);
    		}
    		st.close();
    		con.close();
    	} catch (SQLException e) {
    		e.printStackTrace();
		}
    }
	
	
    public static void main(String[] args) {
    	// personajes = recogerDatosApi();
    	rellenarLocalDate();
    	// ejemploDesSerializar();
    	// mostrarPersonajes();
    	// mostrarPersonaje("Harry Potter");
    	// probarConexion();
    	// poblarDB();
    	poblarDBCompleta();
    }
}
