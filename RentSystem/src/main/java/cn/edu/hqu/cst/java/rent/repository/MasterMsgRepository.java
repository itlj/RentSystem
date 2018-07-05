package cn.edu.hqu.cst.java.rent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.edu.hqu.cst.java.rent.domain.entity.MasterMsg;


@Repository
public interface MasterMsgRepository extends JpaRepository<MasterMsg, Integer> {
	public MasterMsg findById(int id);
	
	public List<MasterMsg> findAllByMasterid(int id);
}