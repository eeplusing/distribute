package com.lixuan.thread;

/************************************************************************************
 * @Title        : ThreadTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月1日 上午9:58:05
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ThreadTest {
	public static void main(String[] args){
		Thread t1 = new Thread(new Hello());
		Thread t2 = new Thread(new Hello());
		t1.start();
		t2.start();
		
		Hello1 t3 = new Hello1();
		Hello1 t4 = new Hello1();
		t3.start();
		t4.start();
		
	}
}
