package com.hpwcf.state2;

public class NoState extends MyState{

	@Override
	public void dosomething(Mypersson mypersson) {
		// TODO Auto-generated method stub
		System.out.println(mypersson.getHour() + " 未定义");
		
	}

}
