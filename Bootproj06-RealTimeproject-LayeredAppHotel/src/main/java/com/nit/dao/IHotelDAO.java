package com.nit.dao;

import java.util.List;

import com.nit.model.Hotel;

public interface IHotelDAO {
     public List<Hotel> getHotelByDesgs(String desg1, String desg2, String desg3)throws Exception;
}
