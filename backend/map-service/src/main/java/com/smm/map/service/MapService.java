package com.smm.map.service;

import com.smm.common.dto.AnswerNodeItem;
import com.smm.map.converter.DataConverter;
import com.smm.map.dto.*;
import com.smm.map.model.Map;
import com.smm.map.model.MapNode;
import com.smm.map.model.MapNodeItem;
import com.smm.map.model.Topic;
import com.smm.map.model.repository.MapNodeItemRepository;
import com.smm.map.model.repository.MapNodeRepository;
import com.smm.map.model.repository.MapRepository;
import com.smm.map.model.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MapService {
	private final TopicRepository topicRepository;
	private final MapRepository mapRepository;
	private final MapNodeRepository mapNodeRepository;
	private final MapNodeItemRepository mapNodeItemRepository;

	@Autowired
	private DataConverter dataConverter;

	public MapService(TopicRepository topicRepository, MapRepository mapRepository,
					  MapNodeRepository mapNodeRepository, MapNodeItemRepository mapNodeItemRepository) {
		super();
		this.topicRepository = topicRepository;
		this.mapRepository = mapRepository;
		this.mapNodeRepository = mapNodeRepository;
		this.mapNodeItemRepository = mapNodeItemRepository;
	}

	public List<TopicResponse> findAllTopic() {
		List<Topic> topics = topicRepository.findAll();
		return topics.stream().map(topic -> dataConverter.toTopicResponse(topic)).toList();
	}

	public TopicResponse findTopicById(long topicId) {
		Topic topic = topicRepository.findById(topicId).orElseThrow();
		return dataConverter.toTopicResponse(topic);
	}

	public List<MapResponse> findMapsByTopicId(long topicId) {
		Topic topic = topicRepository.findById(topicId).orElseThrow();
		return topic.getMapList().stream().map(map
				-> new MapResponse(map.getId(), map.getTitle(), map.getDescription(), map.getVersion())).toList();
	}

	public MapDetailsResponse findMapById(long mapId) {
		Map map = mapRepository.findById(mapId).orElseThrow();
		return dataConverter.toMapDetailsResponse(map);
	}

	public MapNodeResponse findMapNodeById(long nodeId) {
		MapNode mapNode = mapNodeRepository.findById(nodeId).orElseThrow();
		return dataConverter.toMapNodeResponse(mapNode);
	}

	public Topic save(TopicRequest topicRequest) {
		Topic topic = dataConverter.toTopic(topicRequest);
		return topicRepository.save(topic);
	}

	public Map save(MapRequest mapRequest) {
		Topic topic = topicRepository.findById(mapRequest.getTopicId()).orElseThrow();
		Map map = dataConverter.toMap(mapRequest, topic);
		return mapRepository.save(map);
	}

	public MapNode save(MapNodeRequest mapNodeRequest) {
		Map map = mapRepository.findById(mapNodeRequest.getMapId()).orElseThrow();
		MapNode parentMapNode = null;

		if (mapNodeRequest.getParentNodeId() != null) {
			parentMapNode = mapNodeRepository.findById(mapNodeRequest.getParentNodeId()).orElseThrow();
		}

		MapNode mapNode = dataConverter.toMapNode(mapNodeRequest, parentMapNode, map);
		return mapNodeRepository.save(mapNode);
	}

	public MapNodeItem save(AnswerNodeItem answerNodeItem) {
		MapNode mapNode = mapNodeRepository.findById(answerNodeItem.getNodeId()).orElseThrow();
		MapNodeItem mapNodeItem = new MapNodeItem(mapNode, answerNodeItem.getQuestion(),
				answerNodeItem.getAnswer());
		return mapNodeItemRepository.save(mapNodeItem);
	}

}
