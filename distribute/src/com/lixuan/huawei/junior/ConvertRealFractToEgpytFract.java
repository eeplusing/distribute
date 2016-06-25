package com.lixuan.huawei.junior;

import java.util.Scanner;

public class ConvertRealFractToEgpytFract
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int a = Integer.parseInt(str.split("/")[0]);
		int b = Integer.parseInt(str.split("/")[1]);
		System.out.println(convertRealFractToEgpytFract(a, b));
	}
	
	public static String  convertRealFractToEgpytFract(int a, int b)
	{
		int c;
		StringBuffer sb = new StringBuffer();
		while(true)
		{
			if(b % a != 0)
				c = b / a + 1;
			else
			{
				c = b / a;
				a = 1;
			}
			
			if(a == 1)
			{
				sb.append("1/" + c);
				break;
			}
			else
			{
				sb.append("1/" + c + " + ");
			}
			
			a = a * c - b;
			b = b * c;
			if(a == 3)
			{
				sb.append("1/" + b/2 + " + 1/" + b);
				break;
			}
		}
		
		
		return sb.toString();
	}

}
