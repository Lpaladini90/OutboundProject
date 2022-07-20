package com.outbound.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.outbound.entities.User;
import com.outbound.entities.inventory.WeaponType;
import com.outbound.repository.UserRepository;
import com.outbound.repository.WeaponTypeRepository;

@Service
public class WeaponTypeServiceImpl implements WeaponTypeService {

	@Autowired
	private WeaponTypeRepository weapRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private AuthService authServ;

	@Override
	public List<WeaponType> indexAllWeaponTypes(String username) {

		User user = authServ.getUserByUsername(username);

		if (user != null) {
			return weapRepo.findAll();

		}
		return null;
	}

	@Override
	public WeaponType findById(String username, int weaponTypeId) {
		User user = authServ.getUserByUsername(username);

		if (user != null) {
			Optional<WeaponType> typeOp = weapRepo.findById(weaponTypeId);

			if (typeOp.isPresent()) {

				WeaponType type = typeOp.get();
				return type;

			}

		}

		return null;
	}

	@Override
	public WeaponType createWeaponType(String username, WeaponType weaponType) {
		User user = authServ.getUserByUsername(username);

		if (user != null) {

			WeaponType newType = weapRepo.saveAndFlush(weaponType);

			return newType;

		}

		return null;
	}

	@Override
	public WeaponType updateWeaponType(String username, int weaponTypeId, WeaponType weaponType) {
		User user = authServ.getUserByUsername(username);

		if (user != null) {
			Optional<WeaponType> typeOp = weapRepo.findById(weaponTypeId);

			if (typeOp.isPresent()) {

				WeaponType managed = typeOp.get();

				if (managed != null) {

					managed.setName(weaponType.getName());
					managed.setDescription(weaponType.getDescription());
					managed.setCategory(weaponType.getCategory());
					managed.setActive(true);
					weapRepo.saveAndFlush(managed);

					return managed;

				}

			}

		}

		return null;
	}

	@Override
	public WeaponType disableWeaponType(String username, int weaponTypeId, WeaponType weaponType) {
		User user = authServ.getUserByUsername(username);

		if (user != null) {
			Optional<WeaponType> typeOp = weapRepo.findById(weaponTypeId);

			if (typeOp.isPresent()) {

				WeaponType managed = typeOp.get();

				if (managed != null) {

					managed.setActive(false);
					weapRepo.saveAndFlush(managed);

					return managed;

				}

			}

		}

		return null;
	}

	@Override
	public List<WeaponType> findByTypeName(String username, String keyword) {
		keyword = "%" + keyword + "%";

		User user = userRepo.findByUsername(username);

		if (user != null) {

			return weapRepo.findByNameLikeOrDescriptionLike(keyword, keyword);
		}
		return null;
	}

	@Override
	public boolean deleteWeaponType(String username, int weaponTypeId) {
		boolean deleted = false;

		User user = authServ.getUserByUsername(username);

		if (user !=null) {
			Optional<WeaponType> weaponOp = weapRepo.findById(weaponTypeId);
			if (weaponOp.isPresent()) {
				WeaponType type = weaponOp.get();
				weapRepo.delete(type);
				deleted = true;

				return deleted;

			}

		}

		return false;
	}

}
