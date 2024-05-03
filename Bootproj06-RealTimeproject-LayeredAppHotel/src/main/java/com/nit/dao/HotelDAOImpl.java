package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.model.Hotel;

@Repository("htlDAO")
public class HotelDAOImpl implements IHotelDAO {
     public static final String GET_HOTEL_BY_DESGS=
    		 "SELECT H_ROOMNO,COUSTOMER_NAME,H_NAME,HROOM_AMOUNT,CITY_NAME FROM HOTEL WHERE H_NAME IN(?,?,?)ORDER BY H_NAME";
	@Autowired
	private DataSource ds;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Hotel> getHotelByDesgs(String desg1, String desg2, String desg3) throws Exception {
		  List<Hotel> list = null;
		try(//get pooled connection from dataSource
				Connection con = ds.getConnection();
				//create prepareStatement obj using con obj
				PreparedStatement ps = con.prepareStatement(GET_HOTEL_BY_DESGS);
			   ){//try with resource
			   //set method args as the query param values
			ps.setString(1, desg1);  ps.setString(2, desg2); ps.setString(3, desg3);
			try(//exceute the query
					ResultSet rs =ps.executeQuery();
					){//nested try with resource
				//Initailze the ArrayList
				    list =new ArrayList();
				  //process the resultset to copy its records list<Hotel>obj as the Hotel obj
			       while(rs.next()) {
			    	   //copy each record to hotel obj
				    	Hotel htl = new Hotel();
					    htl.setHno(rs.getInt(1));
					    htl.setCname(rs.getString(2));
					    htl.setHroom(rs.getString(3));
					    htl.setHamount(rs.getDouble(4));
					    htl.setHcity(rs.getString(5));
					    //add hotel obj  to list collection
					    list.add(htl);
				    }//end while
			}//try2
		}//try with resource
		catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
