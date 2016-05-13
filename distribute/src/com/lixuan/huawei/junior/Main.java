package com.lixuan.huawei.junior;
import java.util.Scanner;
/************************************************************************************
 * @Title        : Pascal.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月6日 下午5:37:03
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		sc.close();
		if(N < 0){
			return;
		}
        String arr[][]=new String[N][N];
        Main main = new Main(); 
        main.GetResult(N, arr);
        
    }
	
	void GetResult(int Num, String[][] arr){
		int temp = 1;
        for(int i = 0; i < Num; i++){
        	int row = i;
        	for(int j = 0; j <= i; j++){
        		arr[row][j] = String.valueOf(temp);
        		temp++;
        		row--;
        	}
        }
        
        
        for(int i=0;i<Num;i++)
        {
            for(int j=0;j<Num;j++)
            { 
                if(null !=(arr[i][j])){
                	System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
	}

}
