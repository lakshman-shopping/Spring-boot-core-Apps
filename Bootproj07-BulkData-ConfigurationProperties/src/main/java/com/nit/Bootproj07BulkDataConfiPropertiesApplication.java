package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.nit.sbeans.Company;

@SpringBootApplication
@PropertySource("com/lucky/commans/Info.properties")
public class Bootproj07BulkDataConfiPropertiesApplication {

	public static void main(String[] args) {
		//get IOC Container
		ApplicationContext ctx = SpringApplication.run(Bootproj07BulkDataConfiPropertiesApplication.class, args);
		
		//get spring bean class obj ref
		Company company = ctx.getBean("comp",Company.class);
		System.out.println(company);
		//Close the container
		((ConfigurableApplicationContext) ctx).close();
	}

}
