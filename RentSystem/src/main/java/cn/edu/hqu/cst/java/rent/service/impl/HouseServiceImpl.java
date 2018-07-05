package cn.edu.hqu.cst.java.rent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hqu.cst.java.rent.domain.entity.House;
import cn.edu.hqu.cst.java.rent.repository.HouseRepository;
import cn.edu.hqu.cst.java.rent.service.HouseService;

@Service
@Transactional
public class HouseServiceImpl implements HouseService {
	@Autowired
	HouseRepository houseRepository;

	@Override
	public boolean rentHouse(House house) {
		if (houseRepository.findById(house.getId()) == null) {
			houseRepository.save(house);
			return true;
		}
		return false;
	}

	@Override
	public boolean unrentHouse(int Id) {
		if (houseRepository.findById(Id) != null) {
			houseRepository.deleteById(Id);
			return true;
		}
		return false;
	}

	@Override
	public House getHouseDetail(int Id) {
		// TODO Auto-generated method stub
		return houseRepository.findById(Id);
	}

	@Override
	public boolean updateHouseInfo(House house) {
		houseRepository.save(house);
		return true;
	}

	@Override
	public List<House> getHouseDetailByMasterId(int masterId) {
		return houseRepository.findByMasterid(masterId);
	}
	
	@Override
	public List<House> getAllHouseList(){
		return houseRepository.findAll();
	}
}
