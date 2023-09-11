package com.smm.map.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.smm.common.dto.AnswerNodeItem;
import com.smm.map.service.MapService;

@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);
    
	private MapService diagramService;

	public KafkaMessageListener(MapService diagramService) {
		super();
		this.diagramService = diagramService;
	}

    @KafkaListener(topics = "answer_node_item",groupId = "answer_consumers")
    public void consumeEvents(AnswerNodeItem answerNodeItem) {
        log.info("consumer consume the events {} ", answerNodeItem);
        diagramService.save(answerNodeItem);
    }
}
