 
package com.lixuan.interview;  
public class Prime2 {
	public static void main(String[] args)
	{
		int i, j;
		int a[] = new int[101];
		for(i = 2; i <= 100; i++)
		{
			for(j = 2; j <= Math.sqrt(i); j++)
			{
				if(i % j == 0)
					break;
			}
			if(j > Math.sqrt(i))
				System.out.println(i + " "); 
		}
		
	}
}
  
