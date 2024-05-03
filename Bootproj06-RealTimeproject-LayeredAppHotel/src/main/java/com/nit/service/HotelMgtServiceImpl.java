package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dao.IHotelDAO;
import com.nit.model.Hotel;

@Service("htlService")
public class HotelMgtServiceImpl implements IHotelMgtService {
    
	@Autowired
	private IHotelDAO htlDao;
	@Override
	public List<Hotel> fetchHotelsByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<Hotel> list = htlDao.getHotelByDesgs(desg1, desg2, desg3);
		list.forEach(htl->{
			//b.logic to calculate the cgstAmount and sgst Amount
			htl.setHcgstAmount(htl.getHamount()+(htl.getHamount()*0.08));
			htl.setHsgstAmount(htl.getHcgstAmount()-(htl.getHamount()*0.04));
		});
		return list;
	}

}
