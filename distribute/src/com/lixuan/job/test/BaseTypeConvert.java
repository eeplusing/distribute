package com.lixuan.job.test;

/************************************************************************************
 * @Title        : Test1.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年7月2日 下午7:07:14
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class BaseTypeConvert
{
	public static void main(String[] args)
	{
		/*
		 * (byte, short, char) int long float double 级别从低到高；
		 * 低级别与高级别共同参与运算，运算结果为高级别
		 * 从低到高可自动转换，从高到低使用强转；
		 * byte short char 属于同一级别，它们之间转换要强转。
		 * 
		 * */
		float f1 = 100.0f;
		double d1 = f1;
		int i1 = (int)f1;
		int i2 = (int)d1;
		int i3 = new Float(f1).intValue();
		int i4 = new Double(d1).intValue();
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		
		//8进制
		int i5 = 012;
		//16进制
		int i6 = 0x12;
		//二进制
		int i7 = 0b10000000000;
		System.out.println(i5);
		System.out.println(i6);
		System.out.println(i7);
		
		int a = 5;
		System.out.println("Value is " + ((a < 5) ? 10.9 : 9));
		
		char x = 'x';
		/*
		 * 形如：booleanValue ? T1 : T2
		 * 1.若T1(T2)为常量表达式，若T1(T2)能够用T2(T1)类型表示时，则结果为T2(T1)的类型,如System.out.println(false ? 10 : x);//结果为x
		 * 2.若T1 T2均不是常量表达式，则结果为T1 T2中的低级别向高级别转换后的值
		 * */
		System.out.println(false ? 97 : x);//结果为'x'
		System.out.println(false ? (int)97 : x);//结果为'x'
		System.out.println(true ? 97 : x);//结果为'a'
		System.out.println(true ? (int)97 : x);//结果为'a'
		//a不是常量表达式
		System.out.println(false ? a : x);//结果为120
		//Integer不能用char表示
		System.out.println(false ? Integer.valueOf(10) : x);//结果为120
				
	}
}
