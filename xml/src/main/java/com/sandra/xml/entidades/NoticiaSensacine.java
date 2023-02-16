package com.sandra.xml.entidades;

import java.time.LocalDate;
import java.util.Objects;

public class NoticiaSensacine {
	private String category;
	private String title;
	private String description;
	private String author;
	private String guid;
	private LocalDate pubDate;
	
	public NoticiaSensacine() {
		
	}

	public NoticiaSensacine(String category, String title, String description, String author, String guid,
			LocalDate pubDate) {
		super();
		this.category = category;
		this.title = title;
		this.description = description;
		this.author = author;
		this.guid = guid;
		this.pubDate = pubDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public LocalDate getPubDate() {
		return pubDate;
	}

	public void setPubDate(LocalDate pubDate) {
		this.pubDate = pubDate;
	}

	@Override
	public String toString() {
		return "NoticiaSensacine [category=" + category + ", title=" + title + ", description=" + description
				+ ", author=" + author + ", guid=" + guid + ", pubDate=" + pubDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(guid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoticiaSensacine other = (NoticiaSensacine) obj;
		return Objects.equals(guid, other.guid);
	}
	
}
