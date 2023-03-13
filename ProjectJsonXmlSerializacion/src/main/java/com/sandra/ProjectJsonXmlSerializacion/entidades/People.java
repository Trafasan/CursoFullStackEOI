package com.sandra.ProjectJsonXmlSerializacion.entidades;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.sandra.ProjectJsonXmlSerializacion.utilidades.JsonUtils;

public class People implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String height;
	private String mass;
	private String hair_color;
	private String skin_color;
	private String eye_color;
	private String birth_year;
	private String gender;
	private String homeworld;
	private List<String> films;
	private List<String> species;
	private List<String> vehicles;
	private List<String> starships;
	private String created;
	private transient ZonedDateTime createdZD;
	private String edited;
	private transient ZonedDateTime editedZN;
	private String url;
	
	public People() {
		films = new ArrayList<String>();
		species = new ArrayList<String>();
		vehicles = new ArrayList<String>();
		starships = new ArrayList<String>();
	}

	public People(String name, String height, String mass, String hair_color, String skin_color, String eye_color,
			String birth_year, String gender, String homeworld, List<String> films, List<String> species,
			List<String> vehicles, List<String> starships, String created, ZonedDateTime createdZD, String edited,
			ZonedDateTime editedZN, String url) {
		super();
		this.name = name;
		this.height = height;
		this.mass = mass;
		this.hair_color = hair_color;
		this.skin_color = skin_color;
		this.eye_color = eye_color;
		this.birth_year = birth_year;
		this.gender = gender;
		this.homeworld = homeworld;
		this.films = films;
		this.species = species;
		this.vehicles = vehicles;
		this.starships = starships;
		this.created = created;
		this.createdZD = createdZD;
		this.edited = edited;
		this.editedZN = editedZN;
		this.url = url;
	}

	public People(String name, String height, String mass, String hair_color, String skin_color, String eye_color,
			String birth_year, String gender, String homeworld, List<String> films, List<String> species,
			List<String> vehicles, List<String> starships, String created, String edited,
			String url) {
		super();
		this.name = name;
		this.height = height;
		this.mass = mass;
		this.hair_color = hair_color;
		this.skin_color = skin_color;
		this.eye_color = eye_color;
		this.birth_year = birth_year;
		this.gender = gender;
		this.homeworld = homeworld;
		this.films = films;
		this.species = species;
		this.vehicles = vehicles;
		this.starships = starships;
		this.created = created;
		this.edited = edited;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getMass() {
		return mass;
	}

	public void setMass(String mass) {
		this.mass = mass;
	}

	public String getHair_color() {
		return hair_color;
	}

	public void setHair_color(String hair_color) {
		this.hair_color = hair_color;
	}

	public String getSkin_color() {
		return skin_color;
	}

	public void setSkin_color(String skin_color) {
		this.skin_color = skin_color;
	}

	public String getEye_color() {
		return eye_color;
	}

	public void setEye_color(String eye_color) {
		this.eye_color = eye_color;
	}

	public String getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(String birth_year) {
		this.birth_year = birth_year;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHomeworld() {
		return homeworld;
	}

	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}

	public List<String> getSpecies() {
		return species;
	}

	public void setSpecies(List<String> species) {
		this.species = species;
	}

	public List<String> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<String> vehicles) {
		this.vehicles = vehicles;
	}

	public List<String> getStarships() {
		return starships;
	}

	public void setStarships(List<String> starships) {
		this.starships = starships;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public ZonedDateTime getCreatedZD() {
		createdZD = ZonedDateTime.parse(created);
		return createdZD;
	}

	public void setCreatedZD(ZonedDateTime createdZD) {
		this.createdZD = createdZD;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	public ZonedDateTime getEditedZN() {
		editedZN = ZonedDateTime.parse(edited);
		return editedZN;
	}

	public void setEditedZN(ZonedDateTime editedZN) {
		this.editedZN = editedZN;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Método que cambia las URL de las películas por el título de las mismas
	 * @param films {@code List} con las URL de las películas
	 * @return {@code List} con los títulos de las películas
	 */
	public static List<String> getTitleFilm(List<String> films) {
		List<String> titleFilm = new ArrayList<>(films);
		titleFilm.forEach(f->titleFilm.set(titleFilm.indexOf(f), JsonUtils.leerObjeto(JsonUtils.getEnlaceAPI(f), Films.class).getTitle()));
		return titleFilm;
	}

	@Override
	public String toString() {
		return url
				+"\n· Nombre: "+name
				+"\n· Altura: "+height+" cm"
				+"\n· Peso: "+mass+" kg"
				+"\n· Color de pelo: " + hair_color
				+"\n· Color de piel: "+skin_color
				+"\n· Color de ojos: "+eye_color
				+"\n· Año de nacimiento: "+birth_year
				+"\n· Género: "+ gender
				+"\n· Mundo natal: "+homeworld
				+"\n· Películas: " +films.stream().collect(Collectors.joining(", "))
				+"\n· Especies: "+species.stream().collect(Collectors.joining(", "))
				+"\n· Vehículos: "+vehicles.stream().collect(Collectors.joining(", "))
				+"\n· Naves espaciales: "+starships.stream().collect(Collectors.joining(", "))
				+"\n· Creado: "+getCreatedZD().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss VV"))
				+"\n· Editado: "+getEditedZN().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss VV"));
	}

	@Override
	public int hashCode() {
		return Objects.hash(url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		return Objects.equals(url, other.url);
	}
	
}
