package org.demo;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.demo.AspectFactory.Aspector;
import org.demo.annotations.DemoAspect;
import org.demo.annotations.DemoPermission;
import org.demo.controller.DemoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xupeng
 * @annotation
 */
//@Aspect
//@Component
public class PermissionAspectWithIn {

	@Autowired(required = false)
	DemoFactory demoFactory;

	@Before("@within(org.demo.annotations.DemoPermission)")
	public void before(JoinPoint caller) {
		DemoPermission annotation = getAnnotation(caller, DemoPermission.class);
		System.out.println("before-->" + annotation);

	}

	private <T extends Annotation> T getAnnotation(JoinPoint caller,
			Class<T> annotationClass) {
		if (caller.getSignature() instanceof MethodSignature) {
			MethodSignature methodSignature = (MethodSignature) caller
					.getSignature();
			return methodSignature.getMethod().getAnnotation(annotationClass);
		}
		return null;
	}

}
