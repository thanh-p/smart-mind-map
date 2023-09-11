package com.smm.collector.message;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.smm.common.dto.QuestionNodeItem;

@Service
public class KafkaMessagePublisher {

	@Autowired
	private KafkaTemplate<String, Object> template;

	public void sendQuestionNodeItem(QuestionNodeItem questionNodeItem) {
		CompletableFuture<SendResult<String, Object>> future = template.send("question_node_item", questionNodeItem);
		future.whenComplete((result, ex) -> {
			if (ex == null) {
				System.out.println("Sent message=[" + questionNodeItem.toString() + "] with offset=["
						+ result.getRecordMetadata().offset() + "]");
			} else {
				System.out.println(
						"Unable to send message=[" + questionNodeItem.toString() + "] due to : " + ex.getMessage());
			}
		});

	}

}
