package com.lixuan.huawei.junior;

import java.util.Arrays;
import java.util.Scanner;

/************************************************************************************
 * @Title        : MiniOut.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月4日 下午9:57:51
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class MiniOut {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		//n为人数
		int n=sc.nextInt();
		int[] height=new int[n];
		for (int i = 0; i < n; i++)
		{
			height[i]=sc.nextInt();
		}
		
		int[] temp = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			int[] a = new int[i];
			
			//第i个位置左边的身所有高
			for (int j = 0; j < i; j++)
			{
				a[j] = height[j];
			}
			
			int[] b=new int[height.length-i];
			
			//第i个位置右边的身高
			for (int k = i; k < height.length; k++)
			{
				b[k-i]=height[height.length-k+i-1];
			}
			
			temp[i]=handle(a)+handle(b);
		}
		
		Arrays.sort(temp);
		System.out.println(n-temp[n-1]);
		sc.close();
	}
	
	public static int handle(int[] num)
	{
		if (num.length==0)
		{
			return 0;
		}
		int[] curMax=new int[num.length];
		for (int i = 0; i < num.length; i++)
		{
			//记录从左到右至第i个元素升序最大子序列的长度
			curMax[i]=1;
			for (int j = 0; j < i; j++)
			{
				if (num[i]>num[j]&&curMax[i]<curMax[j]+1)
				{
					curMax[i]=curMax[j]+1;
				}
			}
		}
		Arrays.sort(curMax);
		return curMax[num.length-1];
	}

}
