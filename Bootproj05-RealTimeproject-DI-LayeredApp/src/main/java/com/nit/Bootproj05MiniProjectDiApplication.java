package com.nit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.controller.EmployeeOperationsController;
import com.nit.model.Employee;

@SpringBootApplication
public class Bootproj05MiniProjectDiApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(Bootproj05MiniProjectDiApplication.class, args);
		//get access the controller class obj
		EmployeeOperationsController controller = ctx.getBean("empController",EmployeeOperationsController.class);
		//invoke b.logic method
		try {
			List<Employee> list= controller.showEmployeeByDesgs("CLERK", "MANAGER", "SALESMAN");
			list.forEach(emp->{
				System.out.println(emp);
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		//close the IOC container
		((ConfigurableApplicationContext)ctx).close();
	}

}
