package com.lixuan.thread.synchronize;

/************************************************************************************
 * @Title        : MyStack.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月3日 下午10:02:22
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class MyStack {
	private int idx = 0;
	private char[] data = new char[6];
	
	public void push(char c){
		synchronized(this){
			data[idx] = c;
			idx++;
		}
	}
	
	/**
	 * 
	*若一个方法的整个方法体都包含在synchronized语句块中，则可以把synchronized关键字放在方法的生命中
	*这种方法便于理解，较常用，但对象锁的时间稍长
	 */
	/*public synchronized void push(char c){
		data[idx] = c;
		idx++;
	}*/
	
	public char pop(){
		synchronized(this){
			idx--;
			return data[idx];
		}
	}
	
	public int getIdx(){
		return idx;
	}

}
