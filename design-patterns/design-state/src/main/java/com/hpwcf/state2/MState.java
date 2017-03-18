package com.hpwcf.state2;

public class MState extends MyState{

	@Override
	public void dosomething(Mypersson mypersson) {
		// TODO Auto-generated method stub
		if(mypersson.getHour()==7){
			System.out.println("吃早饭");
		}else{
			mypersson.setMyState(new LState());
			mypersson.doSomething();
		}
	}
	

}
