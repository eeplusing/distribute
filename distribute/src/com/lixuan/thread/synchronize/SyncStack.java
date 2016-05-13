package com.lixuan.thread.synchronize;

import java.util.Vector;

/************************************************************************************
 * @Title        : SyncStack.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月3日 下午10:40:10
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class SyncStack {
	private Vector<Character> buffer = new Vector<Character>(400, 200);
	
	public synchronized char pop(){
		char c;
		while(buffer.size() == 0){
			try{
				this.wait();
			}catch(InterruptedException e){}
		}
		
		c = ((Character)buffer.remove(buffer.size() - 1)).charValue();
		return c;
	}
	public synchronized void push(char c){
		this.notify();
		Character charObj = new Character(c);
		buffer.addElement(charObj);
	}
}
