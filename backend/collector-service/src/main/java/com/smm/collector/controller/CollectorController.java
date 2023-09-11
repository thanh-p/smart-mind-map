package com.smm.collector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smm.collector.message.KafkaMessagePublisher;
import com.smm.common.dto.QuestionNodeItem;

@RestController
@RequestMapping("v1/api")
public class CollectorController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @PostMapping("/nodes/items")
    public void sendKnowledgeNodeItem(@RequestBody QuestionNodeItem questionNodeItem) {
        publisher.sendQuestionNodeItem(questionNodeItem);
    }

}
