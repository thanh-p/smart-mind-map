package com.smm.map.model;

import java.util.List;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Map {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	private String title;
	
	private String version;

	@OneToMany(mappedBy = "map")
	@Where(clause = "level = '1'")
	private List<MapNode> mapNodes;

	@ManyToOne
	@JoinColumn(name = "topic_id")
	@JsonIgnore
	private Topic topic;

	public Map() {
		super();
	}

	public Map(String title, String version, String description, Topic topic) {
		this.title = title;
		this.version = version;
		this.description = description;
		this.topic = topic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<MapNode> getMapNodes() {
		return mapNodes;
	}

	public void setMapNodes(List<MapNode> mapNodes) {
		this.mapNodes = mapNodes;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
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

}
