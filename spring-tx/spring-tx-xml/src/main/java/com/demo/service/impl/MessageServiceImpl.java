package com.demo.service.impl;

import com.demo.service.MessageService;

public class MessageServiceImpl implements MessageService {

	public String say(String name) {
		System.out.println(String.format(" %s say ", name));
		return String.format(" %s say ", name);
	}

}
