package com.ecsolutions;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ecsolutions.dao")
public class SingleviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingleviewApplication.class, args);
	}
}
