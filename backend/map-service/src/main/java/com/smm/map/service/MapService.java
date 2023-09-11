package com.smm.map.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.smm.common.dto.AnswerNodeItem;
import com.smm.map.model.Map;
import com.smm.map.model.MapNode;
import com.smm.map.model.MapNodeItem;
import com.smm.map.model.Topic;
import com.smm.map.model.repository.MapNodeItemRepository;
import com.smm.map.model.repository.MapNodeRepository;
import com.smm.map.model.repository.MapRepository;
import com.smm.map.model.repository.TopicRepository;

@Service
public class MapService {
	private TopicRepository topicRepository;
	private MapRepository diagramRepository;
	private MapNodeRepository diagramNodeRepository;
	private MapNodeItemRepository diagramNodeItemRepository;

	public MapService(TopicRepository topicRepository, MapRepository diagramRepository,
			MapNodeRepository diagramNodeRepository, MapNodeItemRepository diagramNodeItemRepository) {
		super();
		this.topicRepository = topicRepository;
		this.diagramRepository = diagramRepository;
		this.diagramNodeRepository = diagramNodeRepository;
		this.diagramNodeItemRepository = diagramNodeItemRepository;
	}

	public List<Topic> getAllTopic() {
		return topicRepository.findAll();
	}

	public Optional<Topic> findTopicById(long topicId) {
		return topicRepository.findById(topicId);
	}

	public Optional<Map> findDiagramById(long diagramId) {
		return diagramRepository.findById(diagramId);
	}

	public Optional<MapNode> findDiagramNodeById(long nodeId) {
		return diagramNodeRepository.findById(nodeId);
	}

	public boolean save(AnswerNodeItem answerNodeItem) {
		Optional<MapNode> diagramNodeOptional = diagramNodeRepository.findById(answerNodeItem.getNodeId());

		if (diagramNodeOptional.isEmpty()) {
			return false;
		}

		MapNodeItem diagramNodeItem = new MapNodeItem(diagramNodeOptional.get(), answerNodeItem.getQuestion(),
				answerNodeItem.getAnswer());
		diagramNodeItemRepository.save(diagramNodeItem);
		return true;
	}

}
