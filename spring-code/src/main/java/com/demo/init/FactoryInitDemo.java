package com.demo.init;

import org.springframework.core.io.ClassPathResource;

import com.demo.bean.MessageAction;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class FactoryInitDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:spring/beans.xml");
		System.out.println(ctx.getBean(MessageAction.class));
		ctx = new ClassPathXmlApplicationContext(
				new String[] { "classpath:spring/beans.xml" });
		System.out.println(ctx.getBean(MessageAction.class));

		ctx = new FileSystemXmlApplicationContext(
				"D:\\ecdemo\\demo-parents\\spring-code\\src\\main\\resources\\spring\\beans.xml");
		System.out.println(ctx.getBean(MessageAction.class));

		BeanFactory factory = new XmlBeanFactory(
				new FileSystemResource(
						"D:\\ecdemo\\demo-parents\\spring-code\\src\\main\\resources\\spring\\beans.xml"));
		System.out.println(factory.getBean(MessageAction.class));

		factory = new XmlBeanFactory(
				new ClassPathResource(
						"classpath:spring/beans.xml"));
		System.out.println(factory.getBean(MessageAction.class));
	}
}
