package org.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Component;

import org.demo.AspectFactory.Aspector;

@Component
public class DemoAspector implements Aspector {

	@Override
	public void process(Map<String, Object> paramValueMap) {
		Object obj = paramValueMap.get("name");
		paramValueMap.put("name", toNew(obj));

	}

	public String toNew(Object obj) {
		return "newName";
	}
}
