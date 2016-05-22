package com.lixuan.huawei.junior;
import java.util.Scanner;
public class LearnEnglish {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long num = sc.nextLong();
		if(!num.toString().matches("^[1-9][0-9]{0,9}")){
			System.out.println("error");
			sc.close();
			return;
		}
		sc.close();
		System.out.println(parse(num));
	}
	
	private enum NumWords{
		hundred,
		million,
		billion,
		thousand,
		and
	};

	public static String parse(long num){
		String num0to9[] = {"zero", "one", "two", "three", "four", "five", 
			"six", "seven", "eight","nine"};
		
		String num10to19[] = {"ten", "eleven", "twelve", "thirteen", 
			"fourteen", "fifteen", "sixteen", "seventeen", "eighteen","nineteen"};
		
		//public static final String hundred2tobillion[] = {"hundred", "thousand", "million", "billion"};
		
		
		String zeroToNine[] = {"", "one", "two", "three", "four", "five", "six", "seven", "eight","nine"};
		String tenToNinety[] = {"", "ten", "twenty", "thirty", "forty", 
											"fifty", "sixty", "seventy", "eighty", "ninety"};
		
		int numArr[] = new int[10];
		char charArr[] = String.valueOf(num).toCharArray();
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
						resStr += zeroToNine[numArr[j]] + " " + NumWords.hundred + " ";
						if(numArr[j + 1] == 0 && numArr[j + 2] == 0){
							resStr += NumWords.million + " ";
						}else{
							resStr += NumWords.and + " ";
						}
						break;
					case 8:
						if(numArr[j + 1] == 0){
							resStr += tenToNinety[numArr[j]] + " " + NumWords.million + " ";
						}else{
							if(numArr[j] == 1){
								resStr += num10to19[numArr[j + 1]] + " ";
							}else{
								resStr += tenToNinety[numArr[j]] + " ";
							}
						} 
						break;
						
					case 7:
						if(numArr[j - 1] != 1){
							resStr += zeroToNine[numArr[j]] + " ";
						}
						resStr += NumWords.million + " "; 
						break;
					
					case 6:
						resStr += zeroToNine[numArr[j]] + " " + NumWords.hundred + " ";
						if(numArr[j + 1] == 0 && numArr[j + 2] == 0){
							resStr += NumWords.thousand + " ";
						}else{
							resStr += NumWords.and + " ";
						}
						break;
					
					case 5:
						if(numArr[j + 1] == 0){
							resStr += tenToNinety[numArr[j]] + " " + NumWords.thousand + " ";
						}else{
							if(numArr[j] == 1){
								resStr += num10to19[numArr[j + 1]] + " ";
							}else{
								resStr += tenToNinety[numArr[j]] + " ";
							}
						} 
						break;
					
					case 4:
						if(numArr[j - 1] != 1){
							resStr += zeroToNine[numArr[j]] + " ";
						}
						resStr += NumWords.thousand + " "; 
						break;
						
					case 3:
						resStr += zeroToNine[numArr[j]] + " " + NumWords.hundred + " ";
						if(numArr[j + 1] != 0 || numArr[j + 2] != 0){
							resStr += NumWords.and + " ";
						}
						break;
					
					case 2:
						if(numArr[j + 1] == 0){
							resStr += tenToNinety[numArr[j]] + " ";
						}else{
							if(numArr[j] == 1){
								resStr += num10to19[numArr[j + 1]] + " ";
							}else{
								resStr += tenToNinety[numArr[j]] + " ";
							}
						} 
						break;
					
					case 1:
						if(numArr[j - 1] != 1){
							resStr += zeroToNine[numArr[j]] + " ";
						}
						break;
				}
			}
		}
		return resStr;
	}
}
