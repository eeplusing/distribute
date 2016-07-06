package com.lixuan.huawei.junior;
import java.util.Scanner;
public class BaiQBaiJ {
	
	public static void main(String[] args) {
		new Scanner(System.in).nextInt();
		int i, j, k;
		for(i = 0; i <= 20; i++){
			for(j = 0; j <= 33; j++ ){
				k = 100 - i -j;
				if( k % 3 != 0){
					continue;
				}
				if(5 * i + 3 * j + k/3 == 100){
					System.out.println(i + " " + j + " " + k);
				}
			}
		}
	}
}
