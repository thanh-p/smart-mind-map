package com.smm.map.converter;

import com.smm.map.dto.*;
import com.smm.map.model.Map;
import com.smm.map.model.MapNode;
import com.smm.map.model.Topic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataConverter {

    public Topic toTopic(TopicRequest topicRequest) {
        return new Topic(topicRequest.getName());
    }

    public Map toMap(MapRequest mapRequest, Topic topic) {
        return new Map(mapRequest.getName(), mapRequest.getVersion(), mapRequest.getDescription(), topic);
    }

    public MapNode toMapNode(MapNodeRequest mapNodeRequest, MapNode parent, Map map) {
        return new MapNode(mapNodeRequest.getName(), mapNodeRequest.getDescription(), parent, map);
    }

    public TopicResponse toTopicResponse(Topic topic) {
        return new TopicResponse(topic.getId(), topic.getName());
    }

    public MapNodeResponse toMapNodeResponse(MapNode mapNode) {
        return new MapNodeResponse
                (mapNode.getId(), mapNode.getName(), mapNode.getDescription(), toMapNodeResponseList(mapNode.getChildNode()));
    }

    public MapDetailsResponse toMapDetailsResponse(Map map) {
        return new MapDetailsResponse(map.getId(), map.getName()
                , map.getDescription(), map.getVersion(), toMapNodeResponseList(map.getMapNodes()));
    }

    public List<MapNodeResponse> toMapNodeResponseList(List<MapNode> mapNodeList) {
        return mapNodeList.stream().map(node
                -> new MapNodeResponse(node.getId(),
                node.getName(), node.getDescription(),
                toMapNodeResponseList(node.getChildNode()))).toList();
    }
}
