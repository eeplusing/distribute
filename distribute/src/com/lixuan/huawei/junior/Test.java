package com.lixuan.huawei.junior;
public class Test {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i <= 6; i++){
			sum += Math.pow(4, i);
		}
		System.out.println((double)sum/1024);
	}
}