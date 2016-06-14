package com.lixuan.huawei.junior;
import java.util.Scanner;
public class MaxLengthStr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String StrArr[] = str.split("\\s"); 
		maxCatenate(StrArr);
	}

	public static void maxCatenate(String[] text){  
        int[][] G = new int[text.length][text.length];  
        /*初始化邻接矩阵*/
        for(int i = 0; i < G.length; i++){  
            String suffix = text[i].substring(1);  
            for(int j = 0; j < G.length; j++)  
                if(text[j].indexOf(suffix) == 0)  
                    G[i][j] = 1;  
        }  
        for(int k = 0; k < G.length; k++){
        	for(int i = 0; i < G.length; i++){
        		for(int j = 0; j < G.length; j++){
        			if(G[i][k] != 0 && G[k][j] != 0){  
        				int dist = G[i][k] + G[k][j];  
        				if(dist > G[i][j]){  
        					G[i][j] = dist;  
        				}  
        			}  
        		}  
        	}  
        }  
        for(int i = 0; i < G.length; i++){
        	if(G[i][i]>1){  
        		System.out.println("circle is deteted!");  
        		return;  
        	}  
        }  
        int max = 0;  
        for(int i=0; i<G.length; i++){
        	for(int j=0; j<G.length; j++){
        		max = Math.max(max, G[i][j]);  
        	}  
        }  
        System.out.println("Max length is " + (max+text[0].length()));  
    }  
}
