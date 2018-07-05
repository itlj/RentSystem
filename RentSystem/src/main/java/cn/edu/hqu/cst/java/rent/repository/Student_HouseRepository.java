package cn.edu.hqu.cst.java.rent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.edu.hqu.cst.java.rent.domain.entity.Student_House;

@Repository
public interface Student_HouseRepository extends JpaRepository<Student_House, Integer> {
	public Student_House findById(int id);

	public Student_House findByStudentidAndHouseid(int studentid, int houseid);

	public List<Student_House> findAllByStudentid(int id);

	public List<Student_House> findAllByMasterid(int id);
}
