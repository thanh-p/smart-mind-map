package com.smm.map.controller;

import java.util.List;

import com.smm.map.dto.*;
import com.smm.map.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smm.map.service.MapService;

@RestController
@RequestMapping("map/api/v1")
public class MapController {
	private MapService mapService;

	public MapController(MapService mapService) {
		super();
		this.mapService = mapService;
	}

	@GetMapping(value = "/topics")
	public ResponseEntity<List<TopicResponse>> getAllTopic() {
		List<TopicResponse> topicResponseList = mapService.findAllTopic();
		return ResponseEntity.ok().body(topicResponseList);
	}

	@GetMapping(value = "/topics/{topicId}")
	public TopicResponse getTopic(@PathVariable long topicId) {
		return mapService.findTopicById(topicId);
	}

	@GetMapping(value = "/topics/{topicId}/maps")
	public List<MapResponse> getMapsOfTopic(@PathVariable long topicId) {
		return mapService.findMapsByTopicId(topicId);
	}

	@GetMapping(value = "/maps/{mapId}")
	public MapDetailsResponse getMap(@PathVariable long mapId) {
		return mapService.findMapById(mapId);
	}

	@GetMapping(value = "/nodes/{nodeId}")
	public MapNodeResponse getNode(@PathVariable long nodeId) {
		return mapService.findMapNodeById(nodeId);
	}

	@PostMapping(value = "/topics")
	public void saveTopic(@RequestBody TopicRequest topicRequest) {
		mapService.save(topicRequest);
	}

	@PostMapping(value = "/maps")
	public void saveMap(@RequestBody MapRequest mapRequest) {
		mapService.save(mapRequest);
	}

	@PostMapping(value = "/nodes")
	public void saveMapNode(@RequestBody MapNodeRequest mapNodeRequest) {
		mapService.save(mapNodeRequest);
	}
}
