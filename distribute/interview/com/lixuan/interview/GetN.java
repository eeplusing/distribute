 
package com.lixuan.interview;  
public class GetN {
	public static void main(String[] args) {
		int n = 2;
		int res = 1;
		while((res + getOneNum(n)) != n)
		{
			res += getOneNum(n);
			n++;
		}
		System.out.println(n);
	}

	
	private static int getOneNum(int n) 
	{
		int result = 0;
		String str = n + "";
		for(int i = 0; i < str.length(); i++)
		{
			if('1' == str.charAt(i))
				result++;
		}
		return result;
	}

}
  
