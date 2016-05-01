package com.lixuan.thread;

/************************************************************************************
 * @Title        : Hello1.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月1日 上午10:06:03
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Hello1 extends Thread {
	int i;
	public void run(){
		while(true){
			System.out.println("Hello1" + i++);
			if(i == 5) break;
		}
	}
}
