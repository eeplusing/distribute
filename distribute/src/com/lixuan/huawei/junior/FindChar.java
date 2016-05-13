package com.lixuan.huawei.junior;
import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
/************************************************************************************
 * @Title        : FindChar.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月10日 下午10:34:11
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class FindChar {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] pInputString = str.toCharArray();
		char pChar = FindChar1(pInputString);
		System.out.println(pChar);
	}
	
	static char FindChar1(char[] pInputString){
		for(int i = 0; i < pInputString.length; i++){
			boolean flag = true;
			for(int j = 0; j < pInputString.length; j++){
				if((pInputString[i] == pInputString[j]) && (i != j)){
					flag = false;
					break;
				}
			}
			if(flag){
				return pInputString[i];
			}
		}
		return '.';
	}
}
