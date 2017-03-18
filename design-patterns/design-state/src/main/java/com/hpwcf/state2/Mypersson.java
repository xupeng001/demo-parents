package com.hpwcf.state2;

public class Mypersson {
	private int hour;
	private MyState myState;
	
	
	
	public Mypersson() {
		myState = new MState();
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public MyState getMyState() {
		return myState;
	}
	public void setMyState(MyState myState) {
		this.myState = myState;
	}
	
	
	public void doSomething(){
		
		myState.dosomething(this);
		myState = new MState();
	}
	
	
	

}
