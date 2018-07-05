package cn.edu.hqu.cst.java.rent.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

////@Entity
//@AllArgsConstructor
//@NoArgsConstructor
////@Table(name = "stumsg")
//public class StuMsg {
//
//	@Getter
//	@Setter
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private Long id;
//
//	@Getter
//	@Setter
//	@Column(name = "message")
//	private String message;
//
//	@Getter
//	@Setter
//	@Column(name = "postedtime")
//	@NotEmpty
//	@Temporal(value = TemporalType.DATE)
//	private Date postedTime;
//
//	@Getter
//	@Setter
//	@ManyToOne
//	@JoinColumn(table = "Student", name = "phonenumber", nullable = false)
//	private Student student;
//
//}
