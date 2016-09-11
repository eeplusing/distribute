package com.lixuan.zte;

/************************************************************************************
 * @Title        : Test.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月12日 下午7:42:39
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class ChaJi
{
	public static void main(String[] args){
		int[] arr1 = {4,3,5,6};
		int[] arr2 = {3,2,1,6,3,9,8,13};
/*		int[] arr1 = {1,2,3,4};
		int[] arr2 = {4,5,6,7};
*/		int result = process(arr1, arr2);
		System.out.println(result);
	}
	private static int process(int[] arr1, int[] arr2) {
		int result = 0;
		for(int i = 0; i < arr1.length; i++){
			boolean flag = true;
			for(int j = 0; j < arr2.length; j++){
				if(arr1[i] == arr2[j]){
					flag = false;
					break;
				}
			}
			if(flag){
				result++;
			}
		}
		for(int i = 0; i < arr2.length; i++){
			boolean flag = true;
			for(int j = 0; j < arr1.length; j++){
				if(arr2[i] == arr1[j]){
					flag = false;
					break;
				}
			}
			if(flag){
				result++;
			}
		}
		return result;
	}
}
