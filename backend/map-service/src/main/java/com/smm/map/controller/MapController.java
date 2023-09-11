package com.smm.map.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smm.map.model.Map;
import com.smm.map.model.MapNode;
import com.smm.map.model.Topic;
import com.smm.map.service.MapService;

@RestController
@RequestMapping("map/api/v1")
public class MapController {
	private MapService diagramService;

	public MapController(MapService diagramService) {
		super();
		this.diagramService = diagramService;
	}

	@GetMapping(value = "/topics")
	public List<Topic> getAllTopic() {
		return diagramService.getAllTopic();
	}

	@GetMapping(value = "/topics/{topicId}")
	public Topic getTopic(@PathVariable long topicId) {
		Optional<Topic> topicOptional = diagramService.findTopicById(topicId);

		if (topicOptional.isEmpty()) {
			return null;
		}

		return topicOptional.get();
	}

	@GetMapping(value = "/topics/{topicId}/diagrams")
	public List<Map> getAllDiagramOfOneTopic(@PathVariable long topicId) {
		Optional<Topic> topicOptional = diagramService.findTopicById(topicId);

		if (topicOptional.isEmpty()) {
			return null;
		}

		List<Map> diagrams = topicOptional.get().getDiagrams();

		return diagrams;
	}

	@GetMapping(value = "/diagrams/{diagramId}/nodes/{nodeId}")
	public MapNode getDiagramNode(@PathVariable long diagramId, @PathVariable long nodeId) {
		Optional<Map> diagramOptional = diagramService.findDiagramById(diagramId);

		if (diagramOptional.isEmpty()) {
			return null;
		}

		if (nodeId == 0) {
			Map diagram = diagramOptional.get();
			MapNode node = new MapNode(diagram.getId(), diagram.getTitle(), diagram.getDescription(), diagram.getDiagramNodes());
			return node;
		}

		Optional<MapNode> diagramNodeOptional = diagramService.findDiagramNodeById(nodeId);

		if (diagramNodeOptional.isEmpty()) {
			return null;
		}

		return diagramNodeOptional.get();
	}
}
