package com.lixuan.thread.synchronize;

/************************************************************************************
 * @Title        : TicketDemo.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月13日 上午10:55:02
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class TicketDemo {

	public static void main(String[] args) {
		/*Ticket t1 = new Ticket();
		Ticket t2 = new Ticket();
		Ticket t3 = new Ticket();
		Ticket t4 = new Ticket();*/
		
		/*这种方式：线程启用后，调用的都是t.run()*/
		Ticket t = new Ticket();//创建一个线程对象
		//Ticket tt = new Ticket();//创建一个线程对象
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);
		/*Thread t3 = new Thread(tt);
		Thread t4 = new Thread(tt);
		*/
		/**/
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}
