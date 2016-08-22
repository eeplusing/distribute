 
package com.lixuan.interview;  
import java.util.*;
public class PaoTaShangHai {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()){
			String[] arr = in.nextLine().split("\\s");
	        int R = Integer.parseInt(arr[0]);
	        int result = 0;
	        int x0 = Integer.parseInt(arr[arr.length - 2]);
	        int y0 = Integer.parseInt(arr[arr.length - 1]);
	        int x;
	        int y;
	        for(int i = 1; i < arr.length - 2; i = i + 2){
	            x = Integer.parseInt(arr[i]);
	            y = Integer.parseInt(arr[i + 1]);
	            if((x0 - x) * (x0 - x) + (y0 - y) * (y0 - y) <= R * R){
	                result++;
	            }
	        }
	        System.out.println(result + "x");
		}
	}
}
  
