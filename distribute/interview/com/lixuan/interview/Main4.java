 
package com.lixuan.interview;
import java.util.*;
public class Main4{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String str1 = in.nextLine();
		int min = 10000;
		int n = Integer.parseInt(str1.split("\\s")[0]);
		int m = Integer.parseInt(str1.split("\\s")[1]);
		for(int i = 0; i < n; i++){
			String str2 = in.nextLine();
			for(int j = 0; j < m; j++){
				int temp = Integer.parseInt(str2.substring(j, j + 1));
				min = min > temp ? min : temp;
			}
		}
        System.out.println(min);
        in.close();
	}
}
  
