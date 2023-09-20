package com.smm.map.dto;

import java.util.ArrayList;
import java.util.List;

public class MapDetailsResponse extends MapResponse {

	private List<MapNodeResponse> nodes = new ArrayList<>();

	public MapDetailsResponse() {
	}

	public MapDetailsResponse(long id, String title, String description, String version, List<MapNodeResponse> nodes) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.version = version;
		this.nodes = nodes;
	}

	public List<MapNodeResponse> getNodes() {
		return nodes;
	}

	public void setNodes(List<MapNodeResponse> nodes) {
		this.nodes = nodes;
	}
}
