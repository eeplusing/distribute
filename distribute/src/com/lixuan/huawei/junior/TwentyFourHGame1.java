package com.lixuan.huawei.junior;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/************************************************************************************
 * @Title        : TwentyFourHGame.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年5月7日 下午5:41:10
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class TwentyFourHGame1 {

	/*
    * 先对四个数中的任意两个数进行四则运算，得到的结果加剩余的两个数还有三个数 
    * 再对三个数中的任意两个数进行四则运算，得到的结果加剩余的一个数还有二个数 
    * 再对剩余的两个数进行四则运算，得到的结果如果是24，就说明该表达式能得到24，表达式正确； 
    * 如果结果不是24，则说明表达式不正确 
    */
	public static void main(String[] args) throws ScriptException {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int numArr[] = new int[4];
		for(int i = 0; i < 4; i++){
			numArr[i] = Integer.valueOf(str.split("\\s")[i]);
		}
		
		System.out.println(cal(numArr[0],numArr[1],numArr[2],numArr[3]));
		
	}
	
	public static boolean cal(int ...numArr){
		int length = numArr.length;
		if(length == 2){
			int a=numArr[0];
			int b=numArr[1];
			return  a+b== 24||a-b==24||b-a==24||a*b==24||a/b==24||b/a==24;
		}else{
			for(int i = 0; i < length - 1; i++){
				for(int j = i + 1; j < length; j++){
					int a = numArr[i];
					int b = numArr[j];
					if(length==4){
						int c=0;
						int d=0;
					for(int k=0;k<length;k++){
						if(k==i||k==j)continue;
						if(c==0)c=numArr[k];
						
						d=numArr[k];
					}
						return cal(a+b,c,d)||cal(a*b,c,d)||cal(a-b,c,d)||cal(b-a,c,d)||cal(a/b,c,d)||cal(b/a,c,d);
					}
					else{
						int c=0;
						for(int k=0;k<length;k++){
							if(k==i||k==j)continue;
							if(c==0)c=numArr[k];
							
						}
						return cal(a+b,c)||cal(a*b,c)||cal(a-b,c)||cal(b-a,c)||cal(a/b,c)||cal(b/a,c);
					}
				}
			}
		}
		
		
		return false;
	}


}
