package cn.edu.hqu.cst.java.rent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "cn.edu.hqu.cst.java.rent.repository")
public class RentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentSystemApplication.class, args);
	}

}
