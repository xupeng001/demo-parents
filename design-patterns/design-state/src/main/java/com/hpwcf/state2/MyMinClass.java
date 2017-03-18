package com.hpwcf.state2;

public class MyMinClass {
public static void main(String[] args) {
	Mypersson persson = new Mypersson();
	
	persson.setHour(18);
	persson.doSomething();
	
	
	persson.setHour(7);
	persson.doSomething();
	
	persson.setHour(12);
	persson.doSomething();
	
	
	
	
	
	
	persson.setHour(19);
	persson.doSomething();
	
	
	persson.setHour(7);
	persson.doSomething();
	
}
}
