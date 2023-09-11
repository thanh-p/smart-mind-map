package com.smm.evaluator.ai.message;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.smm.common.dto.AnswerNodeItem;

@Service
public class KafkaMessagePublisher {

	@Autowired
	private KafkaTemplate<String, Object> template;

	public void sendAnswerNodeItem(AnswerNodeItem answerNodeItem) {
		CompletableFuture<SendResult<String, Object>> future = template.send("answer_node_item", answerNodeItem);
		future.whenComplete((result, ex) -> {
			if (ex == null) {
				System.out.println("Sent message=[" + answerNodeItem.toString() + "] with offset=["
						+ result.getRecordMetadata().offset() + "]");
			} else {
				System.out.println(
						"Unable to send message=[" + answerNodeItem.toString() + "] due to : " + ex.getMessage());
			}
		});

	}

}
