package com.smm.evaluator.ai.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.smm.common.dto.AnswerNodeItem;
import com.smm.common.dto.QuestionNodeItem;
import com.smm.evaluator.ai.model.LanguageModelService;

@Service
public class KafkaMessageListener {

	Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

	private KafkaMessagePublisher kafkaMessagePublisher;
	private LanguageModelService languageModelService;

	public KafkaMessageListener(KafkaMessagePublisher kafkaMessagePublisher,
			LanguageModelService languageModelService) {
		super();
		this.kafkaMessagePublisher = kafkaMessagePublisher;
		this.languageModelService = languageModelService;
	}

	@KafkaListener(topics = "question_node_item", groupId = "question_answerers")
	public void consumeEvents(QuestionNodeItem questionNodeItem) {
		log.info("AI evaluator consume the events {} ", questionNodeItem);
		String description = languageModelService.getAnswer(questionNodeItem.getQuestion());
		AnswerNodeItem answerNodeItem = new AnswerNodeItem(questionNodeItem.getNodeId(), questionNodeItem.getQuestion(),
				description);
		kafkaMessagePublisher.sendAnswerNodeItem(answerNodeItem);
	}
}