package com.lixuan.huawei.junior;
import java.util.Scanner;
public class YHTriangleBX {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(handle(sc.nextInt()));
		sc.close();
	}
	
	public static int handle(int n){
		int result = -1;
		int x, y, z;
		int matrix[][] = new int[n + 1][2 * n];
		matrix[1][n] = 1;
		for(int i = 2; i <= n; i++){
			for(int j = 1; j <= 2 * n - 1; j++){
				try{
					x = matrix[i - 1][j - 1];
				}catch(Exception e){
					x = 0;
				}
				try{
					y = matrix[i - 1][ j];
				}catch(Exception e){
					y = 0;
				}
				try{
					z = matrix[i - 1][ j + 1];
				}catch(Exception e){
					z = 0;
				}
				matrix[i][j] = x + y + z;
			}
		}
		
		for(int i = 2; i < 2 * n; i++){
			if(matrix[n][i] % 2 == 0){
				return i;
			}
		}
		return result;
	}

}
