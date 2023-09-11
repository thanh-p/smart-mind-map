package com.smm.map.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smm.map.model.MapNode;
import com.smm.map.model.MapNodeItem;

public interface MapNodeItemRepository extends JpaRepository<MapNodeItem, Long>{

}
