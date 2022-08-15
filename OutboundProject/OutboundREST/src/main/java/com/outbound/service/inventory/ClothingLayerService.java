package com.outbound.service.inventory;

import java.util.List;

import com.outbound.entities.inventory.ClothingLayer;

public interface ClothingLayerService {
	
	 List<ClothingLayer> indexAllLayers(String username);
	
	 ClothingLayer findById(String username, int layerId);
	 
	 ClothingLayer createLayer(String username, ClothingLayer layer);
	 
	 ClothingLayer updateLayer(String username, int itemCatId, ClothingLayer layer);
	 
	 List<ClothingLayer> findByType(String username, String keyword);

	 boolean deleteLayer(String username, int layerId);
}
