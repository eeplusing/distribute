 
package com.lixuan.huawei.junior;

import java.util.*;

public class BuyLuobo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] arr = in.nextLine().split("\\s");
		int[] values = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
		{
			values[i] = Integer.valueOf(arr[i]);
		}
		Arrays.sort(values);
		int volum = 100;
		int sum = 0;
		for(int i = 0; i < values.length; i++)
		{
			if(volum < values[i])
				break;
			int temp = volum / values[i];
			sum += temp;
			volum -= temp * values[i];
		}
		System.out.println(sum);
		in.close();
	}
}
  
