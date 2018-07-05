package cn.edu.hqu.cst.java.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.edu.hqu.cst.java.rent.domain.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	public Student findById(int id);

	Student findByPhoneNumber(String PhoneNumber);

}
