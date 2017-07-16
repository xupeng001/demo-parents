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
public class PermissionAspect {

	@Autowired(required = false)
	DemoFactory demoFactory;

	@Before("@annotation(org.demo.annotations.DemoPermission)")
	public void before(JoinPoint caller) {
		DemoPermission annotation = getAnnotation(caller, DemoPermission.class);
		System.out.println("before-->" + annotation);

		Map<String, Object> functionParamValueMap = getFunctionParamValueMap(caller);
		Object object = functionParamValueMap.get("name");
		System.out.println(object);
		process(caller, functionParamValueMap);
		object = functionParamValueMap.get("name");
		System.out.println(object);

	}

	@After("@annotation(org.demo.annotations.DemoPermission)")
	public void after(JoinPoint caller) {
		DemoPermission annotation = getAnnotation(caller, DemoPermission.class);
		System.out.println("after-->" + annotation);

	}

	@Around("@annotation(org.demo.annotations.DemoPermission)")
	public Object around(ProceedingJoinPoint pjp) {
		DemoPermission annotation = getAnnotation(pjp, DemoPermission.class);
		System.out.println("around-->" + annotation);
		Map<String, Object> functionParamValueMap = getFunctionParamValueMap(pjp);
		Object object = functionParamValueMap.get("name");
		System.out.println(object);
		process(pjp, functionParamValueMap);
		Object proceed = null;
		try {
			proceed = pjp.proceed();
		} catch (Throwable e) {
		}
		object = functionParamValueMap.get("name");
		System.out.println(object);
		return proceed;
	}

	private void process(JoinPoint caller, Map<String, Object> paramValueMap) {
		DemoAspect demoAspect;
		Aspector aspector;
		if (null != demoFactory
				&& (demoAspect = getAnnotation(caller, DemoAspect.class)) != null
				&& (aspector = demoFactory.getAspector(demoAspect.name())) != null) {
			aspector.process(paramValueMap);
		}
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

	private Map<String, Object> getFunctionParamValueMap(JoinPoint caller) {
		Map<String, Object> result = new HashMap<>();
		if (caller.getSignature() instanceof MethodSignature) {
			Object[] paramsValues = caller.getArgs();
			MethodSignature methodSignature = (MethodSignature) caller
					.getSignature();
			String[] paramNames = methodSignature.getParameterNames();
			for (int i = 0, len = paramNames.length; i < len; i++) {
				String paramName = paramNames[i];
				Object paramValue = paramsValues[i];
				result.put(paramName, paramValue);
			}
		}
		return result;
	}
}
