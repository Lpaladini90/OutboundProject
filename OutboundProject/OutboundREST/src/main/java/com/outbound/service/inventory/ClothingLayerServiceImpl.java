package com.outbound.service.inventory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outbound.entities.User;
import com.outbound.entities.inventory.ClothingLayer;
import com.outbound.repository.ClothingLayerRepository;
import com.outbound.service.AuthService;

@Service
public class ClothingLayerServiceImpl implements ClothingLayerService {

	@Autowired
	private ClothingLayerRepository layerRepo;

	@Autowired
	AuthService authServ;

	@Override
	public List<ClothingLayer> indexAllLayers(String username) {
		User user = authServ.getUserByUsername(username);

		if (user != null) {
			return layerRepo.findAll();
		}
		return null;
	}

	@Override
	public ClothingLayer findById(String username, int layerId) {

		User user = authServ.getUserByUsername(username);

		if (user != null) {
			Optional<ClothingLayer> layerOp = layerRepo.findById(layerId);
			if (layerOp.isPresent()) {
				ClothingLayer layer = layerOp.get();
				return layer;
			}

		}

		return null;
	}

	@Override
	public ClothingLayer createLayer(String username, ClothingLayer layer) {
		User user = authServ.getUserByUsername(username);

		if (user != null) {

			return layerRepo.saveAndFlush(layer);

		}

		return null;
	}

	@Override
	public ClothingLayer updateLayer(String username, int layerId, ClothingLayer layer) {

		User user = authServ.getUserByUsername(username);

		if (user != null) {
			Optional<ClothingLayer> layerOp = layerRepo.findById(layerId);
			if (layerOp.isPresent()) {
				ClothingLayer managed = layerOp.get();
				managed.setType(layer.getType());
				managed.setDescription(layer.getDescription());
				managed.setActive(true);
				
				layerRepo.saveAndFlush(managed);
				
				return managed;

			}

		}

		return null;
	}

	@Override
	public List<ClothingLayer> findByType(String username, String keyword) {
		String search = "%" + keyword + "%";

		User user = authServ.getUserByUsername(username);

		if (user != null) {
			List<ClothingLayer> layers = layerRepo.findByTypeLikeOrDescriptionLike(keyword, search);
			return layers;
			
		}
		
		return null;
	}

	@Override
	public boolean deleteLayer(String username, int layerId) {
		boolean deleted = false;
		
		User user = authServ.getUserByUsername(username);

		if (user != null) {
			Optional<ClothingLayer> layerOp = layerRepo.findById(layerId);
			if (layerOp.isPresent()) {
				ClothingLayer toBeDeleted = layerOp.get();
				deleted = true;
				layerRepo.delete(toBeDeleted);
				
				return deleted;

			}

		
		
		}
		return deleted;
	}
}



