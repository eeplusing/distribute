package com.lixuan.corejava.ch5;

import java.util.Scanner;

/************************************************************************************
 * @Title        : EnumTest.java
 * @Todo         :<----describe---->
 * @Author       : Administrator
 * @DateTime     : 2016年6月13日 下午5:30:18
 * @Copyright    : 2016 CPP All Rights Reserved
 * @version      : V1.0
 ************************************************************************************/
public class EnumTest
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a size:(SMALL, MEDIUM, LARGE, EXTRAL_LARGE)");
		String input = in.next().toUpperCase();
		Size size = Enum.valueOf(Size.class, input);
		System.out.println("size:" + size);
		System.out.println("abbreviation:" + size.getAbbreviation());
		if(size == size.EXTRAL_LARGE)
		{
			System.out.println("good");
		}
	}

}

enum Size
{
	SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRAL_LARGE("XL");
	
	private Size(String abbreviation)
	{
		this.abbreviation = abbreviation;
	}
	
	public String getAbbreviation()
	{
		return abbreviation;
	}
	
	private String abbreviation;
}





