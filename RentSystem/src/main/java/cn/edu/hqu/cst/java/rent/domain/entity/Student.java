package cn.edu.hqu.cst.java.rent.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

	@Getter
	@Setter
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@Getter
	@Setter
	@NotEmpty
	@Column(name = "brithday")
	private String brithday;

	@Getter
	@Setter
	@NotEmpty
	@Column(name = "sex")
	private String sex;

	@Override
	public boolean equals(Object that) {
		// TODO Auto-generated method stub
		return EqualsBuilder.reflectionEquals(this, that, "name", "phoneNumber", "address", "password", "birthday",
				"sex");
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return HashCodeBuilder.reflectionHashCode(this, "name", "phoneNumber", "address", "password", "birthday",
				"sex");
	}
}
