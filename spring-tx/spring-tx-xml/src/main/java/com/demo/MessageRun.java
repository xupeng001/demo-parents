package com.demo;

import java.util.List;

import com.demo.bean.Message;
import com.demo.dao.MessageDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageRun {

	@Test
	public void run() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:beans.xml");
		MessageDao dao = (MessageDao) ctx.getBean("libraryFactory");
		dao.insert(new Message("title", "context"));
		List<Message> listAll = dao.listAll();
		System.out.println(listAll.size());
	}
}
