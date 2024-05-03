package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.sbeans.Vehicle;

@SpringBootApplication
public class Bootproj02DependencyInjectStrategyDcApplication {

	public static void main(String[] args) {
		// get IOC container
		ConfigurableApplicationContext ctx=SpringApplication.run(Bootproj02DependencyInjectStrategyDcApplication.class, args);
	    
		//get target spring bean class ref
		Vehicle vehicle = ctx.getBean("vehicle", Vehicle.class);
		
		//b.logic 
		 vehicle.journey("Hyderbad", "Us");
		
		 //close IOC container
		 ctx.close();
		
		
	}

}
