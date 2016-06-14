package com.lixuan.huawei.junior;
import java.util.Scanner;
public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total  = sc.nextInt();
		sc.nextLine();
		String arr[] = sc.nextLine().split("\\s");
		int k = sc.nextInt();
		System.out.println(arr[arr.length - k - 1]);
		sc.close();
    }
}
