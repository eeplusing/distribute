package com.lixuan.huawei.junior;
import java.util.Scanner;
public class MaxGCRatio {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		char ch[] = sc.nextLine().toCharArray();
		int num = sc.nextInt();
		int temp = 0, result = 0;
		int index = 0;
		for(int i = 0; i <= ch.length - num; i++){
			temp = 0;
			for(int j = 0; j < num; j++){
				if(ch[i + j] == 'G' || ch[i + j] == 'C'){
					temp++;
				}
			}
			if(result < temp){
				result = temp;
				index = i;
			}
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < num; i++){
			sb.append(ch[index + i]);
		}
		System.out.println(sb);
	}
}
