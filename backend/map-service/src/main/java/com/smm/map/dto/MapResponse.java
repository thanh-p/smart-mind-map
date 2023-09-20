package com.smm.map.dto;

public class MapResponse {

	protected Long id;
	protected String title;

	protected String description;

	protected String version;

	public MapResponse() {
	}

	public MapResponse(Long id, String title, String description, String version) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
