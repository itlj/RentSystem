package cn.edu.hqu.cst.java.rent.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mastermsg")
public class MasterMsg {
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Getter
	@Setter
	@Column(name = "category")
	private String category;

	@Getter
	@Setter
	@Column(name = "price")
	private String price;

	@Getter
	@Setter
	@Column(name = "postedtime")
	@NotEmpty
	private String postedtime;

	@Getter
	@Setter
	@Column(name = "masterid")
	@JoinColumn(table = "master", name = "id", nullable = false)
	private int masterid;

	@Getter
	@Setter
	@Column(name = "houseid")
	@JoinColumn(table = "house", name = "id", nullable = false)
	private int houseid;
}
