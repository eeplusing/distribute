package com.lixuan.thread.synchronize;

/************************************************************************************
 * @Title        : Producer.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月3日 下午10:39:34
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Producer implements Runnable{
	private SyncStack theStack;
	private int num;
	private static int counter = 1;
	
	public Producer(SyncStack s){
		theStack = s;
		num = counter++;
	}

	public void run() {
		char c;
		for(int i = 0; i < 200; i++){
			c = (char)(Math.random() * 26 + 'A');
			theStack.push(c);
			System.out.println("Producer" + num + ":" + c);
			
			try{
				Thread.sleep(300);
			}catch(InterruptedException e){}
		}
		
	}
}
