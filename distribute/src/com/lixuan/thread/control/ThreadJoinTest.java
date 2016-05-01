package com.lixuan.thread.control;

/************************************************************************************
 * @Title        : ThreadJoinTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月1日 下午5:02:32
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ThreadJoinTest {
	public static void main(String[] args) throws InterruptedException{
		int i = 0;
		Hello t = new Hello();
		t.start();
		while(true){
			System.out.println("Good morning " + i++ );
			if(i == 2 && t.isAlive()){
				System.out.println("main Thread waiting for Hello Thread");
				t.join();
			}
			if(i == 5)
				break;
		}
	}
}
