package com.smm.common.dto;

public class AnswerNodeItem {
	private Long nodeId;
	private String question;
	private String answer;

	public AnswerNodeItem() {
		super();
	}

	public AnswerNodeItem(Long nodeId, String question, String answer) {
		super();
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

	@Override
	public String toString() {
		return "AnswerNodeItem [nodeId=" + nodeId + ", question=" + question + ", answer=" + answer + "]";
	}

}
