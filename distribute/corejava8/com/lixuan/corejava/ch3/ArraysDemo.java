package com.lixuan.corejava.ch3;
import java.util.Arrays;
/************************************************************************************
 * @Title        : ArraysDemo.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月1日 下午5:15:30
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ArraysDemo {
	public static void main(String[] args) {
		int[] arr = new int[]{45,232,456,56};
		
		//1.打印数组
		System.out.println(Arrays.toString(arr));//打印结果：[45, 232, 456, 56]
		System.out.println(Arrays.toString(arr));//打印结果：[45, 232, 456, 56]
		
		//2.拷贝数组
		int[] arrCopied = Arrays.copyOf(arr, arr.length);
		System.out.println(Arrays.toString(arrCopied));//打印结果：[45, 232, 456, 56]
		
		
		
	}

}
