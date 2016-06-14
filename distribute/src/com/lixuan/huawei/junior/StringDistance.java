package com.lixuan.huawei.junior;
import java.util.Scanner;
public class StringDistance{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		System.out.println(calculateStringDistance(str1, str2));
		sc.close();
	}
	
	public static  String  calculateStringDistance(String str1, String str2){
		int num = stringDistance(str1, 0, str1.length(), str2, 0, str2.length());
	    return "1/" + (num + 1);
	}
	
	public static int stringDistance(String strA, int pa, int lenA, String strB, int pb, int lenB){
		if(pa>=lenA){    // A串为空时
			if(pb>=lenB)
				return 0;
			else
				return lenB-pb;
		}
		if(pb>=lenB){    // B串为空时
			if(pa>=lenA)
				return 0;
			else
				return lenA-pa;
		}

		if(strA.charAt(pa) == strB.charAt(pb))
			return stringDistance(strA, pa+1, lenA, strB, pb+1, lenB);
		else{
			int t1= stringDistance(strA, pa+1, lenA, strB, pb, lenB);
			int t2= stringDistance(strA, pa+1, lenA, strB, pb+1, lenB);
			int t3= stringDistance(strA, pa, lenA, strB, pb+1, lenB);
			return Math.min(Math.min(t1,t2),t3)+1;
		}
	}
}