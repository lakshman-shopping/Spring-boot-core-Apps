package com.nit.sbeans;

import org.springframework.stereotype.Component;

@Component("dEngine")
public class DieselEngine implements IEngine {

	public DieselEngine() {
		System.out.println("DieselEngine: 0-param-constructor");
	}
	@Override
	public void start() {
		System.out.println("DieselEngine.start()");
	}

	@Override
	public void stop() {
		System.out.println("DieselEngine.stop()");

	}

}
