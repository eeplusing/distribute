package com.lixuan.huawei.junior;

import java.util.Scanner;
import java.util.regex.Pattern;

/************************************************************************************
 * @Title        : LearnEnglish.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月7日 下午3:02:47
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class LearnEnglish1 {
	public static final String num0to9[] = {"zero", "one", "two", "three", "four", "five", 
		"six", "seven", "eight","nine"};
	
	public static final String num10to19[] = {"ten", "eleven", "twelve", "thirteen", 
		"fourteen", "fifteen", "sixteen", "seventeen", "eighteen","nineteen"};
	
	public static final String num10to90[] = {"ten", "twenty", "thirty", "forty", 
		"fifty", "sixty", "seventy", "eighty", "ninety"};
	
	public static final String hundred2tobillion[] = {"hundred", "thousand", "million", "billion"};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		if(!str.matches("^[1-9][0-9]{0,9}")){
			System.out.println("error");
			sc.close();
			return;
		}
			
		long longNum = Long.parseLong(str);
		int len = str.length();
		long num;
		int temp;
		String resStr = "";
		
		for(int i = len - 1; i >= 0; i--){
			num = (long)Math.pow(10, len - i);
			temp = (int) (longNum / num);
			
			
			
			
			longNum = longNum % num;
		}
		System.out.println(resStr);
	}
}
