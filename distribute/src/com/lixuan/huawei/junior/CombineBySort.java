package com.lixuan.huawei.junior;
import java.util.Scanner;
import java.util.TreeSet;
public class CombineBySort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inNum1 = sc.nextInt();
		sc.nextLine();
		String inArr1 = sc.nextLine();
		int inNum2 = sc.nextInt();
		sc.nextLine();
		String inArr2 = sc.nextLine();
		
		String[] strArr1 = inArr1.split("\\s");
		TreeSet<String> set = new TreeSet<String>(); 
		for(int i = 0; i < inNum1; i++){
			set.add(strArr1[i]);
		}
		String[] strArr2 = inArr2.split("\\s");
		for(int i = 0; i < inNum2; i++){
			set.add(strArr2[i]);
		}
		StringBuffer sb = new StringBuffer();
		for(String n:set){
			System.out.print(n);
		}
		System.out.println();
		sc.close();
	}
}
