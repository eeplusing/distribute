package com.lixuan.thread.synchronize;

/************************************************************************************
 * @Title        : Ticket.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月13日 上午10:51:59
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Ticket2 implements Runnable{// extends Thread 
	//static属性是多个对象共享的属性，即多个实例共享这个属性。当实例1修改这个属性后，实例2再使用该属性时属性的值是实例1修改后的值
	private int num = 100;
	private Object obj = new Object();
	public boolean flag = true;
	public void run(){
		if(flag == true){
			while(true){
				synchronized(obj){
					show();
				}
			}
		}else{
			while(true){   
				show();	
			}
		}
	}
	
	//静态同步函数使用的锁是   该函数所属字节码文件对象，可以使用this.getClass()获取，或通过当前类名.class即ClassName.class获取。
	public synchronized void show(){
		synchronized(obj){
			if(num > 0){
				try{Thread.sleep(10);}catch(InterruptedException e){}
				System.out.println(Thread.currentThread().getName() + "方法锁，出售：" + num--);
			}
		}
	}
}



















