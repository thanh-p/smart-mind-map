package com.smm.map.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class MapNode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	private String title;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	@JsonIgnore
	private MapNode parentNode;

	@OneToMany(mappedBy = "parentNode")
	private List<MapNode> childNode;
	
	@OneToMany(mappedBy = "nodeId")
	private List<MapNodeItem> nodeItems;

	@ManyToOne
	@JoinColumn(name = "diagram")
	@JsonIgnore
	private Map diagram;

	private int level;

	public MapNode() {
		super();
	}

	public MapNode(String title, String description, MapNode parentNode, Map diagram) {
		super();
		this.description = description;
		this.title = title;
		this.parentNode = parentNode;
		this.diagram = diagram;

		if (parentNode == null) {
			this.level = 1;
		} else {
			this.level = parentNode.level + 1;
		}
	}

	public MapNode(String title, String description, MapNode parent) {
		super();
		this.description = description;
		this.title = title;

		if (parent == null) {
			throw new IllegalArgumentException("Diagram Node is not allowed to be NULL.");
		}

		this.parentNode = parent;
		this.diagram = parent.diagram;
		this.level = parent.level + 1;
	}
	
	public MapNode(Long id, String title, String description, List<MapNode> childNode) {
		super();
		this.id = id;
		this.description = description;
		this.title = title;
		this.childNode = childNode;
		this.level = 0;
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

	public MapNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(MapNode parentNode) {
		this.parentNode = parentNode;
	}

	public Map getDiagram() {
		return diagram;
	}

	public void setDiagram(Map diagram) {
		this.diagram = diagram;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<MapNode> getChildNode() {
		return childNode;
	}

	public void setChildNode(List<MapNode> childNode) {
		this.childNode = childNode;
	}

	public List<MapNodeItem> getNodeItems() {
		return nodeItems;
	}

	public void setNodeItems(List<MapNodeItem> nodeItems) {
		this.nodeItems = nodeItems;
	}

}
