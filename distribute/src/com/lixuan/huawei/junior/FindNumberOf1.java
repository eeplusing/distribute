package com.lixuan.huawei.junior;

import java.util.Scanner;
public class FindNumberOf1 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		System.out.println(findNumberOf1(num));
	}
	public static int findNumberOf1(int num){
		int result = 0;
		char[] binaryArr = Integer.toBinaryString(num).toCharArray();
        for(int i = 0; i < binaryArr.length; i++){
        	if(binaryArr[i] == '1')
        		result++;
        }
        return result;
    }
}


