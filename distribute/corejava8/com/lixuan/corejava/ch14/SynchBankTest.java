package com.lixuan.corejava.ch14;

/************************************************************************************
 * @Title        : UnsynchBankTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月27日 上午10:10:47
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class SynchBankTest
{
	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;
	public static void main(String[] args)
	{
		Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
		for(int i = 0; i < NACCOUNTS; i++)
		{
			TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	}
}
