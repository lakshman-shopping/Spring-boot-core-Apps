package com.nit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
     private static final String GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?)ORDER BY JOB";
	@Autowired
	private DataSource ds;
	@SuppressWarnings("rawtypes")
	@Override
	public List<Employee> getEmployeeBydesgs(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> list = null;
		try(//get pooled connection from datasource
				Connection con = ds.getConnection();
				//create preparedstatement obj using the  con obj
				PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DESGS);
				){//try with resource
			   //set method args as the query param values
			ps.setString(1,desg1);  ps.setString(2,desg2); ps.setString(3, desg3);
		    try(//execute the sql query
		    		ResultSet rs =ps.executeQuery();
		    		){//nested try with resource
		    	//Initailze the ArrayList
		    	   list = new ArrayList();
		    	   //process the resultset to copy its records list<Employee>obj as the Employee obj
		    	
		    	while(rs.next()) {
		    		//copy each record to employee obj
		    		Employee emp = new Employee();
		    		emp.setEno(rs.getInt(1));
		    		emp.setEname(rs.getString(2));
		    		emp.setJob(rs.getString(3));
		    		emp.setSalary(rs.getDouble(4));
		    		emp.setDeptno(rs.getInt(5));
		    		//add Employee class obj to List collection
		    		list.add(emp);
		    	}//while
		    }	//nested try
		} //try with resource
		catch(SQLException se) {//for handling known exception
			se.printStackTrace();
			throw se;  //Exception propagation
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e; 
		}
		return list;
	}

}
