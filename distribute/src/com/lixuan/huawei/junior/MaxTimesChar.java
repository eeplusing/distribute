 
package com.lixuan.huawei.junior;

import java.util.*;

public class MaxTimesChar {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		char[] chs = str.toCharArray();
		int[] times = new int[200];
		for(int i = 0; i < chs.length; i++)
		{
			int temp = chs[i];
			times[temp]++; 
		}
		//Arrays.sort(times);
		int bigIndex = 0;
		for(int i = 1; i < times.length; i++)
		{
			if(times[bigIndex] < times[i])
			{
				bigIndex = i;
			}
		}
		System.out.println((char)bigIndex);
	}

}
  
