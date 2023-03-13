package com.sandra.ProjectJsonXmlSerializacion.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Films implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String title;
	private int episode_id;
	private String opening_crawl;
	private String director;
	private String producer;
	private String release_date;
	private transient LocalDate release_dateLD;
	private List<String> characters;
	private List<String> planets;
	private List<String> starships;
	private List<String> vehicles;
	private List<String> species;
	private String created;
	private transient ZonedDateTime createdZD;
	private String edited;
	private transient ZonedDateTime editedZN;
	private String url;
	
	public Films() {
		characters = new ArrayList<String>();
		planets = new ArrayList<String>();
		starships = new ArrayList<String>();
		vehicles = new ArrayList<String>();
		species = new ArrayList<String>();
	}

	public Films(String title, int episode_id, String opening_crawl, String director, String producer,
			String release_date, LocalDate release_dateLD, List<String> characters, List<String> planets,
			List<String> starships, List<String> vehicles, List<String> species, String created,
			ZonedDateTime createdZD, String edited, ZonedDateTime editedZN, String url) {
		super();
		this.title = title;
		this.episode_id = episode_id;
		this.opening_crawl = opening_crawl;
		this.director = director;
		this.producer = producer;
		this.release_date = release_date;
		this.release_dateLD = release_dateLD;
		this.characters = characters;
		this.planets = planets;
		this.starships = starships;
		this.vehicles = vehicles;
		this.species = species;
		this.created = created;
		this.createdZD = createdZD;
		this.edited = edited;
		this.editedZN = editedZN;
		this.url = url;
	}

	public Films(String title, int episode_id, String opening_crawl, String director, String producer,
			String release_date, LocalDate release_dateLD, List<String> characters, List<String> planets,
			List<String> starships, List<String> vehicles, List<String> species, String created,
			String edited, String url) {
		super();
		this.title = title;
		this.episode_id = episode_id;
		this.opening_crawl = opening_crawl;
		this.director = director;
		this.producer = producer;
		this.release_date = release_date;
		this.release_dateLD = release_dateLD;
		this.characters = characters;
		this.planets = planets;
		this.starships = starships;
		this.vehicles = vehicles;
		this.species = species;
		this.created = created;
		this.edited = edited;
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getEpisode_id() {
		return episode_id;
	}

	public void setEpisode_id(int episode_id) {
		this.episode_id = episode_id;
	}

	public String getOpening_crawl() {
		return opening_crawl;
	}

	public void setOpening_crawl(String opening_crawl) {
		this.opening_crawl = opening_crawl;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public LocalDate getRelease_dateLD() {
		release_dateLD = LocalDate.parse(release_date);
		return release_dateLD;
	}

	public void setRelease_dateLD(LocalDate release_dateLD) {
		this.release_dateLD = release_dateLD;
	}

	public List<String> getCharacters() {
		return characters;
	}

	public void setCharacters(List<String> characters) {
		this.characters = characters;
	}

	public List<String> getPlanets() {
		return planets;
	}

	public void setPlanets(List<String> planets) {
		this.planets = planets;
	}

	public List<String> getStarships() {
		return starships;
	}

	public void setStarships(List<String> starships) {
		this.starships = starships;
	}

	public List<String> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<String> vehicles) {
		this.vehicles = vehicles;
	}

	public List<String> getSpecies() {
		return species;
	}

	public void setSpecies(List<String> species) {
		this.species = species;
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

	@Override
	public String toString() {
		return url
				+"\n· Título: "+title
				+"\n· Número del episodio: "+episode_id
				+"\n· Texto de apertura:\n" + opening_crawl
				+"\n· Director: "+director
				+"\n· Productor: "+producer
				+"\n· Fecha de lanzamiento: "+getRelease_dateLD().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+"\n· Personajes: "+characters.stream().collect(Collectors.joining(", "))
				+"\n· Planetas: "+planets.stream().collect(Collectors.joining(", "))
				+"\n· Naves espaciales: "+starships.stream().collect(Collectors.joining(", "))
				+"\n· Vehículos: "+vehicles.stream().collect(Collectors.joining(", "))
				+"\n· Especies: "+species.stream().collect(Collectors.joining(", "))
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
		Films other = (Films) obj;
		return Objects.equals(url, other.url);
	}
}
