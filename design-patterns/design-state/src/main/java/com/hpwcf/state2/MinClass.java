package com.hpwcf.state2;


public class MinClass {
public static void main(String[] args) {
	Persson persson = new Persson();
	persson.setHour(7);
	persson.doSomething();
	
	
	persson.setHour(12);
	persson.doSomething();
	
	
	
	persson.setHour(18);
	persson.doSomething();
	
	
	persson.setHour(19);
	persson.doSomething();
}
}
