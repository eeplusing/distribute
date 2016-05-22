package com.lixuan.huawei.junior;
import java.util.Scanner;
public class MaxPrimerNumPair {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		System.out.println(maxPriNumPair(str, num));
		sc.close();
	}
	
	public static String maxPriNumPair(String str, int num){
		String[] arr = str.split("\\s");
		int[] numArr = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			numArr[i] = Integer.parseInt(arr[i]);
		}
		
		return String.valueOf(CalcNum(numArr, num));
	}
	
	 /*利用动态规划解题，dp[i]表示0-i最多有的伴侣数；

	当dp[i]+dp[j]为素数。dp[i]+dp[j] = dp[i-1]+dp[j-1]+1;由于伴侣数成对出现，必然只能在i-1和j-1的基础上出现一对。

	当dp[i]+dp[j]不为素数。dp[i]=dp[i-1]*/
	
	public static int CalcNum( int[] Input, int InputNum)
	{
		/* 代码在这里实现 */
		int cnt;
		int[] dp = new int[100];
		if((null == Input)||(InputNum < 1)||(InputNum%2 != 0)){
			return 0;
		}
		
		for(int i = InputNum - 2; i >= 0; i--){
	        for(int j = InputNum - 1; j > i; j--){
	            cnt = isPrime(Input[i] + Input[j]) ? (dp[i + 1] - dp[j - 1] + dp[j + 1] + 1):dp[i+1];  
				dp[i] = (cnt>dp[i]) ? cnt:dp[i];
	        }
	    }  
	    return dp[0]; 
	}

	public static boolean isPrime(int n){
		if(n<2){
			return false;
		}
		for(int i=2;i<=n/2;i++){
			if(0==n%i){
				return false;
			}
		}
		return true;
	}
}
