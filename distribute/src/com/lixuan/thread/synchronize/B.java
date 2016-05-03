package com.lixuan.thread.synchronize;

/************************************************************************************
 * @Title        : B.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月3日 下午10:08:37
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class B extends Thread{
	MyStack s;
	char c;
	public B(MyStack s){
		this.s = s;
	}
	
	public void run(){
		for(int i = 0; i < 100; i++){
			if(s.getIdx() > 0){
				c = s.pop();
				System.out.println("A:push " + c);
			}
		}
	}
}
