package com.lixuan.corejava.ch13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/************************************************************************************
 * @Title        : SetTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月25日 下午9:27:18
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class SetTest
{
	public static void main(String[] args)
	{
		Set<String> words = new HashSet<String>();
		long totalTime = 0;
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext())
		{
			String word = in.next();
			if(word.equals("exit"))
				break;
			long callTime = System.currentTimeMillis();
			words.add(word);
			callTime = System.currentTimeMillis() - callTime;
			totalTime += callTime;
		}
		
		Iterator<String> iter = words.iterator();
		for(int i = 1; i < 20; i++)
		{
			if(!iter.hasNext())
				break;
			System.out.println(iter.next());
		}
		System.out.println("....");
		System.out.println(words.size() + "distinct  words" + totalTime + "millisecond.");
		
		
		
		
		
	}
}
