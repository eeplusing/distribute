package com.lixuan.huawei.junior;
import java.util.Scanner;
public class DistributeApple {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		int apple = Integer.parseInt(str.split("\\s")[0]);
		int plate = Integer.parseInt(str.split("\\s")[1]);
		int result = solution(apple,plate);
		System.out.println(result);
	}
	 static int solution(int apple,int plate)
	{
		if(apple < 1 || plate < 1 || apple > 10 || plate > 10){
			return -1;
		}else{
			return cal(apple, plate);
		}
		
	}
	 
	 static int cal(int apple, int plate){
		 if(apple == 1 || apple == 0 || plate == 1){
				return 1;
		 }else if(apple < plate){//apple < plate与cal(apple, plate) = cal(apple, apple)
				return cal(apple,apple);
		 }else{
			 //apple>=plate考虑两种情况：
			 //	1.plate个盘子中每个都放苹果的情况 = cal(apple - plate, plate)即每个等于剩下apple-plate个苹果放入plate个盘子的情况
			 // 2.至少有一个盘子不放苹果的情况 = cal(apple, plate - 1)
				return cal(apple-plate,plate)+cal(apple, plate-1);
		 }
	 }

}
