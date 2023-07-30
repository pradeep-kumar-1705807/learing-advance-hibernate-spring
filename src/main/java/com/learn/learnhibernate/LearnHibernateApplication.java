package com.learn.learnhibernate;

import com.learn.learnhibernate.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@AutoConfiguration
public class LearnHibernateApplication {

	@Autowired
	private StudentServiceImpl service;

	public static void main(String[] args) {
		SpringApplication.run(LearnHibernateApplication.class, args);
	}





}
