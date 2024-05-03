package com.nit.service;

import java.util.List;

import com.nit.model.Hotel;

public interface IHotelMgtService {
       public List<Hotel> fetchHotelsByDesgs(String desg1,String desg2,String desg3)throws Exception;
}
