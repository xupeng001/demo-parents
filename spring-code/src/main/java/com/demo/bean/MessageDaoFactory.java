package com.demo.bean;

public class MessageDaoFactory {
	public static MessageDao doInstance() {
		return new MessageDao() {
		};
	}
	
	public  MessageDao getInstance() {
		return new MessageDao() {
		};
	}
}
