package com.lixuan.interview;
public class FBNX
{
	public static void main(String[] args)
	{
		for(long i = 1; i <= 100; i++)
		{
			System.out.print(fbnx(i) + "  ");
		}
	}
	
	public static long fbnx(long n)
	{
		if(n == 1 || n == 2)
			return 1;
		else
			return fbnx(n - 1) + fbnx(n - 2);
	}
}
