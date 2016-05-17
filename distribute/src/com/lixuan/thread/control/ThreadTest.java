package com.lixuan.thread.control;

/************************************************************************************
 * @Title        : ThreadTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月14日 下午5:46:44
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ThreadTest {
	public static void main(String[] agrs){
		new Thread(new Runnable(){
			public void run(){
				System.out.println("runnableThread");
			}
		}){
			//public void run(){
				//System.out.println("subThread");
			//}
		}.start();
	}
}
