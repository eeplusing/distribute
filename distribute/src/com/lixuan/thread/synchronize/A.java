package com.lixuan.thread.synchronize;

/************************************************************************************
 * @Title        : A.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月3日 下午10:05:40
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class A extends Thread {
	MyStack s;
	char c;
	public A(MyStack s){
		this.s = s;
	}
	
	public void run(){
		for(int i = 0; i < 100; i++){
			if(s.getIdx() < 5){
				c = (char)(Math.random() * 26 + 'A');
				s.push(c);
				System.out.println("A:push " + c);
			}
		}
	}
}
