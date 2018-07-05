package cn.edu.hqu.cst.java.rent.service;

import cn.edu.hqu.cst.java.rent.domain.entity.Student;

public interface StudentService {
	public Student login(String phoneNumber,String password);
	public boolean register(Student student);
	public Student getUserDetail(int id);
}
