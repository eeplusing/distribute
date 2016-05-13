package com.lixuan.thread.synchronize;

/************************************************************************************
 * @Title        : SyncTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月3日 下午10:40:23
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class SyncTest {
	public static void main(String[] args){
		SyncStack stack = new SyncStack();
		
		Producer p1 = new Producer(stack);
		Thread prodT1 = new Thread(p1);
		prodT1.start();
		
		Producer p2 = new Producer(stack);
		Thread prodT2 = new Thread(p2);
		prodT2.start();
		
		Customer c1 = new Customer(stack);
		Thread consT1 = new Thread(c1);
		consT1.start();
		
		Customer c2 = new Customer(stack);
		Thread consT2 = new Thread(c2);
		consT2.start();
		
		
		
		
		
	}
}
