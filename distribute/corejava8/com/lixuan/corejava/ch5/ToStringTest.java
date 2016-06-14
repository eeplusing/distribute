package com.lixuan.corejava.ch5;

import java.util.Arrays;

/************************************************************************************
 * @Title        : ToStringTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月13日 下午4:09:20
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ToStringTest
{

	public static void main(String[] args)
	{
		int arr[] = {23, 45, 3434,67};
		int arr1[][] = {{34, 56, 45}, {46, 32, 68}, {76, 34, 323}};
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.deepToString(arr1));

	}

}
