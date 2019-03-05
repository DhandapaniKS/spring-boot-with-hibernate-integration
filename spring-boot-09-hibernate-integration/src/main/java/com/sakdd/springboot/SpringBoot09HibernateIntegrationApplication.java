package com.sakdd.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.sakdd.springboot.config.DatabaseHibernateConfiguration;

@Import(DatabaseHibernateConfiguration.class)
@SpringBootApplication
public class SpringBoot09HibernateIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot09HibernateIntegrationApplication.class, args);
	}

}
