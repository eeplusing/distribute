 
package com.lixuan.interview; 
/**
 *题目：
 *输入一个整形数组，数组里有正数也有负数，数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
 *求所有子数组的和的最大值。要求时间复杂度为O(n)。
 *例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2，
 *因此输出为该子数组的和18。
 * 
 * 其实这道题只要一次遍历就可以求出最大的子数组和，而且是很简单的就解决了，具体想法是这样，不断的累加每个数组元素，
 * 并用一个变量保存当前的最大值，累加的过程(当前最大值大于零时累加，当前最大值不大于零时：不累加（若累加只会使当前值变小，）重新选择起点，将当前最大值赋值为索引对应的值；)一直和该变量进行比对，如果大于最大值，就把当前的最大值保存下来，反复如此就可以求出最大值.
 * 
 * */
public class MaxSubSum {
	public static void main(String[] args){
		int a[] = {-1,2,-3,-10,-4,-7,-2,-5};
		System.out.println(maxSum(a, a.length));
	}
	
	public static int maxSum(int a[], int n){
		int sum = 0;
		int currentMax = 0;
		int sIndex = 0;
		int eIndex = 0;
		for(int i = 0; i < n; i++){
			if(currentMax <= 0){
				currentMax = a[i];
				sIndex = i;
			}else{
				currentMax += a[i];
			}
			
			if(sum < currentMax){
				sum = currentMax;
				eIndex = i;
			}
		}
		System.out.println("index:" + sIndex + "---" + eIndex);
		return sum;
	}

}
  
