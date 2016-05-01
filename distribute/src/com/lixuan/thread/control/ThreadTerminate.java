package com.lixuan.thread.control;

/************************************************************************************
 * @Title        : ThreadTerminate.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月1日 下午5:22:18
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ThreadTerminate {

	public static void main(String[] args) {
		int i = 0;
		Hello2 h = new Hello2();
		Thread t = new Thread(h);
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
		System.out.println("please stop saying Hello and say goof morning!");
		h.stopRunning();
		
		while(i < 5){
			System.out.println("Good morning" + i++);
		}

	}

}
