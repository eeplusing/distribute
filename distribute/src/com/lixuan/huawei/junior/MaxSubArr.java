package com.lixuan.huawei.junior;

import java.util.Arrays;
import java.util.Scanner;
/************************************************************************************
 * @Title        : MaxSubArr.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月5日 上午9:30:51
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class MaxSubArr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//总人数
		int n = sc.nextInt();
		
		//记录身高
		int[] height = new int[n];
		for(int i = 0; i < n; i++){
			height[i] = sc.nextInt();
		}
		
		//记录每个位置上的最大子序列长度
		int[] temp = new int[n];
		
		for(int i = 0; i < n; i++){
			//i位置左边的身高记在left中
			int[] left = new int[i];
			for(int j = 0; j < i; j++){
				left[j] = height[j];
			}
			
			//i位置右边（包含i）的身高记在right中
			int[] right = new int[n - i];
			for(int k = i; k < n; k++){
				right[k - i] = height[n - 1 + i - k];      
			}
			
			temp[i] = handle(left) + handle(right);
		}
		
		Arrays.sort(temp);
		System.out.println(n - temp[n - 1]);
		
	}

	/**
	* <p>Title: handle</p>
	* <p>Description:求一个数组的最大有序子序列的元素个数,原数组不能更改位置从左至右升序 </p>
	* @param arr
	* @return
	 */
	public static int handle(int[] arr){
		int length = arr.length;
		if(length  == 0){
			return 0;
		}
		
		//记录当前位置i处的最大子序列长度
		int[] curMax = new int[length];
		
		for(int i = 0; i < length; i++){
			curMax[i] = 1;
			for(int j = 0; j < i; j++){
				if(arr[i] > arr[j] && curMax[i] < curMax[j] + 1){
					curMax[i] = curMax[j] + 1;
				}
			}
		}
		//升序排列
		Arrays.sort(curMax);
		return curMax[length - 1];
	}
}
