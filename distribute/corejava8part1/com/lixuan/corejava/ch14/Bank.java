package com.lixuan.corejava.ch14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/************************************************************************************
 * @Title        : Bank.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月27日 上午10:11:12
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Bank
{
	private final double[] accounts;
	//重入锁实现Lock接口
	private Lock bankLock = new ReentrantLock();
	private Condition sufficientFunds;
	
	public Bank(int n, double initialBalance)
	{
		accounts = new double[n];
		for(int i = 0; i < accounts.length; i++)
		{
			accounts[i] = initialBalance;
		}
		sufficientFunds = bankLock.newCondition();
	}
	/***
	 *同步方法
	 */
	/*public synchronized void transfer(int from, int to, double amount)
	{
		while(accounts[from] < amount)
			wait();
		System.out.println(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf("%10.2f from %d to %d",amount, from, to);
		accounts[to] += amount;
		System.out.printf("Total Balance:%10.2f%n", getTotalBalance());
		notifyAll();
	}*/
	
	
	/**
	 * 锁对象
	 * @throws InterruptedException 
	 */
	public void transfer(int from, int to, double amount) throws InterruptedException
	{
		bankLock.lock();
		try
		{
			while(accounts[from] < amount)
				sufficientFunds.await();
			System.out.println(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf("%10.2f from %d to %d",amount, from, to);
			accounts[to] += amount;
			System.out.printf("Total Balance:%10.2f%n", getTotalBalance());
			sufficientFunds.signalAll();
		} 
		finally
		{
			bankLock.unlock();
		}
	}
	

	public double getTotalBalance()
	{
		double sum = 0;
		for(double am:accounts)
		{
			sum += am;
		}
		return sum;
	}
	
	public int size()
	{
		return accounts.length;
	}
	
	
	
}
