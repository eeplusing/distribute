 
package com.lixuan.interview; 
import java.util.*;
public class LuDengDis {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()){
			int num = in.nextInt();    
			int len = in.nextInt();
			int[] cos = new int[num];
			for(int i = 0; i < num; i++){
				cos[i] = in.nextInt();
			}
			Arrays.sort(cos);
			int min = 0;
			for(int i = 0; i < cos.length - 1; i++){
				min = min < Math.abs(cos[i] - cos[i + 1])? min : Math.abs(cos[i] - cos[i + 1]);
			}
			double d = Math.min((double)min/2, Math.min(cos[0], Math.abs(cos[cos.length - 1] - len)));
			System.out.printf("%2f", d);
		}
	}
}
  
