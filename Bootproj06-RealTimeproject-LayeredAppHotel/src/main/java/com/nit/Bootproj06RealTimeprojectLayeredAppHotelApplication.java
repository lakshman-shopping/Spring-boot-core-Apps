package com.nit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nit.controller.HotelOpertionsController;
import com.nit.model.Hotel;

@SpringBootApplication
public class Bootproj06RealTimeprojectLayeredAppHotelApplication {

	public static void main(String[] args) {
		//get Ioc Container
		ApplicationContext ctx = SpringApplication.run(Bootproj06RealTimeprojectLayeredAppHotelApplication.class, args);
		//get access the controller class obj
		HotelOpertionsController controller =ctx.getBean("htlController",HotelOpertionsController.class);
		//invoke b.logic method
		try {
			List<Hotel> list = controller.showHotelByDesgs("LUXARY", "AC", "NON-AC");
			list.forEach(htl->{
				System.out.println(htl);
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		//close Ioc Container
		((ConfigurableApplicationContext)ctx).close();
	}
      
}
