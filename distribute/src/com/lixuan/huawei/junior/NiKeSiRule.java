package com.lixuan.huawei.junior;
import java.util.Scanner;
public class NiKeSiRule {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int startNum = num * num - num + 1;
		int sum = 0;
		StringBuffer sb = new StringBuffer();
		for(int i = startNum; i <= num * num * num; i= i + 2){
			sum = sum + i;
			sb.append(i + "+");
			if(sum == num * num * num)
				break;
		}
		
		System.out.println(sb.deleteCharAt(sb.length() - 1));
		
		
		
		
		
		sc.close();
	}
}
