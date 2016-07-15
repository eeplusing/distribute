 
package com.lixuan.huawei.junior;

import java.util.*;

public class JiGexian {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] arr = in.nextLine().split("\\s");
		for(int i = 60; i >= 0; i = i - 10)
		{
			int sum = 0;
			for(int j = 0; j < arr.length; j++){
				if(i <= Integer.parseInt(arr[j])){
					sum++;
				}
			}
			if((float)sum/arr.length >= 0.6){
				System.out.println(i);
				break;
			}
		}
	}

}
  
