package com.sandra.finalfantasy.utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializacionUtils {
	/**
	 * Dada una ruta de un fichero y una lista de objetos a almacenar, los guarda en el fichero
	 * @param <T> Clase genérica
	 * @param rutaCompleta Ruta donde guardamos los objetos
	 * @param objetos Lista de objetos que le pasamos
	 * @return True si el proceso es correcto, False en caso contrario
	 */
	public static <T> boolean serializarListaObjetos(String rutaCompleta, List<T> objetos) {
		File fichero = new File(rutaCompleta);
		try {
			ObjectOutputStream ficheroObjetos = new ObjectOutputStream(new FileOutputStream(fichero));
			ficheroObjetos.writeObject(objetos);
			ficheroObjetos.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
