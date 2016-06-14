package com.lixuan.huawei.junior;
import java.util.Scanner;
public class RabitCount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int monthCount = sc.nextInt();
		System.out.println(getTotalCount(monthCount));
		sc.close();
	}
	
	 public static int getTotalCount(int monthCount){
		 if(monthCount == 1 || monthCount == 2){
			 return 1;
		 }else{
			 return getTotalCount(monthCount - 1) + getTotalCount(monthCount - 2);
		 }
	 }
}
