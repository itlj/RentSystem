package cn.edu.hqu.cst.java.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.edu.hqu.cst.java.rent.domain.entity.Master;

@Repository
public interface MasterRepository extends JpaRepository<Master, Integer> {
	public Master findById(int id);

	public Master findByPhoneNumber(String phoneNumber);
}
