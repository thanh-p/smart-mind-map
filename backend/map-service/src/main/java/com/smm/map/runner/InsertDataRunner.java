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
    private MapRepository diagramRepository;

    @Autowired
    private MapNodeRepository diagramNodeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Topic topic = new Topic("Design");
        Map diagram = new Map("Design Patterns", "v0.1", "", topic);
        MapNode diagramNode1 = new MapNode("Creational Patterns", "", null, diagram);
        MapNode diagramNode2 = new MapNode("Structural Patterns", "", null, diagram);
        MapNode diagramNode3 = new MapNode("Behavioral Patterns", "", null, diagram);
        
        if (topicRepository.count() > 0) {
        	return;
        }
        
        topicRepository.save(topic);
        diagramRepository.save(diagram);
        diagramNodeRepository.save(diagramNode1);
        diagramNodeRepository.save(diagramNode2);
        diagramNodeRepository.save(diagramNode3);
        
        diagramNodeRepository.save(new MapNode("Factory Method", "", diagramNode1));
        diagramNodeRepository.save(new MapNode("Abstract Factory", "", diagramNode1));
        diagramNodeRepository.save(new MapNode("Builder", "", diagramNode1));
        diagramNodeRepository.save(new MapNode("Prototype", "", diagramNode1));
        diagramNodeRepository.save(new MapNode("Singleton", "", diagramNode1));    
    
        diagramNodeRepository.save(new MapNode("Adapter", "", diagramNode2));
        diagramNodeRepository.save(new MapNode("Bridge", "", diagramNode2));
        diagramNodeRepository.save(new MapNode("Composite", "", diagramNode2));
        diagramNodeRepository.save(new MapNode("Decorator", "", diagramNode2));
        diagramNodeRepository.save(new MapNode("Facade", "", diagramNode2)); 
        diagramNodeRepository.save(new MapNode("Flyweight", "", diagramNode2)); 
        diagramNodeRepository.save(new MapNode("Proxy", "", diagramNode2)); 
        
        diagramNodeRepository.save(new MapNode("Chain of Responsibility", "", diagramNode3));
        diagramNodeRepository.save(new MapNode("Command", "", diagramNode3));
        diagramNodeRepository.save(new MapNode("Iterator", "", diagramNode3));
        diagramNodeRepository.save(new MapNode("Mediator", "", diagramNode3));
        diagramNodeRepository.save(new MapNode("Memento", "", diagramNode3)); 
        diagramNodeRepository.save(new MapNode("Observer", "", diagramNode3)); 
        diagramNodeRepository.save(new MapNode("State", "", diagramNode3));
        diagramNodeRepository.save(new MapNode("Strategy", "", diagramNode3));
        diagramNodeRepository.save(new MapNode("Template Method", "", diagramNode3));
        diagramNodeRepository.save(new MapNode("Visitor", "", diagramNode3));
    }
}