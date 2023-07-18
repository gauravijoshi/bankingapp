package com.xoriant.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.xoriant.banking.aop.LogAspect;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BankingServiceApplication{	

	
	
	public static void main(String[] args) {
		SpringApplication.run(BankingServiceApplication.class, args);
	}
	
	@Bean
	public LogAspect logAspect() {
			
		return new LogAspect();
			
	}

}
