package com.lixuan.huawei.junior;

import java.util.Scanner;

/************************************************************************************
 * @Title        : FindNumberOf1.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月10日 下午10:18:01
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class FindNumberOf1 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		int result = findNumberOf1(num);
		System.out.println(result);
		
	}
	
	public static int findNumberOf1(int num)
    {
		int result = 0;
		char[] binaryArr = Integer.toBinaryString(num).toCharArray();
        for(int i = 0; i < binaryArr.length; i++){
        	if(binaryArr[i] == '1')
        		result++;
        }
        return result;
    }
}


