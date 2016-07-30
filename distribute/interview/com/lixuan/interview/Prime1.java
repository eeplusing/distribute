 
package com.lixuan.interview;  
/*求素数 */
public class Prime1 {
	public static void main(String[] args){
		int a[] = new int[101];
		int i, j;
		for(i = 1; i < 101; i++)
		{
			a[i] = 1;
		}
		
		for(i = 2; i < 101; i++)
		{
			if(a[i] != 0)
			{
				for(j = i + 1; j < 101; j++)
				{
					if(j % i == 0)
					{
						a[j] = 0; 
					}
				}
			}
		}
		
		for(int k = 2; k < 101; k++)
		{
			if(a[k] != 0)
			{
				System.out.println(k);
			}
		}
		
	}
}
  
