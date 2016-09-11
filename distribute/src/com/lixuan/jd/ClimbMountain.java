 
package com.lixuan.jd;  
import java.util.*;
public class ClimbMountain
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int dayNum, noteNum;//总天数，未遗失的记录数
		while(in.hasNextInt())
		{
			dayNum = in.nextInt();//总天数
			noteNum = in.nextInt();//剩余的记录数
			Map<Integer, Integer> notes = new HashMap<Integer, Integer>();//存储没遗失的记录
			int[] days = new int[noteNum];
			int j = 0;
			int day, height;
			
			for(int i = 0; i < noteNum; i++){
				day = in.nextInt();
				height = in.nextInt();
				notes.put(day, height);
				days[j++] = day;
			}
			
			Arrays.sort(days);//天数从低到高排序
			int max = notes.get(days[0]) + days[0] - 1;//处理第一个记录之前
			
			for(int i = 1; i < noteNum; i++){
				int heightDif = Math.abs(notes.get(days[i]) - notes.get(days[i - 1]));
				int dayDif = Math.abs(days[i] - days[i - 1]);
				
				if(heightDif > dayDif){
					System.out.println("IMPOSIBLE");
					return;
				}
				
				max = Math.max(max, (dayDif + notes.get(days[i]) + notes.get(days[i -1]))/2);
			}
			
			 // 记录从最后一个点到末尾最高海拔  
	        max = Math.max(max, notes.get(days[noteNum - 1]) + dayNum - days[noteNum - 1]);  
	      
	        System.out.println(max);
		}
		in.close();
	}
}