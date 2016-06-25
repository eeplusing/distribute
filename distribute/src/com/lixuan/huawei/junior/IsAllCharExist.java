package com.lixuan.huawei.junior;
import java.util.Scanner;
public class IsAllCharExist
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String shortStr = sc.nextLine();
		String longStr = sc.nextLine();
		if(isAllCharExist(shortStr, longStr))
			System.out.println("true");
		else
			System.out.println("false");
	}

	public static boolean isAllCharExist(String shortStr, String longStr)
	{
		search:
		for(int i = 0; i < shortStr.length(); i++)
		{
			boolean hasa = false;
			for(int j = 0; j < longStr.length(); j++)
			{
				if(shortStr.charAt(i) == longStr.charAt(j))
				{
					hasa = true;
					continue search;
				}
			}
			if(!hasa)
				return false;
		}
		return true;
	}
	
}
