package com.smm.map.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.smm.map.model.Map;
import com.smm.map.model.MapNode;
import com.smm.map.model.Topic;
import com.smm.map.model.repository.MapNodeRepository;
import com.smm.map.model.repository.MapRepository;
import com.smm.map.model.repository.TopicRepository;

@Component
public class InsertDataRunner implements ApplicationRunner {

    @Autowired
    private TopicRepository topicRepository;
    
    @Autowired
    private MapRepository mapRepository;

    @Autowired
    private MapNodeRepository mapNodeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Topic topic = new Topic("Design");
        Map diagram = new Map("Design Patterns", "v0.1", "", topic);
        MapNode mapNode1 = new MapNode("Creational Patterns", "", null, diagram);
        MapNode mapNode2 = new MapNode("Structural Patterns", "", null, diagram);
        MapNode mapNode3 = new MapNode("Behavioral Patterns", "", null, diagram);
        
        if (topicRepository.count() > 0) {
        	return;
        }
        
        topicRepository.save(topic);
        mapRepository.save(diagram);
        mapNodeRepository.save(mapNode1);
        mapNodeRepository.save(mapNode2);
        mapNodeRepository.save(mapNode3);
        
        mapNodeRepository.save(new MapNode("Factory Method", "", mapNode1));
        mapNodeRepository.save(new MapNode("Abstract Factory", "", mapNode1));
        mapNodeRepository.save(new MapNode("Builder", "", mapNode1));
        mapNodeRepository.save(new MapNode("Prototype", "", mapNode1));
        mapNodeRepository.save(new MapNode("Singleton", "", mapNode1));
    
        mapNodeRepository.save(new MapNode("Adapter", "", mapNode2));
        mapNodeRepository.save(new MapNode("Bridge", "", mapNode2));
        mapNodeRepository.save(new MapNode("Composite", "", mapNode2));
        mapNodeRepository.save(new MapNode("Decorator", "", mapNode2));
        mapNodeRepository.save(new MapNode("Facade", "", mapNode2));
        mapNodeRepository.save(new MapNode("Flyweight", "", mapNode2));
        mapNodeRepository.save(new MapNode("Proxy", "", mapNode2));
        
        mapNodeRepository.save(new MapNode("Chain of Responsibility", "", mapNode3));
        mapNodeRepository.save(new MapNode("Command", "", mapNode3));
        mapNodeRepository.save(new MapNode("Iterator", "", mapNode3));
        mapNodeRepository.save(new MapNode("Mediator", "", mapNode3));
        mapNodeRepository.save(new MapNode("Memento", "", mapNode3));
        mapNodeRepository.save(new MapNode("Observer", "", mapNode3));
        mapNodeRepository.save(new MapNode("State", "", mapNode3));
        mapNodeRepository.save(new MapNode("Strategy", "", mapNode3));
        mapNodeRepository.save(new MapNode("Template Method", "", mapNode3));
        mapNodeRepository.save(new MapNode("Visitor", "", mapNode3));
    }
}