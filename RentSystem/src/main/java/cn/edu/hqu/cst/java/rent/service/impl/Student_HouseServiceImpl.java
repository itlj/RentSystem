package cn.edu.hqu.cst.java.rent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hqu.cst.java.rent.domain.entity.Student_House;
import cn.edu.hqu.cst.java.rent.repository.Student_HouseRepository;
import cn.edu.hqu.cst.java.rent.service.Student_HouseService;

@Service
@Transactional
public class Student_HouseServiceImpl implements Student_HouseService {
	@Autowired
	Student_HouseRepository student_houseRepository;

	@Override
	public boolean addRecord(Student_House student_house) {
		// TODO Auto-generated method stub
		if (student_houseRepository.findByStudentidAndHouseid(student_house.getStudentid(),
				student_house.getHouseid()) == null) {
			student_houseRepository.save(student_house);
		}
		return false;
	}

	@Override
	public boolean deleteRecord(int id) {
		// TODO Auto-generated method stub
		if (student_houseRepository.findById(id) != null) {
			student_houseRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Student_House getDetailInfo(int id) {
		// TODO Auto-generated method stub
		return student_houseRepository.findById(id);
	}

	@Override
	public List<Student_House> getDetailInfoByStudentid(int id) {
		// TODO Auto-generated method stub
		return student_houseRepository.findAllByStudentid(id);
	}

	@Override
	public List<Student_House> getDetailInfoByMasterid(int id) {
		// TODO Auto-generated method stub
		return student_houseRepository.findAllByMasterid(id);
	}

}
