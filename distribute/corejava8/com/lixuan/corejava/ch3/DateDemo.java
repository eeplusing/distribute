package com.lixuan.corejava.ch3;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/************************************************************************************
 * @Title        : DateDemo.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月12日 上午10:50:57
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class DateDemo
{
	public static void main(String[] args){
		Locale.setDefault(Locale.CHINA);
		Date date = new Date();
		System.out.println(date.toString());
		
		GregorianCalendar gc1 = new GregorianCalendar(2016, 12, 23);
		GregorianCalendar gc2 = new GregorianCalendar(2016, Calendar.DECEMBER,23);
		GregorianCalendar gc3 = new GregorianCalendar(2016, Calendar.NOVEMBER,23, 23, 59, 59);
		System.out.println(gc1.toString());
		System.out.println(gc2.toString());
		System.out.println(gc3.toString());
		
		GregorianCalendar gc4 = new GregorianCalendar();
		int month = gc4.get(Calendar.MONTH);
		System.out.println(month);
	}
}
