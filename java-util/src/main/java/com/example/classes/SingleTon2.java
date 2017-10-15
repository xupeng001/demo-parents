package com.example.classes;

public class SingleTon2 {

	public static int count1 = 7;
	public static int count2 = 0;
	public int count3;

	
	public SingleTon2() {
		System.out.println("count1= " + count1);
		System.out.println("count2= " + count2);
		System.out.println("count3= " + count3);
		count1++;
		count2++;
		count3++;
	}

	public static void main(String[] args) {
		SingleTon2 singleTon = new SingleTon2();
		System.out.println("count1=" + SingleTon2.count1);
		System.out.println("count2=" + SingleTon2.count2);
		System.out.println("count3=" + singleTon.count3);
	}

}
