 
package com.lixuan.interview;
import java.util.*;
import java.util.regex.Pattern;
public class Main1{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		//Pattern pattern = new Pattern.compile("\\w"); 
		Set set = new HashSet();
        while(in.hasNext("\\w")){
        	set.add(in.next());
        }
        System.out.println(set.size());
        in.close();
	}
}
  
