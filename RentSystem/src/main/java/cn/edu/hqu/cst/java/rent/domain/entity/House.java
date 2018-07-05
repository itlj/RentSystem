package cn.edu.hqu.cst.java.rent.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "house")
public class House {
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
	@NotEmpty
	@Column(name = "address")
	private String address;

	@Getter
	@Setter
	@NotEmpty
	@Column(name = "type")
	private String type;

	@Getter
	@Setter
	@NotEmpty
	@Column(name = "capacity")
	private String capacity;

	@Getter
	@Setter
	@NotEmpty
	@Column(name = "price")
	private String price;

	@Getter
	@Setter
	@NotEmpty
	@Column(name = "status")
	private String status;

	@Override
	public boolean equals(Object that) {
		// TODO Auto-generated method stub
		return EqualsBuilder.reflectionEquals(this, that, "masterId", "address", "type", "capacity", "price", "status");
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return HashCodeBuilder.reflectionHashCode(this, "masterId", "address", "type", "capacity", "price", "status");
	}
}
