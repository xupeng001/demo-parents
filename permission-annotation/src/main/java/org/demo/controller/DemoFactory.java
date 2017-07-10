package org.demo.controller;

import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.demo.AspectFactory;

@Component
public class DemoFactory implements AspectFactory {

	public static final String NAME = "name_to_new_name";

	@Autowired
	DemoAspector aspector;

	@Override
	public Aspector getAspector(String name) {
		if (NAME.equals(name)) {
			return aspector;
		}
		return null;
	}

}
