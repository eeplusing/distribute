 
package com.lixuan.huaweiJiShi;  
import java.util.*;
public class Main{	
	static int monkDate[][] = new int[8][8];
	static int sum = 0;
	static ArrayList<Integer> arrangeList = new ArrayList<Integer>();//记录所有可能的情况
	static Integer arrange[] = new Integer[8];//记录一种挑水安排，如arrnage[1]=5表示周一由和尚五挑水
	static int visited[] = new int[8];//记录和尚是否已挑过水，如visited[2]=1,表示和尚2已参加过挑水，
										//visited[2]=0,表示和尚2没挑过水
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		/*输入数据初始化*/
	    for(int i=1;i<8;i++){
	        for(int j=1;j<8;j++){
	        	monkDate[i][j] = in.nextInt();
	        }
	    }
	    in.close();
	    //将安排初始化为0，将所有和尚都置为没挑过水
	    for(int i=1;i<8;i++){
	        arrange[i]=0;
	        visited[i]=0;
	    }
	    backHandle(1);
	    System.out.println(sum);
	    StringBuffer sb = new StringBuffer();
	    for(int i = 0; i < sum; i++){	    	
	    	for(int j = 0; j < 7; j++){
	    		if(j != 6){
	    			sb.append(arrangeList.get(i*7+j)+" ");
	    		}else{
	    			sb.append(arrangeList.get(i*7+j)+"\n");
	    		}
	    	}
	    }
	    System.out.print(sb.toString().substring(0, sb.length() - 1));
	}
	
	public static void backHandle(int t){//用递归来实现回溯，t代表第t天
	    if(t == 8){
	    	for(int i = 1; i < 8; i++){
	    		arrangeList.add(arrange[i]);
	    	}
	        sum++;
	    }
	    else{
	        for(int i = 1;i < 8;i++){
	            if(visited[i] == 0 && monkDate[i][t] == 1){
	            	arrange[t] = i;
	                visited[i] = 1;
	                backHandle(t+1);
	                visited[i]=0;
	            }
	        }
	    }
	}
}
  
