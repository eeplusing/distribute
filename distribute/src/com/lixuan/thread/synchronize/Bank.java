package com.lixuan.thread.synchronize;

/************************************************************************************
 * @Title        : Bank.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月13日 下午2:20:49
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Bank {
	private int sum;
	public Object obj = new Object();
	
	/*同步方法*/
	public synchronized void add(int num){
		sum = sum + num;
		try{
			Thread.sleep(10);
		}catch(InterruptedException e){
			
		}
		System.out.println("sum=" + sum);
	}
	
	/*同步代码块*/
/*	public void add(int num){
		synchronized(obj){
			sum = sum + num;
			try{Thread.sleep(10);}catch(InterruptedException e){}
			System.out.println("sum=" + sum);
		}
	}
*/}
