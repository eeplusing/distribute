package com.lixuan.huawei.junior;
import java.util.Arrays;
import java.util.Scanner;
public class MinKNum {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String ruleNum = sc.nextLine();
		int uiInputNum = Integer.parseInt(ruleNum.split("\\s")[0]);
		int uiK = Integer.parseInt(ruleNum.split("\\s")[1]);
		String numString[] = sc.nextLine().split("\\s");
		int inputArr[] = new int[uiInputNum];
		for(int i = 0; i < uiInputNum; i++){
			inputArr[i] = Integer.parseInt(numString[i]);
		}
		Arrays.sort(inputArr);
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < uiK; i++){
			sb.append(inputArr[i] + " ");
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));
	}

}
