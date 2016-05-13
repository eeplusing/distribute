package com.lixuan.thread.control;

/************************************************************************************
 * @Title        : ResourceDemo.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月13日 下午5:51:50
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
/****
 * 等待唤醒：
 * 涉及的方法：
 * 1.wait()：让线程处于冻结状态，被wait的线程会被存储到线程池中
 * 2.notify():唤醒线程池中的一个线程
 * 3.notifyAll():唤醒线程池中的所有线程
 * 
 * 这些方法必须用在同步块中，必须要明确按个锁上的线程
 * 
 ******/
class Resource2 
{
	private String name;
	private String sex;
	private boolean flag = false;
	public synchronized void set(String name, String sex)
	{
		if(flag)
		{
			try 
			{
				this.wait();
			}catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		this.name = name;
		this.sex = sex;
		flag = true;
		this.notify();
	}
	
	public synchronized void out()
	{
		if(!flag)
		{
			try 
			{
				this.wait();
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		System.out.println(name + ":" + sex);
		this.notify();
		flag = false;
	}
}

class ResourceDemo2
{
	public static void main(String[] args)
	{
		Resource2 r = new Resource2();
		Input2 in = new Input2(r);
		Output2 out = new Output2(r);
		
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		
		t1.start();
		t2.start();
	}
}

class Output2 implements Runnable 
{
	Resource2 r;
	public Output2(Resource2 r) 
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.out();
		}
	}
}

	
class Input2 implements Runnable 
{
	Resource2 r;
	Input2(Resource2 r)
	{
		this.r = r;
	}
	
	public void run()
	{
		int x = 0;
		while(true)
		{
			if(x == 0)
			{
				r.set("Mike", "male");
			}else
			{
				r.set("小丽", "美女");
			}
			x = (++x)%2;
		}
	}
}


