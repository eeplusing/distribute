package com.lixuan.corejava.ch13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/************************************************************************************
 * @Title        : ShuffleTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月26日 下午4:19:44
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ShuffleTest
{
	public static void main(String[] args)
	{
		List<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0; i < 50; i++)
		{
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		List<Integer> winningCombinition = numbers.subList(0, 6);
		Collections.sort(winningCombinition);
		System.out.println(winningCombinition);
	}

}
