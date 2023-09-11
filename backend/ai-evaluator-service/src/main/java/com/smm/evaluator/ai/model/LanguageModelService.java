package com.smm.evaluator.ai.model;

import org.springframework.stereotype.Service;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.model.huggingface.HuggingFaceChatModel;

@Service
public class LanguageModelService {
	private static final String TOKEN = "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";

	public String getAnswer(String question) {
		HuggingFaceChatModel model = HuggingFaceChatModel.withAccessToken(TOKEN);
		AiMessage answer = model.sendUserMessage(question);
		return answer.text();
	}
}
