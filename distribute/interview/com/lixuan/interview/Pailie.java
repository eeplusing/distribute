 
package com.lixuan.interview;
import java.util.*;
public class Pailie 
{
	static int sum = 0;
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		//System.out.println(str.indexOf(str.charAt(1)));//字符第一次出现的位置
		pailie(str, "");
	}
	
	public static void pailie(String s, String p)
	{
		if(s.length() < 1)
		{
			System.out.println(p);
			sum++;
		}
		else
		{
			int index[] = new int[s.length()];
			for(int i = 0; i < s.length(); i++)
			{
				index[i] = s.indexOf(s.charAt(i));//将所有字符第一次出现的位置记录在index中,
					//index[i] = 0,表示第i个字符第一次出现的位置是0
			}
			for(int i = 0; i < s.length(); i++)
			{
				if(i == index[i])
				{
					pailie(s.substring(1), p + s.substring(0, 1));
				}
				s = s.substring(1) + s.substring(0, 1);
			}
		}
	}
}
  
