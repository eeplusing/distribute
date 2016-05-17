package com.lixuan.thread.control;

/************************************************************************************
 * @Title        : StopThread.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月14日 下午4:10:16
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
/**
 * 停止线程的方法：
 * 1.stop(), 这种方法不安全
 * 2.run()方法结束
 * 	这么控制线程的任务结束？
 * 		任务中都会有循环结构，只要控制中循环就可以结束线程
 * 		若控制循环通畅就用定义标记来完成；
 * 
 * 	如果线程处于了冻结状态，无法读取标记，如何结束呢？
 * 		可以使用interrupt()方法将线程从冻结状态强制回复到运行状态中来，让线程具备cpu的执行资格。
 * 		但是强制动作会发生InterruptedException,要处理
 * 		
 * **/

class StopThread implements Runnable{
	private boolean flag = true;
	public void run(){
		while(flag){
			try{
				wait();
			}catch(InterruptedException e){
				System.out.println(Thread.currentThread().getName() + "......." + e);
				flag = false;
			}
			System.out.println(Thread.currentThread().getName() +  "............");
		}
	}
	
	public void setFlag(){
		flag = false;
	}
}

public class StopThreadDemo {
	public static void main(String[] args){
		StopThread st = new StopThread();
		 
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		
		t1.start();
		t2.setDaemon(true);
		t2.start();
		
		int num = 1;
		for(;;){
			if(++num == 50){
				//st.setFlag();
				t1.interrupt();
				//t2.interrupt();
				break;
			}
			System.out.println("main.........." + num);
		}
		System.out.println("over");
	}
}






