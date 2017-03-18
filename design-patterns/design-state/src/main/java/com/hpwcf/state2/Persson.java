package com.hpwcf.state2;

public class Persson {
	private int hour;

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public void doSomething(){
		if(hour==7){
			System.out.println("���緹");
		}else if(hour==12){
			System.out.println("�����緹");
			
		}else if(hour==18){
			System.out.println("���?");
		}else{
			System.out.println("δ����");
		}
	}

}
