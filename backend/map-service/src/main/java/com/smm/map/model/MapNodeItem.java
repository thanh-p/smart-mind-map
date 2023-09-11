package com.smm.map.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MapNodeItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "node_id")
	@JsonIgnore
	private MapNode nodeId;

	private String question;
	private String answer;

	public MapNodeItem() {
		super();
	}

	public MapNodeItem(MapNode nodeId, String question, String answer) {
		super();
		this.id = id;
		this.nodeId = nodeId;
		this.question = question;
		this.answer = answer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MapNode getNodeId() {
		return nodeId;
	}

	public void setNodeId(MapNode nodeId) {
		this.nodeId = nodeId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
