package cn.edu.hqu.cst.java.rent.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_house")
public class Student_House {
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Getter
	@Setter
	@Column(name = "masterid")
	@JoinColumn(table = "master", name = "id", nullable = false)
	private int masterid;

	@Getter
	@Setter
	@Column(name = "studentid")
	@JoinColumn(table = "student", name = "id", nullable = false)
	private int studentid;

	@Getter
	@Setter
	@Column(name = "houseid")
	@JoinColumn(table = "house", name = "id", nullable = false)
	private int houseid;

	@Getter
	@Setter
	@Column(name = "meetplace")
	private String meetplace;

	@Getter
	@Setter
	@Column(name = "meettime")
	private String meettime;
}
