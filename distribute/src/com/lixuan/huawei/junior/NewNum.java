package com.lixuan.huawei.junior;
import java.util.Scanner;

public class NewNum {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		char[] numArr = String.valueOf(sc.nextInt()).toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i = numArr.length - 1; i >= 0; i--){
			if(sb.indexOf(String.valueOf(numArr[i])) == -1){
				sb.append(String.valueOf(numArr[i]));
			}
		}
		System.out.println(Integer.parseInt(sb.toString()));
	}
}
