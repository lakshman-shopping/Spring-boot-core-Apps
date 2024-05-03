package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nit.model.Employee;
import com.nit.service.IEmployeeMangmtService;

@Controller("empController")
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeMangmtService empService;
	
	public List<Employee>  showEmployeeByDesgs(String desg1,String desg2,String desg3)throws Exception{
		//use service
		List<Employee> list=empService.fetchEmployeesByDesgs(desg1, desg2, desg3);
		return list;
	}
}
