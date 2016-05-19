package com.lixuan.huawei.junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddLongInteger {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
		String addend = br.readLine();
		String augend = br.readLine();
		System.out.println(addLongInteger(addend, augend));
		br.close();
	}
	
	public static String addLongInteger(String addend, String augend)
	 {
		char addendCharArr[] = addend.toCharArray();
		char augendCharArr[] = augend.toCharArray();
		char minNum[];
		char maxNum[];
		int maxLength;
		int minLength;
		if(addendCharArr.length >= augendCharArr.length){
			maxNum = addendCharArr;
			minNum = augendCharArr;
		}else{
			maxNum = augendCharArr;
			minNum = addendCharArr;
		}
		maxLength = maxNum.length;
		minLength = minNum.length;
		int temp1 = 0, temp2 = 0;
		int sum[] = new int[maxLength + 1];
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < maxLength; i++){
			if(minLength - i > 0){
				temp1 = Integer.parseInt(String.valueOf(minNum[minLength - 1 - i]));
			}else{
				temp1 = 0;
			}
			temp2 = Integer.parseInt(String.valueOf(maxNum[maxLength - 1 - i]));
			if((sum[i] + temp1 + temp2) > 9){
				sum[i] = (sum[i] + temp1 + temp2) % 10;
				sum[i + 1] = sum[i + 1] + 1;
			}else{
				sum[i] = sum[i] + temp1 + temp2;
			}
			sb.append(sum[i]); 
		}
		if(sum[maxLength] != 0){
			sb.append(sum[maxLength]);
		}
		return sb.reverse().toString();     
	 }
}
