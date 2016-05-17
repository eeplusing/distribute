package com.lixuan.thread.control;

/************************************************************************************
 * @Title        : JoinDemo.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月14日 下午5:12:28
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class JoinDemo {
	public static void main(String[] args){
		Demo d = new Demo();
		Thread t0 = new Thread(d);
		Thread t1 = new Thread(d);
		
		t0.start();
		t1.start();
		t1.setPriority(Thread.MIN_PRIORITY);
		for(int i = 0; i < 50; i++){
			System.out.println(Thread.currentThread().getName() + "........" + i);
		}
	}
}

class Demo implements Runnable{
	public void run(){
		for(int i = 0; i < 50; i++){
			System.out.println(Thread.currentThread().getName() + "........" + i);
		}
	}
	
}
