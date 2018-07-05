package cn.edu.hqu.cst.java.rent.service;

import java.util.List;

import cn.edu.hqu.cst.java.rent.domain.entity.MasterMsg;

public interface MasterMsgService {
	public boolean addMsg(MasterMsg masterMsg);

	public List<MasterMsg> getAllMsgByMasterid(int id);
}
