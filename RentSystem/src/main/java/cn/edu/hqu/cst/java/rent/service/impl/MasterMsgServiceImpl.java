package cn.edu.hqu.cst.java.rent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hqu.cst.java.rent.domain.entity.MasterMsg;
import cn.edu.hqu.cst.java.rent.repository.MasterMsgRepository;
import cn.edu.hqu.cst.java.rent.service.MasterMsgService;

@Service
@Transactional
public class MasterMsgServiceImpl implements MasterMsgService {
	@Autowired
	MasterMsgRepository masterMsgRepository;

	@Override
	public boolean addMsg(MasterMsg masterMsg) {
		// TODO Auto-generated method stub
		if (masterMsgRepository.findById(masterMsg.getId()) == null) {
			masterMsgRepository.save(masterMsg);
		}
		return false;
	}

	@Override
	public List<MasterMsg> getAllMsgByMasterid(int id) {
		// TODO Auto-generated method stub
		return masterMsgRepository.findAllByMasterid(id);
	}

}
