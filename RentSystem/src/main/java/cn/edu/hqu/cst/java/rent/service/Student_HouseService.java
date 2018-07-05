package cn.edu.hqu.cst.java.rent.service;

import java.util.List;

import cn.edu.hqu.cst.java.rent.domain.entity.Student_House;

public interface Student_HouseService {
	public boolean addRecord(Student_House student_house);

	public boolean deleteRecord(int id);

	public Student_House getDetailInfo(int id);
	
	public List<Student_House> getDetailInfoByStudentid(int id);
	
	public List<Student_House> getDetailInfoByMasterid(int id);
}
