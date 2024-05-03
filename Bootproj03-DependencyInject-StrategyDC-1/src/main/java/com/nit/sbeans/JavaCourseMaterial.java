package com.nit.sbeans;

import org.springframework.stereotype.Component;

@Component("jMaterial")
public class JavaCourseMaterial implements IMaterial {

	public JavaCourseMaterial() {
		System.out.println("JavaCourseMateria: 0-param constructor");
	}
	@Override
	public void write() {
		System.out.println("JavaCourseMaterial.write()");

	}

	@Override
	public void read() {
		System.out.println("JavaCourseMaterial.read()");
	}

}
