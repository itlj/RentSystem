package cn.edu.hqu.cst.java.rent.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "master")
public class Master {
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Getter
	@Setter
	@NotEmpty
	@Column(name = "password")
	private String password;

	@Getter
	@Setter
	@NotEmpty
	@Column(name = "name")
	private String name;

	@Getter
	@Setter
	@NotEmpty
	@Column(name = "phonenumber")
	private String phoneNumber;

	@Getter
	@Setter
	@NotEmpty
	@Column(name = "address")
	private String address;

	@Override
	public boolean equals(Object that) {
		// TODO Auto-generated method stub
		return EqualsBuilder.reflectionEquals(this, that, "name", "phoneNumber", "address", "password");
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return HashCodeBuilder.reflectionHashCode(this, "name", "phoneNumber", "address", "password");
	}
}
