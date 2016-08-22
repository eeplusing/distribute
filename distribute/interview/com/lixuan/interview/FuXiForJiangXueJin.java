 
package com.lixuan.interview;

import java.util.*;

public class FuXiForJiangXueJin {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            int r = in.nextInt();
            int avg = in.nextInt();
            int[] a= new int[n];//平时成绩
            int[] b= new int[n];//成本
            int cost = 0;
            for(int i = 0; i < n; i++){
            	a[i] = in.nextInt();
            	b[i] = in.nextInt();
            }
            //按成本升序排列
            for(int i = 0; i < b.length - 1; i++){
            	for(int j = i + 1; j < b.length; j++){
            		if(b[i] > b[j]){
            			int tempA = a[j];
            			int tempB = b[j];
            			a[j] = a[i];
            			a[i] = tempA;
            			b[j] = b[i];
            			b[i] = tempB;
            		}
            	}
            }
            int index = 0;//最先复习科目的索引
            while(!Conditon(a, avg) && index < n){
            	if(a[index] < r){
            		cost += b[index];
            		a[index]++;
            	}else{
            		index++;
            	}
            }
            
            System.out.println(cost);
        }
        in.close();
	}

	private static boolean Conditon(int[] a, int avg){
		int sum = 0;
		for(int i = 0; i < a.length; i++){
			sum += a[i];
		}
		return (double)sum/a.length >= avg;
	}

}
  
