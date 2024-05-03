package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nit.model.Hotel;
import com.nit.service.IHotelMgtService;

@Controller("htlController")
public class HotelOpertionsController {

	@Autowired
	private IHotelMgtService htlService;
	
	public List<Hotel> showHotelByDesgs(String desg1,String desg2,String desg3)throws Exception{
		List<Hotel> list = htlService.fetchHotelsByDesgs(desg1, desg2, desg3);
		return list;
	}
}
