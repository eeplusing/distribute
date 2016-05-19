package com.lixuan.huawei.junior;

import java.util.Scanner;
import java.util.StringTokenizer;
public class Test3 {

	public static void main(String[] args) {  
        Scanner scan = new Scanner(System.in);  
        String  str = scan.nextLine();  
        int count = 0;  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < str.length(); i++) {  
            if(!Character.isLetter(str.charAt(i)) && !Character.isSpace(str.charAt(i))){  
                sb.append(str.charAt(i));  
                count++;  
            }  
        }  
        String bStr = sb.toString();  
        int top = 0;  
        String[][] strArr = new String[count][];  
        StringTokenizer st = new StringTokenizer(str, ",.!?");  
        while(st.hasMoreElements()){  
            strArr[top++] = st.nextToken().split(" ");  
        }  
        for (int i = 0; i < strArr.length; i++) {  
            reverse(strArr[i]);  
            System.out.print(bStr.charAt(i));  
        }  
    }  
  
  
    private static void reverse(String[] strArr) {  
        for (int i = 0; i < strArr.length; i++) { 
        	StringBuffer sb = new StringBuffer(strArr[i]);  
            String s = sb.reverse().toString();  
            System.out.print(s); 
            if(i!=strArr.length-1)  
                System.out.print(" ");  
        }  
    }  
}
