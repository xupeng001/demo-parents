package com.hpwcf.state2;


public class LState extends MyState{

	@Override
	public void dosomething(Mypersson mypersson) {
		// TODO Auto-generated method stub
		if(mypersson.getHour()==12){
		System.out.println("吃午饭");
	}else{
		mypersson.setMyState(new SState());
		mypersson.doSomething();
	}
	}

}
