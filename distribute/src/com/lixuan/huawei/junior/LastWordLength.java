package com.lixuan.huawei.junior;

import java.util.Scanner;

/************************************************************************************
 * @Title        : LastWordLength.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月4日 下午9:08:12
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class LastWordLength {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String stringWordList = s.nextLine();
		int length = stringWordList.length();
		if(length == 0){
			System.out.println(0);
			return;
		}
		
		int wordLength = 0;
		for(int i = length - 1; i >= 0; i-- ){
			if(stringWordList.charAt(i) == ' '){
				break;
			}
			wordLength++;
		}
		
		System.out.println(wordLength);
	} 
}
