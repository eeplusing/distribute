package com.lixuan.huawei.junior;

public class Test {
	public static void main(String[] args) {
		double num = 1;
		for(int i = 1; i <= 10; i++){
			num += Math.pow(4, i);
		}
		System.out.println(num/1024);
		System.out.println(100 * Math.pow(10, 3)/(24*3600));
	}
}