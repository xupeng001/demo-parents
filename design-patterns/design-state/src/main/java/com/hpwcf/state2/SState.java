package com.hpwcf.state2;

public class SState extends MyState{

	@Override
	public void dosomething(Mypersson mypersson) {
		// TODO Auto-generated method stub
		if(mypersson.getHour()==18){
			System.out.println("吃晚饭时间");
		}else{
			mypersson.setMyState(new NoState());
			mypersson.doSomething();
		}
	}

}
