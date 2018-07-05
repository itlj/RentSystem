package cn.edu.hqu.cst.java.rent.service;

import java.util.List;

import cn.edu.hqu.cst.java.rent.domain.entity.House;

public interface HouseService {
	public boolean rentHouse(House house);

	public boolean unrentHouse(int Id);

	public House getHouseDetail(int Id);

	public boolean updateHouseInfo(House house);

	public List<House> getHouseDetailByMasterId(int masterId);

	public List<House> getAllHouseList();
}
