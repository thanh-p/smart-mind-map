package com.smm.map.dto;

import java.util.List;

public class MapNodeResponse {

	private Long id;

	private String title;

	private String description;

	private List<MapNodeResponse> childNodes;

	public MapNodeResponse() {
	}

	public MapNodeResponse(Long id, String description, String title, List<MapNodeResponse> childNodes) {
		this.id = id;
		this.description = description;
		this.title = title;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<MapNodeResponse> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(List<MapNodeResponse> childNodes) {
		this.childNodes = childNodes;
	}
}
