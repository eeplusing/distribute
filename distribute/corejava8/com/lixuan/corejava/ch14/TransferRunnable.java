package com.lixuan.corejava.ch14;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/************************************************************************************
 * @Title        : TransferRunnable.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月27日 上午10:23:46
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class TransferRunnable implements Runnable
{
	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY = 10;
	
	public TransferRunnable(Bank b, int from, double max)
	{
		bank = b;
		fromAccount = from;
		maxAmount = max;
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				int toAccount = (int)(bank.size() * Math.random());
				double amount = maxAmount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((int)(DELAY * Math.random()));
			}
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
