package com.smm.map.dto;

public class MapNodeRequest {

	private String description;

	private String title;

	private Long parentNodeId;

	private long mapId;

	public MapNodeRequest() {
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

	public Long getParentNodeId() {
		return parentNodeId;
	}

	public void setParentNodeId(Long parentNodeId) {
		this.parentNodeId = parentNodeId;
	}

	public long getMapId() {
		return mapId;
	}

	public void setMapId(long mapId) {
		this.mapId = mapId;
	}
}
