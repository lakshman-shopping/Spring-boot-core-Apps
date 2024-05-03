package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.DAO.IEmployeeDAO;
import com.nit.model.Employee;

@Service("empSerivce")
public class EmployeeMangmtServiceImpl implements IEmployeeMangmtService {

	@Autowired
	private IEmployeeDAO empDAO;
	@Override
	public List<Employee> fetchEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {
		//use DAO
		List<Employee> list = empDAO.getEmployeeBydesgs(desg1, desg2, desg3);
		list.forEach(emp->{
			//b.logic to calculate the grosssalary and netsalary
			emp.setGrossSalary(emp.getSalary()+(emp.getSalary()*0.4));
			emp.setNetSalary(emp.getGrossSalary()-(emp.getSalary()*0.2));
		});
		return list;
	}

}
