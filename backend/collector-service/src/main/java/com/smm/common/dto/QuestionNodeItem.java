package com.smm.common.dto;

public class QuestionNodeItem {
	private Long nodeId;
	private String question;

	public QuestionNodeItem() {
		super();
	}

	public QuestionNodeItem(Long nodeId, String question) {
		super();
		this.nodeId = nodeId;
		this.question = question;
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

	@Override
	public String toString() {
		return "QuestionNodeItem [nodeId=" + nodeId + ", question=" + question + "]";
	}

}
