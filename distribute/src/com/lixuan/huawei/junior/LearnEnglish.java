package com.lixuan.huawei.junior;

import java.util.Scanner;

/************************************************************************************
 * @Title        : LearnEnglish.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月7日 下午3:02:47
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class LearnEnglish {
	private enum NumWords{
		hundred,
		million,
		billion,
		thousand,
		and
	}
	
	public static final String zeroToNine[] = {"", "one", "two", "three", "four", "five", "six", "seven", "eight","nine"};
	public static final String tenToNinety[] = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long num = sc.nextLong();
		if(num.toString().length() > 10){
			System.out.println("请输入位数小于10的整数");
			num = sc.nextLong();
		}
		sc.close();
		int numArr[] = new int[10];
		char charArr[] = num.toString().toCharArray();
		for(int i = 0; i < charArr.length; i++){
			numArr[9 - i] = Integer.valueOf(String.valueOf(charArr[charArr.length - 1 - i]));
		}
		
		String resStr = "";
		
		for(int j = 0; j < numArr.length; j++){
			if(numArr[j] != 0){
				switch(10 - j){
					case 10:
						resStr += zeroToNine[numArr[j]] + " " + NumWords.billion + " "; 
						break;
						
					case 9:
						if(numArr[j + 1] != 0 || numArr[j + 2] != 0){
							resStr += zeroToNine[numArr[j]] + " " + NumWords.hundred + " ";
						}else{
							resStr += zeroToNine[numArr[j]] + " " + NumWords.hundred + " " + NumWords.million + " ";
						}
						break;
						
					case 8:
						if(numArr[j + 1] != 0){
							resStr += tenToNinety[numArr[j]] + " ";
						}else{
							resStr += tenToNinety[numArr[j]] + " " + NumWords.million + " ";
						} 
						break;
						
					case 7:
						resStr += zeroToNine[numArr[j]] + " " + NumWords.million + " ";
						break;
					
					case 6:
						if(numArr[j + 1] != 0 || numArr[j + 2] != 0){
							resStr += zeroToNine[numArr[j]] + " " + NumWords.hundred + " ";
						}else{
							resStr += zeroToNine[numArr[j]] + " " + NumWords.hundred
									+ " " + NumWords.thousand + " ";
						}
						break;
					
					case 5:
						if(numArr[j + 1] != 0){
							resStr += tenToNinety[numArr[j]] + " ";
						}else{
							resStr += tenToNinety[numArr[j]] + " " + NumWords.thousand + " ";
						} 
						break;
					
					case 4:
						resStr += zeroToNine[numArr[j]] + " " + NumWords.thousand + " ";
						break;
						
					case 3:
						if(numArr[j + 1] != 0 || numArr[j + 2] != 0){
							resStr += zeroToNine[numArr[j]] + " "
									+ NumWords.hundred + " " + NumWords.and + " ";
						}else{
							resStr += zeroToNine[numArr[j]] + " " + NumWords.hundred + " ";
						}
						break;
					
					case 2:
						resStr += tenToNinety[numArr[j]] + " ";
						break;
					
					case 1:
						resStr += zeroToNine[numArr[j]];
				}
			}
		}
		System.out.println(resStr);
	}
}
