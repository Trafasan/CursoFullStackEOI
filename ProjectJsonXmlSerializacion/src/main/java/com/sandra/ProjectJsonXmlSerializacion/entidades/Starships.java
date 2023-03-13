package com.sandra.ProjectJsonXmlSerializacion.entidades;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Starships implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String model;
	private String starship_class;
	private String manufacturer;
	private String cost_in_credits;
	private String length;
	private String crew;
	private String passengers;
	private String max_atmosphering_speed;
	private String hyperdrive_rating;
	private String MGLT;
	private String cargo_capacity;
	private String consumables;
	private List<String> films;
	private List<String> pilots;
	private String url;
	private String created;
	private transient ZonedDateTime createdZD;
	private String edited;
	private transient ZonedDateTime editedZN;
	
	public Starships() {
		films = new ArrayList<String>();
		pilots = new ArrayList<String>();
	}

	public Starships(String name, String passengers) {
		super();
		this.name = name;
		this.passengers = passengers;
	}

	public Starships(String name, String model, String starship_class, String manufacturer, String cost_in_credits,
			String length, String crew, String passengers, String max_atmosphering_speed, String hyperdrive_rating,
			String mGLT, String cargo_capacity, String consumables, List<String> films, List<String> pilots, String url,
			String created, ZonedDateTime createdZD, String edited, ZonedDateTime editedZN) {
		super();
		this.name = name;
		this.model = model;
		this.starship_class = starship_class;
		this.manufacturer = manufacturer;
		this.cost_in_credits = cost_in_credits;
		this.length = length;
		this.crew = crew;
		this.passengers = passengers;
		this.max_atmosphering_speed = max_atmosphering_speed;
		this.hyperdrive_rating = hyperdrive_rating;
		MGLT = mGLT;
		this.cargo_capacity = cargo_capacity;
		this.consumables = consumables;
		this.films = films;
		this.pilots = pilots;
		this.url = url;
		this.created = created;
		this.createdZD = createdZD;
		this.edited = edited;
		this.editedZN = editedZN;
	}

	public Starships(String name, String model, String starship_class, String manufacturer, String cost_in_credits,
			String length, String crew, String passengers, String max_atmosphering_speed, String hyperdrive_rating,
			String mGLT, String cargo_capacity, String consumables, List<String> films, List<String> pilots, String url,
			String created, String edited) {
		super();
		this.name = name;
		this.model = model;
		this.starship_class = starship_class;
		this.manufacturer = manufacturer;
		this.cost_in_credits = cost_in_credits;
		this.length = length;
		this.crew = crew;
		this.passengers = passengers;
		this.max_atmosphering_speed = max_atmosphering_speed;
		this.hyperdrive_rating = hyperdrive_rating;
		MGLT = mGLT;
		this.cargo_capacity = cargo_capacity;
		this.consumables = consumables;
		this.films = films;
		this.pilots = pilots;
		this.url = url;
		this.created = created;
		this.edited = edited;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getStarship_class() {
		return starship_class;
	}

	public void setStarship_class(String starship_class) {
		this.starship_class = starship_class;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCost_in_credits() {
		return cost_in_credits;
	}

	public void setCost_in_credits(String cost_in_credits) {
		this.cost_in_credits = cost_in_credits;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public String getPassengers() {
		return passengers;
	}

	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}

	public String getMax_atmosphering_speed() {
		return max_atmosphering_speed;
	}

	public void setMax_atmosphering_speed(String max_atmosphering_speed) {
		this.max_atmosphering_speed = max_atmosphering_speed;
	}

	public String getHyperdrive_rating() {
		return hyperdrive_rating;
	}

	public void setHyperdrive_rating(String hyperdrive_rating) {
		this.hyperdrive_rating = hyperdrive_rating;
	}

	public String getMGLT() {
		return MGLT;
	}

	public void setMGLT(String mGLT) {
		MGLT = mGLT;
	}

	public String getCargo_capacity() {
		return cargo_capacity;
	}

	public void setCargo_capacity(String cargo_capacity) {
		this.cargo_capacity = cargo_capacity;
	}

	public String getConsumables() {
		return consumables;
	}

	public void setConsumables(String consumables) {
		this.consumables = consumables;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}

	public List<String> getPilots() {
		return pilots;
	}

	public void setPilots(List<String> pilots) {
		this.pilots = pilots;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	@Override
	public String toString() {
		return url
				+"\n· Nombre: "+name
				+"\n· Modelo: "+model
				+"\n· Clase: "+starship_class
				+"\n· Fabricante: "+manufacturer
				+"\n· Coste: "+cost_in_credits+" créditos galácticos"
				+"\n· Longitud: "+length+" m"
				+"\n· Personal necesario: "+crew
				+"\n· Capacidad para pasajeros: "+passengers
				+"\n· Velocidad atmosférica máxima: " + max_atmosphering_speed
				+"\n· Clase del hipermotor: "+hyperdrive_rating
				+"\n· MGLT: "+MGLT+" MGLT"
				+"\n· Capacidad de carga: "+cargo_capacity+" kg"
				+"\n· Abastecimiento: "+consumables
				+"\n· Películas: "+films.stream().collect(Collectors.joining(", "))
				+"\n· Pilotos: "+pilots.stream().collect(Collectors.joining(", "))
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
		Starships other = (Starships) obj;
		return Objects.equals(url, other.url);
	}
	
}
