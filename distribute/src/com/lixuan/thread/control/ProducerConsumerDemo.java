package com.lixuan.thread.control;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/************************************************************************************
 * @Title        : ProducerConsumer.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月14日 上午11:14:59
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
/**
 * 生产者消费者:
 * 
 * 多生产者多消费者问题
 * if判断标记，只有一次，会导致不该运行的线程运行了，出现数据错误的情况
 * while判断标记，解决了线程获取执行权后，是否运行
 * 
 * notify:智能唤醒一个线程，如果本方唤醒本方没有意义，而且while判断标记+notify会导致死锁；
 * notifyAll:解决了本方线程一定会唤醒对方线程的问题
 *
 * Lock接口：替代了同步代码块或同步函数，将同步的隐式锁操作替换为显式锁操作，同时给为灵活，可以在一个锁上加上多个Condition(监视器)，
 * 每个监视器上都有一组await(),signal(),signalAll(),相当于wait(),notify(),notifyAll();
 * 
 * 
 * 注意多线程判断标记使用while,这样可使线程每次醒来都做一次判断；
 * **/
class Resource3{
	private String name;
	private int count = 1;
	boolean flag = false;
	
	//创建锁
	Lock lock = new ReentrantLock();
	//通过已有的锁获取两组监视器
	Condition producer_con = lock.newCondition();
	Condition consumer_con = lock.newCondition();
	
	public void set(String name){
		lock.lock();
		try{
			while(flag){
				try {
					producer_con.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.name = name + count;
			count++;
			System.out.println(Thread.currentThread().getName() + "生产者+++++++++++" + this.name);
			flag = true;
			consumer_con.signal();
		}finally{
			lock.unlock();
		}
		
	}
	
	public  void out(){
		lock.lock();
		try{
			while(!flag){
				try{
					consumer_con.await();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "消费者----------" + this.name);
			flag = false;
			producer_con.signal();
		}finally{
			lock.unlock();
		}
		
	}
}

class Produecer implements Runnable{
	private Resource3 r;
	Produecer(Resource3 r){
		this.r = r;
	}
	
	public void run(){
		while(true){
			r.set("面包");
		}
	}
}


class Consumer implements Runnable{
	private Resource3 r;
	Consumer(Resource3 r){
		this.r = r;
	}
	
	
	public void run(){
		while(true){
			r.out();
		}
	}
}



class ProducerConsumerDemo{
	public static void main(String[] args){
		Resource3 r = new Resource3();
		Produecer p = new Produecer(r);
		Consumer s = new Consumer(r);
		
		Thread t0 = new Thread(p);
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(s);
		Thread t3 = new Thread(s);
		
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}
}