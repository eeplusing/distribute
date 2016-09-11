package com.lixuan.zte;

import java.util.ArrayList;
import java.util.*;

/************************************************************************************
 * @Title        : PageHuanCun.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月12日 下午7:42:39
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class PageHuanCun
{
	public static void main(String[] args){
		int[] arr1 = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0};
		int size = 3;
		System.out.println(process(size,arr1));
	}
	
	public static  int process(int size,int[] arr){
		List<Integer> list = new ArrayList<Integer>();
		int count = 0;
		for(int i = 0; i < arr.length; i++){
			if(list.contains(arr[i])){
				continue;
			}else{
				if(list.size() == size){
					list.remove(list.get(0));
				}
				list.add(arr[i]);
				count++;
			}
		}
		return count;
	}
}
