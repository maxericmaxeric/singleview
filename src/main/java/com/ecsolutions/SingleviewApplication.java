package com.ecsolutions;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@MapperScan(basePackages = "com.ecsolutions.dao")
public class SingleviewApplication extends SpringBootServletInitializer implements WebApplicationInitializer
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SingleviewApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SingleviewApplication.class, args);

//		SpringApplication application = new SpringApplication(SingleviewApplication.class);
//		application.run(args);
	}
}
