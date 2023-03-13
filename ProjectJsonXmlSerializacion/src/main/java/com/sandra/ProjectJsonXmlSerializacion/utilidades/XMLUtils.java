package com.sandra.ProjectJsonXmlSerializacion.utilidades;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sandra.ProjectJsonXmlSerializacion.entidades.Starships;

public class XMLUtils {
	public static String leerArchivo(String ruta) {
		try {
			return Files.readAllLines(Paths.get(ruta)).stream().collect(Collectors.joining(""));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String archivoJsonAXml(String stringJson) {
		JSONObject json = new JSONObject(stringJson);
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><starship>"+XML.toString(json)+"</starship>";
	}
	
	/**
	 * Escribe un fichero sobreescribiendo el contenido anterior
	 * @param ruta Path con la ruta del fichero
	 * @param lineas Lista con las líneas
	 * @return True en caso de escritura correcta, false en caso contrario
	 */
	public static boolean escribirLineasJava8(Path ruta, String xml) {
		try {
			Files.writeString(ruta, xml, StandardOpenOption.CREATE);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	private static List<String> getListFromNodeList(NodeList nl) {
		List<String> lista = new ArrayList<>();
		for (int i=0; i<nl.getLength(); i++) lista.add(nl.item(i).getTextContent());
		return lista;
	}
	
	public static Starships getStarshipFromXML(String nombreFichero) {
		try {
			File inputFile = new File(nombreFichero);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			Node nNode = doc.getElementsByTagName("starship").item(0);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				return new Starships(
						eElement.getElementsByTagName("name").item(0).getTextContent(),
						eElement.getElementsByTagName("model").item(0).getTextContent(),
						eElement.getElementsByTagName("starship_class").item(0).getTextContent(),
						eElement.getElementsByTagName("manufacturer").item(0).getTextContent(),
						eElement.getElementsByTagName("cost_in_credits").item(0).getTextContent(),
						eElement.getElementsByTagName("length").item(0).getTextContent(),
						eElement.getElementsByTagName("crew").item(0).getTextContent(),
						eElement.getElementsByTagName("passengers").item(0).getTextContent(),
						eElement.getElementsByTagName("max_atmosphering_speed").item(0).getTextContent(),
						eElement.getElementsByTagName("hyperdrive_rating").item(0).getTextContent(),
						eElement.getElementsByTagName("MGLT").item(0).getTextContent(),
						eElement.getElementsByTagName("cargo_capacity").item(0).getTextContent(),
						eElement.getElementsByTagName("consumables").item(0).getTextContent(),
						getListFromNodeList(eElement.getElementsByTagName("films")),
						getListFromNodeList(eElement.getElementsByTagName("pilots")),
						eElement.getElementsByTagName("url").item(0).getTextContent(),
						eElement.getElementsByTagName("created").item(0).getTextContent(),
						eElement.getElementsByTagName("edited").item(0).getTextContent());
			}
			else return null;
		} catch (Exception e) {
			return null;
		}
	}
}
