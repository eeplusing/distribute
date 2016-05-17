package com.lixuan.huawei.junior;

import java.util.ArrayList;
import java.util.List;
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
	//砝码的总数
	public static int classNum;
	//记录每种砝码使用的数量
	public static int perClassNum[];
	//总共不同的数目
	public static int resolutionNum;
	static List<Integer> listNum = new ArrayList<Integer>();
	static int weight[];
	static int nums[];
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		classNum = sc.nextInt();
		perClassNum = new int[classNum];
		weight = new int[classNum];
		nums = new int[classNum];
 		for(int i = 0; i < classNum; i++){
			weight[i] = sc.nextInt();
		}
 		for(int i = 0; i < classNum; i++){
 			nums[i] = sc.nextInt();
 		}
 		sc.close();
 		System.out.println(fama1(classNum, weight, nums));
	}

	public static int fama1(int n, int[] weight, int[] nums){
		/*int resolutionNum = 0;
		int sumWeight = 0;

		//List<Integer> listNum = new ArrayList<Integer>();
		for(int i = 0; i < weight.length; i++){
			for(int j = 0; j < nums[i]; j++){
				sumWeight += weight[i];
				if(!listNum.contains(sumWeight)){
					listNum.add(sumWeight);
				}
			}
		}
		
		resolutionNum = listNum.size();
		
		return resolutionNum;*/
		
		fama(0);
		return resolutionNum;
	}
	
	//用一维数组记录每种砝码选择的个数slected[i],
	//当前次：一种砝码组合的重量weigth[i] * selected[i],
	
	
	
	
	public static void fama(int l)
	{
	    int i, j;
	    if(l == classNum) // 得到一个组合情况
	    {
	        int sumWeight = 0;
	        for(i=0; i<classNum; i++)
	        {
	        	sumWeight += weight[i] * perClassNum[i];
	        }
	        if(!listNum.contains(sumWeight)){
				listNum.add(sumWeight);
				resolutionNum++;
			}
	    }
	    else
	    {
	        for(j = 0; j <= nums[l]; j++)
	        {
	        	perClassNum[l] = j; // 第l种砝码取 j 个
	        	fama(l+1);     // 考虑下一种砝码
	        }
	    }
	}
}


