 
package com.lixuan.youdao;

import java.util.Scanner;

public class Main2{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		String tempStr = "";
		int tempN = 0;
		int tempK = 0;
		for(int i = 0; i < T; i++){
			tempStr = sc.nextLine();
			tempN = Integer.parseInt(tempStr.split("\\s")[0]);
			tempK = Integer.parseInt(tempStr.split("\\s")[1]);
			String[] intArr = new String[2 * tempN];
			intArr = sc.nextLine().split("\\s");
			process(intArr, tempK);
		}
		sc.close();
	}
	public static void process(String[] intArr, int k){
		if(k < 1){
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < intArr.length; i++){
				sb.append(intArr[i] + " ");
			}
			System.out.println(sb.toString().substring(0, sb.toString().length() - 1));
			return;
			
		}else{
			String[] left = new String[intArr.length / 2];
			String[] right = new String[intArr.length / 2];
			String[] result = intArr;
			for(int i = 0; i < intArr.length / 2; i++){
				left[i] = intArr[i];
				right[i] = intArr[i + intArr.length / 2];
			}
			int index = intArr.length - 1;
			for(int i = left.length - 1; i >= 0; i--){
				result[index--] = right[i];
				result[index--] = left[i];
			}
			k--;
			process(result, k);
		}
	}
}
  
