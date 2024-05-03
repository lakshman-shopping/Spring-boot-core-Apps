package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.sbeans.EmployeeInfo;

@SpringBootApplication
public class Bootproj09BulkDataYmlApplication {

	public static void main(String[] args) {
		//get Ioc Container
		ApplicationContext ctx = SpringApplication.run(Bootproj09BulkDataYmlApplication.class, args);
	   //get spring bean class obj ref
		EmployeeInfo emp = ctx.getBean("empInfo",EmployeeInfo.class);
		System.out.println(emp);
		//invoke the method
		((ConfigurableApplicationContext) ctx).close();
	}

}
