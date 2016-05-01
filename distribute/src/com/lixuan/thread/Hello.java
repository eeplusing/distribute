package com.lixuan.thread;

/************************************************************************************
 * @Title        : Hello.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月1日 上午9:56:07
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Hello implements Runnable{
	int i;
	public void run(){
		while(true){
			System.out.println("Hello" + i++);
			if(i == 5) break;
		}
	}

}
