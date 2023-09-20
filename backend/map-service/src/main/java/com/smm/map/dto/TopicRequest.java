package com.smm.map.dto;

public class TopicRequest {

	private String name;

	public TopicRequest() {
	}

	public TopicRequest(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
