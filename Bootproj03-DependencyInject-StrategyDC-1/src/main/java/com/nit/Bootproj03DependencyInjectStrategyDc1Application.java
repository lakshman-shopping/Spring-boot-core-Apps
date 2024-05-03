package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.sbeans.Student;

@SpringBootApplication
public class Bootproj03DependencyInjectStrategyDc1Application {

	public static void main(String[] args) {
		//get IOC container
		ConfigurableApplicationContext ctx=SpringApplication.run(Bootproj03DependencyInjectStrategyDc1Application.class, args);
		
		//get access target spring bean class ref
		Student stud = ctx.getBean("student", Student.class);
		
		//b.logic method
		stud.prepare("Fundamental language", "java8Features");
		
		//close IOC container
		ctx.close();
	}

}
