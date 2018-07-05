package cn.edu.hqu.cst.java.rent.web.controller.FormEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Getter
	@Setter
	String phoneNumber;
	@Getter
	@Setter
	String password;
}
