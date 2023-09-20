package com.smm.map.dto;

public class MapNodeItemResponse {
	private Long nodeId;
	private String question;
	private String answer;

	public MapNodeItemResponse() {
	}

	public MapNodeItemResponse(Long nodeId, String question, String answer) {
		this.nodeId = nodeId;
		this.question = question;
		this.answer = answer;
	}

	public Long getNodeId() {
		return nodeId;
	}

	public void setNodeId(Long nodeId) {
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
