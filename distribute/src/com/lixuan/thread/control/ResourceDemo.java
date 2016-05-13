package com.lixuan.thread.control;

/************************************************************************************
 * @Title        : ResourceDemo.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月13日 下午5:51:50
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/

class ResourceDemo{
	public static void main(String[] args){
		Resource r = new Resource();
		Input in = new Input(r);
		Output out = new Output(r);
		
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		
		t1.start();
		t2.start();
	}
}

class Output implements Runnable {
	Resource r;
	public Output(Resource r) {
		this.r = r;
	}
	public void run(){
		while(true){
			synchronized(r){
				System.out.println(r.name + ":" + r.sex);
			}
		}
	}
}

	
class Input implements Runnable {
	Resource r;
	Input(){}
	Input(Resource r){
		this.r = r;
	}
	
	public void run(){
		int x = 0;
		while(true){
			synchronized(r){
				if(x == 0){
					r.name = "mike";
					r.sex = "male";
				}else{
					r.name = "小丽";
					r.sex = "美女";
				}
			}
			x = (++x)%2;
		}
	}
}

 
class Resource {
	public String name;
	public String sex;
}

