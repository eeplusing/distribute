package com.lixuan.thread.control;

/************************************************************************************
 * @Title        : Hello2.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月1日 下午5:15:57
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Hello2 implements Runnable {
	int i = 0;
	private boolean timeOut = false;
	
	//标志没有被设置前将每隔10ms输出两行hello
	public void run(){
		while(! timeOut){
			System.out.println("Hello" + i++);
			if(i % 2 ==0){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void stopRunning(){
		timeOut = true;
	}
}
