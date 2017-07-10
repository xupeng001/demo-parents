package com.demo.service.test;

import com.demo.service.impl.MessageServiceImpl;

import com.demo.service.MessageService;
import org.junit.Test;

public class MessageSerivceTest {

	@Test
	public void testSay() {
		MessageService service = new MessageServiceImpl();
		service.say("xp");
	}

}
