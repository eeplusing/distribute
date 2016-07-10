package com.lixuan.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayCombination
{
	public static void main(String[] args) throws Exception
	{
		String[] array = new String[]{"1", "2", "3", "4"};
		listAll(Arrays.asList(array), "");
	}
	public static void listAll(List<String> candidate, String prefix)
	{
		if(candidate.isEmpty())
		{
			System.out.println(prefix);
		}
		for(int i = 0; i < candidate.size(); i++)
		{
			List<String> temp = new LinkedList<String>(candidate);
			listAll(temp, prefix + temp.remove(i));
		}
	}
}
