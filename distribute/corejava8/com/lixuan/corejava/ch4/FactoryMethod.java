package com.lixuan.corejava.ch4;

import java.text.NumberFormat;

/************************************************************************************
 * @Title        : FactoryMethod.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月13日 上午9:21:07
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class FactoryMethod
{
	public static void main(String[] args)
	{
		//Returns a currency format(this is NumberFormat的subclass) for the current default FORMAT locale. 
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		NumberFormat percentFormatter = NumberFormat.getPercentInstance();
		double x = 0.1;
		System.out.println(currencyFormatter.format(x));
		System.out.println(percentFormatter.format(x));
	}
}
