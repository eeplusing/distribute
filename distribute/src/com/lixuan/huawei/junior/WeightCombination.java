package com.lixuan.huawei.junior;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/************************************************************************************
 * @Title        : FamaNum.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月7日 下午1:39:12
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
//用一维数组记录每种砝码选择的个数slected[i],
	//当前次：一种砝码组合的重量weigth[i] * selected[i],
public class WeightCombination {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//砝码种类数
		int classNumCpp = sc.nextInt();
		
		int weightCpp[] = new int[classNumCpp];
		int numsCpp[] = new int[classNumCpp];
 		for(int i = 0; i < classNumCpp; i++){
 			weightCpp[i] = sc.nextInt();
		}
 		for(int i = 0; i < classNumCpp; i++){
 			numsCpp[i] = sc.nextInt();
 		}
 		sc.close();
 		
 		int result = fama(classNumCpp, weightCpp, numsCpp);
 		System.out.println(result);
 		
	}

	public static int fama(int classNumCpp, int[] weightCpp, int[] numsCpp){
		//记录能组合成的重量
		Set<Integer> listNum = new HashSet<Integer>();
		//每种砝码选择的数目
		int selectedNumCpp[] = new int[classNumCpp];
				
		new WeightCombination().handleFama(0, classNumCpp, listNum, selectedNumCpp, weightCpp, numsCpp);
		return listNum.size();
	}
	
	public void handleFama(int l, int classNumCpp, Set<Integer> listNum, int[] selectedNumCpp, int[] weightCpp, int[] numsCpp)
	{
	    int i, j;
	    if(l == classNumCpp) // 得到一个组合情况
	    {
	        int sumWeight = 0;
	        for(i=0; i<classNumCpp; i++)
	        {
	        	sumWeight += weightCpp[i] * selectedNumCpp[i];
	        }
			listNum.add(sumWeight);
	    }
	    else
	    {
	        for(j = 0; j <= numsCpp[l]; j++)
	        {
	        	selectedNumCpp[l] = j; // 第l种砝码取 j 个
	        	handleFama(l+1, classNumCpp, listNum, selectedNumCpp, weightCpp, numsCpp);// 考虑下一种砝码
	        }
	    }
	}
}


