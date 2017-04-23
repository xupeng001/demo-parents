package com.demo;

import org.junit.Test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class App {

    @Test
    public void test() {
        BeanPostPrcessorImpl beanPostProcessor = new BeanPostPrcessorImpl();
        Resource resource = new FileSystemResource("d://applicationContext.xml");
        @SuppressWarnings("deprecation")
        ConfigurableBeanFactory factory = new XmlBeanFactory(resource);
        factory.addBeanPostProcessor(beanPostProcessor);
        Object bean = factory.getBean("demo");
        System.out.println(bean);
    }
}
