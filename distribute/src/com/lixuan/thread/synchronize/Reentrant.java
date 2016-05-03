package com.lixuan.thread.synchronize;

/************************************************************************************
 * @Title        : Reentrant.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月3日 下午10:25:30
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Reentrant {
	public synchronized void a(){
		b();
		System.out.println("here I am, in a()");
	}
	
	public synchronized void b(){
		System.out.println("here I am, in b()");
	}
	
	public static void main(String args[]){
		Reentrant r = new Reentrant();
		r.a();
	}
}
