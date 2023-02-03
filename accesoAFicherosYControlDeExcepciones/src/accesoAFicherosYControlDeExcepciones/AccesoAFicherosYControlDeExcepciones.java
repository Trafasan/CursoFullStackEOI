/**
 * 
 */
package accesoAFicherosYControlDeExcepciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Sandra
 *
 */
public class AccesoAFicherosYControlDeExcepciones {
	public static void leerFicheroJava5(String nombreFichero) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			archivo = new File (nombreFichero);
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null)System.out.println(linea);
		}
		catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         try{                    
	            if( null != fr ) fr.close();              
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	}
	
	public static void leerFicheroJava8(String nombreFichero) throws IOException {
		Files.readAllLines(Paths.get(nombreFichero)).forEach(l->System.out.println(l));
	}
	public static void main(String[] args) throws IOException {
		leerFicheroJava5("C:\\Users\\Sandra\\Documents\\FullStack\\FullStackJavaEOI\\accesoAFicherosYControlDeExcepciones\\archivosEjercicios\\ejercicio03.txt");
		System.out.println();
		leerFicheroJava8("C:\\Users\\Sandra\\Documents\\FullStack\\FullStackJavaEOI\\accesoAFicherosYControlDeExcepciones\\archivosEjercicios\\ejercicio03.txt");
	}

}
