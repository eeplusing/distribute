package com.lixuan.corejava.ch13;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/************************************************************************************
 * @Title        : PriorityQueueTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月26日 上午10:36:16
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class PriorityQueueTest
{
	public static void main(String[] args)
	{
		PriorityQueue<GregorianCalendar> pq = new PriorityQueue<GregorianCalendar>();
		pq.add(new GregorianCalendar(1986, Calendar.DECEMBER, 9));
		pq.add(new GregorianCalendar(1915, Calendar.DECEMBER, 10));
		pq.add(new GregorianCalendar(1906, Calendar.DECEMBER, 13));
		pq.add(new GregorianCalendar(1910, Calendar.JUNE, 22));
		
		System.out.println("Iterating over elments...");
		for(GregorianCalendar gc:pq)
		{
			System.out.println(gc.get(Calendar.YEAR));
		}
		
		System.out.println("Removing elements");
		while(!pq.isEmpty())
		{
			System.out.println(pq.remove().get(Calendar.YEAR));
		}
			
		
		
		
	}
}
