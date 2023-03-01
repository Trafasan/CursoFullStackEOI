package com.sandra.finalfantasy.entidades;

import java.util.Objects;

public class Personaje {
	private String id;
	private String name;
	private String age;
	private String gender;
	private String race;
	private String job;
	private String height;
	private String weight;
	private String origin;
	
	public Personaje() {
		
	}

	public Personaje(String id, String name, String age, String gender, String race, String job, String height,
			String weight, String origin) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.race = race;
		this.job = job;
		this.height = height;
		this.weight = weight;
		this.origin = origin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		return "Personaje:"+
				"\nId: "+id+"\nNombre: "+name+"\nEdad: "+age+"\nGénero: "+gender+"\nRaza: "+race+
				"\nTrabajo: "+job+"\nAltura: "+height+"\nPeso: "+weight+"\nOrigen: "+origin+"\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
