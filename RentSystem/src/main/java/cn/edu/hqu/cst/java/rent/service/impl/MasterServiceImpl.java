package cn.edu.hqu.cst.java.rent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hqu.cst.java.rent.domain.entity.Master;
import cn.edu.hqu.cst.java.rent.repository.MasterRepository;
import cn.edu.hqu.cst.java.rent.service.MasterService;

@Service
@Transactional
public class MasterServiceImpl implements MasterService {
	@Autowired
	MasterRepository masterRepository;

	@Override
	public Master login(String phoneNumber, String password) {
		Master master = masterRepository.findByPhoneNumber(phoneNumber);

		if (master != null && master.getPassword().equals(password)) {
			System.out.println(master.getName());
			return master;
		}
		return null;
	}

	@Override
	public boolean register(Master master) {
		if (masterRepository.findByPhoneNumber(master.getPhoneNumber()) == null) {
			masterRepository.save(master);
			return true;
		}
		return false;
	}

	@Override
	public Master getUserDetail(int id) {
		return masterRepository.findById(id);
	}

}
