 
package com.lixuan.jd;  
import java.util.*;
public class Main2
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int a, b;
        while(cin.hasNextInt())
        {
            a = cin.nextInt();
            b = cin.nextInt();
            StringBuffer sb = new StringBuffer();
            for(int i = a; i <= b; i++){
            	if(isTrue(i)){
            		sb.append(i + " ");
            	}
            }
            if(sb.length() < 1){
            	System.out.println("no");
            }else{
            	System.out.println(sb.deleteCharAt(sb.length() - 1));
            }
        }
        cin.close();
    }
    public static boolean isTrue(int num){
    	int temp = num;
    	int sum = 0;
    	while(temp != 0){
    		sum += Math.pow(temp % 10 ,3);
    		temp = temp / 10;
    	}
    	return sum == num;
    }
}