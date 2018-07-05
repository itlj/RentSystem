package cn.edu.hqu.cst.java.rent.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hqu.cst.java.rent.domain.entity.Student;
import cn.edu.hqu.cst.java.rent.repository.StudentRepository;
import cn.edu.hqu.cst.java.rent.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student login(String phoneNumber, String password) {
		Student student = studentRepository.findByPhoneNumber(phoneNumber);

		if (student != null && student.getPassword().equals(password)) {
			System.out.println(student.getName());
			return student;
		}
		return null;
	}

	@Override
	public boolean register(Student student) {
		if((studentRepository.findByPhoneNumber(student.getPhoneNumber()))==null) {
			studentRepository.save(student);
			return true;
		}
		return false;
	}

	@Override
	public Student getUserDetail(int id) {
		return studentRepository.findById(id);
	}
}
