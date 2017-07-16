package com.demo.interf;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	ActionService actionService;

	@Override
	public String say(String name) {
		System.out.println(MessageUtil.name());
		return actionService.doSay(name);
	}

}
