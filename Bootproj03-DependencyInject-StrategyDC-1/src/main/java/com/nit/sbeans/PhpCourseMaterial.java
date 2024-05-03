package com.nit.sbeans;

import org.springframework.stereotype.Component;

@Component("phMaterial")
public class PhpCourseMaterial implements IMaterial {

	public PhpCourseMaterial() {
		System.out.println("PhpCourseMateria: 0-param constructor");
	}
	@Override
	public void write() {
		System.out.println("PhpCourseMaterial.write()");

	}

	@Override
	public void read() {
		System.out.println("PhpCourseMaterial.read()");
	}

}
