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
public class TwentyFourHGame {

	/*
    * 先对四个数中的任意两个数进行四则运算，得到的结果加剩余的两个数还有三个数 
    * 再对三个数中的任意两个数进行四则运算，得到的结果加剩余的一个数还有二个数 
    * 再对剩余的两个数进行四则运算，得到的结果如果是24，就说明该表达式能得到24，表达式正确； 
    * 如果结果不是24，则说明表达式不正确 
    */
	public static void main(String[] args) throws ScriptException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int numArr[] = new int[4];
		for(int i = 0; i < 4; i++){
			numArr[i] = Integer.valueOf(str.split("\\s")[i]);
		}
		
		//返回值
		boolean res = false;
		//填数字
		int a, b, c, d;
		for(int i = 0; i < 4; i++){
			a = numArr[i];
			for(int j = 0; j < 4; j++){
				if(j != i){
					b = numArr[j];
					for(int k = 0; k < 4; k++){
						if(k != i && k != j){
							c = numArr[k];
							d = numArr[6 - i - j -k];
							if(calculate(a, b, c, d)){
								res = true;
							}
						}
					}
				}
			}
		}
		
		System.out.println(res);
	}

	/*填符号*/
	private static boolean calculate(int n1, int n2, int n3, int n4) throws ScriptException{
		String operator[] = {"+", "-","*","/"};
		ScriptEngineManager manager = new ScriptEngineManager();  
		ScriptEngine engine = manager.getEngineByName("js");
		for(int i = 0; i < 4; i++ ){
			for(int j = 0; j < 4; j++){
				for(int k = 0; k < 4; k++){
				     Object o = engine.eval(n1 + operator[i] + n2 + operator[j] + n3 + operator[k]+ n4);
				     if("24".equals(o.toString())){
				    	 return true;
				     }
				}
			}
		}
		
		return false;
	}

}
