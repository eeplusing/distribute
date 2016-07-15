 
package com.lixuan.huawei.junior;
import java.util.Scanner;
public class LaDeng {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int labelNum = in.nextInt();
		boolean[] labels = new boolean[labelNum];
		for(int i = 1; i <= labelNum; i++)
		{
			for(int j = 0; j < labelNum; j++)
			{
				if((j+1) % i == 0)
				{
					labels[j] = !labels[j]; 
				}
			}
		}
		
		int sum = 0;
		for(int i = 0; i < labelNum; i++)
		{
			if(labels[i])
				sum++;
		}
		System.out.println(sum);
		System.out.println((int)Math.sqrt(labelNum));
		in.close();
	}
}
  
