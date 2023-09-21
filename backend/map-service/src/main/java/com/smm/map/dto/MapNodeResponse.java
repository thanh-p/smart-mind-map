package com.smm.map.dto;

import java.util.List;

public class MapNodeResponse {

	private Long id;

	private String name;

	private String description;

	private List<MapNodeResponse> childNodes;

	public MapNodeResponse() {
	}

	public MapNodeResponse(Long id, String name, String description, List<MapNodeResponse> childNodes) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.childNodes = childNodes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MapNodeResponse> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(List<MapNodeResponse> childNodes) {
		this.childNodes = childNodes;
	}
}
