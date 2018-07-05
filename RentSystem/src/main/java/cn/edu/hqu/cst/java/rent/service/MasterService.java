package cn.edu.hqu.cst.java.rent.service;

import java.util.Optional;

import cn.edu.hqu.cst.java.rent.domain.entity.Master;

public interface MasterService {
	public Master login(String phoneNumber,String password);
	public boolean register(Master master);
	public Master getUserDetail(int id);

}
