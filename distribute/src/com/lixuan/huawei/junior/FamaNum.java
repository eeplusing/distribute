package com.lixuan.huawei.junior;

import java.util.Scanner;

/************************************************************************************
 * @Title        : FamaNum.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月7日 下午1:39:12
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class FamaNum {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int weight[] = new int[n];
		int nums[] = new int[n];
 		for(int i = 0; i < n; i++){
			weight[i] = sc.nextInt();
		}
 		for(int i = 0; i < n; i++){
 			nums[i] = sc.nextInt();
 		}
 		sc.close();
 		System.out.println(fama(n, weight, nums));
	}

	public static int fama(int n, int[] weight, int[] nums){
		int result = 0;
		
		
		
		
		
		
		
		
		return result;
		
		
	}
}
