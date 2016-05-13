package com.lixuan.huawei.junior;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class MergeArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arrNum1 = sc.nextInt();
		sc.nextLine();
		String arr1[] = sc.nextLine().split("\\s");
		int arrNum2 = sc.nextInt();
		sc.nextLine();
		String arr2[] = sc.nextLine().split("\\s");
		sc.close();
		List<String> arraylist = new ArrayList<String>();
		for(int i = 0; i < arr1.length; i++){
			if(!arraylist.contains(arr1[i]))
			arraylist.add(arr1[i]);
		}
		for(int i = 0; i < arr2.length; i++){
			if(!arraylist.contains(arr2[i]))
				arraylist.add(arr2[i]);
		}
		int intArr[] = new int[arraylist.size()];
		for(int i = 0; i < arraylist.size(); i++){
			intArr[i] =  Integer.parseInt(arraylist.get(i)); 
		}
		
		Arrays.sort(intArr);
		for(int i = 0; i < intArr.length; i++){
			System.out.println(intArr[i]);
		}

	}

}
