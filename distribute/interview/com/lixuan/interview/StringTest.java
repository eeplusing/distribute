 
package com.lixuan.interview;  
public class StringTest {
	public static void main(String[] args){
		String a = "a1";
		String b = "a"+ 1;
		System.out.println(a==b);
		
		String a1 = "ab";
		String bb1 = "b";
		String b1 = "a"+ bb1; //编译器不能确定为常量
		System.out.println(a1==b1);
	}
}
  
