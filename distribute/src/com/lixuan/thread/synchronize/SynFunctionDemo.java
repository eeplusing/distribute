package com.lixuan.thread.synchronize;

/************************************************************************************
 * @Title        : TicketDemo.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月13日 上午10:55:02
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class SynFunctionDemo {

	public static void main(String[] args) {
		Ticket1 t = new Ticket1();//创建一个线程对象
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start();
		
		//使主线程睡眠10ms
		try{Thread.sleep(10);}catch(InterruptedException e){}
		t.flag = false;
		t2.start();
	}
}
