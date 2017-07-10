package org.demo.controller;

import org.demo.annotations.DemoAspect;

import org.demo.annotations.DemoPermission;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@DemoAspect(name = DemoFactory.NAME)
	@DemoPermission
	@RequestMapping("/demo")
	public String demo(String name) {
		System.out.println("demo--->" + name);
		return "demo";
	}

}
	