package com.lixuan.huawei.junior;
import java.util.Scanner;
import java.util.regex.Pattern;
public class CheckKeys {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String key = "";
		Check check = new Check();
		while(sc.hasNext()){
			key = sc.nextLine();
			if(check.check(key)){
				System.out.println("OK");
			}else{
				System.out.println("NG");
			}
		}
		sc.close();
	}
}

class Check{
	 public boolean check(String arr){
		 if(arr.length() < 9){
			return false;
		 }
		 
		 int formatNum = 0;
		 boolean b = Pattern.compile("[0-9]").matcher(arr).find();
		 boolean b1 = Pattern.compile("[a-z]").matcher(arr).find();
		 boolean b2 = Pattern.compile("[A-Z]").matcher(arr).find();
		 boolean b3 = Pattern.compile("[\\W]").matcher(arr).find();
		 if(b)
			 formatNum++;
		 if(b1)
			 formatNum++;
		 if(b2)
			 formatNum++;
		 if(b3)
			 formatNum++;
		 if(formatNum < 3){
			 return false;
		 }
		
		 String reg, left, right;
		 int len = arr.length();
		 for(int i = 0; i < len - 2; i++){
			 left = arr.substring(0, i);
			 reg = arr.substring(i, i + 3);
			 right = arr.substring(i + 3);
			 if(left.contains(reg) || right.contains(reg)){
				 return false;
			 }
		  }
		 
		  return true;
	}

}
