package com.lixuan.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class SameCharMaxShowNum
{
	public static void main(String[] args)
	{
		String str = "JDKJhHKDJSJUUDHSDHkjfdjfHHDHSJjfjdfjHFd"
				+ "fjJKDJSkjdkjfkdjfkjaiewurvnJIJOJOllakjddqoafd";
		
		ArrayList<Character> lists = new ArrayList<Character>();
		TreeSet<Character> sets = new TreeSet<Character>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < str.length(); i++)
		{
			lists.add(str.charAt(i));
			sets.add(str.charAt(i));
		}
		Collections.sort(lists);
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < lists.size(); i++)
		{
			sb.append(lists.get(i));
		}
		ArrayList<String> maxList = new ArrayList<String>();
		int max = 0;
		String maxString = "";
		str = sb.toString();
		Iterator<Character> its = sets.iterator();
		while(its.hasNext())
		{
			String os = String.valueOf(its.next());
			int begin = str.indexOf(os);
			int end = str.lastIndexOf(os);
			int value = end - begin + 1;
			if(value > max)
			{
				max = value;
				maxString = os;
				maxList.add(os);
			}
			else if(value == max)
			{
				maxList.add(os);
			}
		}
		
		int index = 0;
		for(int i = 0; i < maxList.size(); i++)
		{
			if(maxList.get(i).equals(maxString))
			{
				index = i;
				break;
			}
		}
		System.out.println("max Data:");
		System.out.println("max Value:" + max);
		for(int i = index; i < maxList.size(); i++)
		{
			System.out.println(maxList.get(i) + " ");
		}
			
	}
}
