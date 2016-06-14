package com.lixuan.huawei.junior;
import java.util.Scanner;
public class MaxNumLength {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		if(str.equals("")){
			System.out.println(0);
			sc.close();
			return;
		}
		boolean flag = false;
		int start = 0, end = 0; 
		for(int i = 0; i < str.length(); i++){
			if((int)str.charAt(i) >= '0' && (int)str.charAt(i) <= '9'){
				flag = true;
			}
		}
		if(!flag){
			System.out.println(0);
			sc.close();
			return;
		}
		for(int i = 0; i < str.length(); i++){
			if((int)str.charAt(i) >= '0' && (int)str.charAt(i) <= '9'){
				for(int j = i + 1; j < str.length(); j++){
					if((int)str.charAt(j) < '0' || (int)str.charAt(j) > '9'){
						break;
					}
					if(j - i > end - start){
						start = i;
						end = j;
					}
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		for(int i = start; i <= end; i++){
			sb.append(str.charAt(i));
		}
		sb.append("," + (end - start + 1));
		System.out.println(sb);
		sc.close();
	}
}