package com.lixuan.huawei.junior;
import java.util.Scanner;
public class CommonStrLength
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String[] strArr = sc.nextLine().split("\\s");
		System.out.println(getCommonStrLength(strArr[0], strArr[1]));
	}

	public static int getCommonStrLength(String firstStr, String secondStr)
	{
		firstStr = firstStr.toLowerCase();
		secondStr = secondStr.toLowerCase();
		String subStr = "";
		int result = 0;
		for(int i = 0; i < firstStr.length(); i++)
		{
			for(int j = firstStr.length(); j > i; j--)
			{
				subStr = firstStr.substring(i, j); 
				if(secondStr.contains(subStr))
				{
					result = result < j - i ? j - i : result; 
				}
			}
		}
		return result;
	}
}
