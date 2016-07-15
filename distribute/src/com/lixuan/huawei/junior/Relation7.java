package com.lixuan.huawei.junior;
import java.util.Scanner;
public class Relation7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for(int i = 7; i <= n; i++){
			if((i % 7 == 0) || String.valueOf(i).contains("7")){
				sum++;
			}
		}
		System.out.println(sum);
	}
}
