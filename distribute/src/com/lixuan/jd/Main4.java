 
package com.lixuan.jd;  
import java.util.*;
public class Main4
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n, m;
        while(in.hasNextInt())
        {
            n = in.nextInt();
            m = in.nextInt();
            int[] arr = new int[n + 1];
            for(int i = 0; i < m; i++){
            	arr[in.nextInt()] = in.nextInt();
            }
            
            /*检查非法*/
            for(int i = 1; i < arr.length - 1; i++){
            	for(int j = i + 1; j < arr.length; j++){
            		if(Math.abs(j - i) < Math.abs(arr[j] - arr[i])){
            			System.out.println("IMPOSSIBLE");
            			return;
            		}
            	}
            }
            
            /*找最大值*/
            
            
            
        }
    }
}