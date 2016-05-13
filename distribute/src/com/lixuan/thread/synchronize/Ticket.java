package com.lixuan.thread.synchronize;

/************************************************************************************
 * @Title        : Ticket.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月13日 上午10:51:59
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Ticket implements Runnable{// extends Thread 
	//static属性是多个对象共享的属性，即多个实例共享这个属性。当实例1修改这个属性后，实例2再使用该属性时属性的值是实例1修改后的值
	private int num = 100;
	Object obj = new Object();
	public void run(){
			while(true){
				synchronized(obj){
					if(num > 0){
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + "出售：" + num--);
					}else{
						break;
					}
				}
		}
	}
}



















