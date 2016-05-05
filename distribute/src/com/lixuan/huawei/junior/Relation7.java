package com.lixuan.huawei.junior;
import java.util.Scanner;
/************************************************************************************
 * @Title        : Relation7.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月5日 下午9:11:05
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
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
