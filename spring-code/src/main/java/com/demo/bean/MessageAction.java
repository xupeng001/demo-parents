package com.demo.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageAction  implements InitializingBean,DisposableBean {

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	private MessageDao dao;

	public MessageDao getDao() {
		return dao;
	}

	public void setDao(MessageDao dao) {
		this.dao = dao;
	}

	public MessageAction(MessageDao dao) {
		super();
		this.dao = dao;
	}

	public MessageAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@PostConstruct
	public void init(){
		System.out.println("init");
	}
	
	
	@PreDestroy
	public void destory(){
		System.out.println("destory");
	}

}
