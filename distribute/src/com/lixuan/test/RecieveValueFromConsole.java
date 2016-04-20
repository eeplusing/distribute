package com.lixuan.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/************************************************************************************
 * @Title        : RecieveValueFromConsole.java
 * @Todo         :<----功能描述---->
 * @Author       : Administrator
 * @DateTime     : 2016年4月20日 上午10:56:35
 * @Copyright    : 2016 LLC All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class RecieveValueFromConsole {

	public static void main(String[] args) throws IOException {
		//从控制台接收一个字符并打印
		//recieveChar();
		
		//从控制台接收一个字符串并打印
		recieveString();
		
		//从控制台接收多个值
		//recieveValue();
		
	}

	public static void recieveChar() throws IOException {
		System.out.println("输入一个字符");
		char varChar = (char)System.in.read();
		System.out.println(varChar);
		
	}

	public static void recieveString() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String varStr = null;
		System.out.println("输入一个字符串");
		varStr = br.readLine();
		System.out.println(varStr);
		
	}

	public static void recieveValue() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("输入姓名");
		String name = sc.nextLine();
		System.out.println("输入年龄");
		int age = sc.nextInt();
		System.out.println("输入工资");
		float salary = sc.nextFloat();
		System.out.println("姓名：" + name + ",年龄：" + age + ",工资:" + salary);
		
	}

}
