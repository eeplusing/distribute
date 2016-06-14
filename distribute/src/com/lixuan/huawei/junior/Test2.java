package com.lixuan.huawei.junior;

public class Test2  
{  
	public static void main(String[] args) {
		int[][] pResult = new int[5][5];
		int start = 1;
		int temp;
		for(int i = 0; i < 5 ; i++){
			temp = i;
			for(int j = 0; j <= i; ){
				pResult[temp--][j++] = start++;
			}
		}
		printResult(5, pResult);
        
	}
	
	public static void printResult(int num, int pResult[][]){
		for(int i = 0; i < num; i++){
			for(int j = 0; j < num - i; j++){
				System.out.print(j == num - 1 - i ? pResult[i][j] + "\r" : pResult[i][j] + " ");
			}
		}
	}
	
	
}  