package cn.edu.hqu.cst.java.rent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.edu.hqu.cst.java.rent.domain.entity.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {
	public House findById(int id);

	public List<House> findByMasterid(int masterid);
}
