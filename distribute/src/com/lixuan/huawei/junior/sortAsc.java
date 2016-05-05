package com.lixuan.huawei.junior;

import java.util.Arrays;
import java.util.Scanner;

/************************************************************************************
 * @Title        : sortAsc.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月5日 下午1:01:58
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class sortAsc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char chrStr[] = str.toCharArray();
		Arrays.sort(chrStr);
		System.out.println(chrStr);

	}

}
