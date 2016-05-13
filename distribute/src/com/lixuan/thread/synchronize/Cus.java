package com.lixuan.thread.synchronize;

/************************************************************************************
 * @Title        : Cus.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月13日 下午2:22:04
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Cus implements Runnable{
	public int sum = 0;
	Bank b = new Bank();
	public void run(){
		for(int i = 0; i < 3; i++){
			b.add(100);
		}
	}

}
