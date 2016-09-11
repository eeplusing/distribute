 
package com.lixuan.tecent;  
import java.util.*;
public class SheXingJuZhen {
	  public static void main(String[] args){
	  	 Scanner sc = new Scanner(System.in); 
	    String str=sc.nextLine(); 
	    int n = Integer.parseInt(str);
	    int[][] result = new int[n][n];
	    int j = 0, k =0;
	    for(int i = 1; i <= n * n; i++){
	    	if(j == 0 || k == 0){
	    		result[j++][k++] = i;
	    	} 
	    	//if()
	    	
	      
	    
	    }
	    
	    
	    
	    System.out.printf("%s\n",str); 

	}

}
  
