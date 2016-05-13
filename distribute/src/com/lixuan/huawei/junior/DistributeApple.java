package com.lixuan.huawei.junior;

import java.util.Scanner;

/************************************************************************************
 * @Title        : distributeApple.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月8日 上午11:37:52
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class DistributeApple {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		int apple = Integer.parseInt(str.split("\\s")[0]);
		int plate = Integer.parseInt(str.split("\\s")[1]);
		int result = new DistributeApple().solution(apple,plate);
		System.out.println(result);
	}
	 int solution(int apple,int plate)
	{
		if(apple < 1 || plate < 1 || apple > 10 || plate > 10){
			return -1;
		}else{
			return cal(apple, plate);
		}
		
	}
	 
	 int cal(int apple, int plate){
		 if(apple == 1 || apple == 0 || plate == 1){
				return 1;
		 }else if(apple < plate){
				return cal(apple,apple);
		 }else{
				return cal(apple-plate,plate)+cal(apple,plate-1);
		 }
	 }

}
