package com.lixuan.thread.control;

/************************************************************************************
 * @Title        : Hello.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月1日 下午5:05:29
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Hello extends Thread {
	int i;
	public void run(){
		while(true){
			System.out.println("Hello" + i++);
			if(i == 5) 
				break;
		}
	}
}
